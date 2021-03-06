/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.javafx.iio.png;

import com.sun.javafx.iio.common.ImageTools;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * A stream which exposes only the IDAT chunk data content of a PNG stream.
 *
 * <p>Once all IDAT chunks have been read, the <code>read()</code> methods will
 * return <code>-1</code> and <code>isFoundAllIDATChunks()</code>
 * <code>true</code>. Once <code>isFoundAllIDATChunks()</code> returns
 * <code>true</code>, the length and type of the first chunk after the last
 * IDAT chunk may be found by calling <code>getNextChunkLength()</code> and
 * <code>getNextChunkType()</code>, respectively. The source stream will at
 * this point be positioned at the first byte of the data field after the last
 * IDAT chunk (which could be the first byte of the CRC code if the length is
 * zero).</p>
 */
public class PNGIDATChunkInputStream extends InputStream {

    static final int IDAT_TYPE = 0x49444154;

    private DataInputStream source;
    private int numBytesAvailable = 0;
    private boolean foundAllIDATChunks = false;
    private int nextChunkLength = 0;
    private int nextChunkType = 0;

    /**
     * Create the stream.
     *
     * @param input stream positioned at the beginning of the data field of the
     * first IDAT chunk in the PNG stream.
     * @param firstIDATChunkLength the length of the data field of the first
     * IDAT chunk.
     */
    PNGIDATChunkInputStream(DataInputStream input, int firstIDATChunkLength) {
        this.source = input;
        this.numBytesAvailable = firstIDATChunkLength;
    }

    private void nextChunk() throws IOException {
        if (!foundAllIDATChunks) {
            ImageTools.skipFully(source, 4); // CRC
            int chunkLength = source.readInt();
            int chunkType = source.readInt();
            if (chunkType == IDAT_TYPE) {
                numBytesAvailable += chunkLength;
            } else {
                foundAllIDATChunks = true;
                nextChunkLength = chunkLength;
                nextChunkType = chunkType;
            }
        }
    }

    boolean isFoundAllIDATChunks() {
        return foundAllIDATChunks;
    }

    int getNextChunkLength() {
        return nextChunkLength;
    }

    int getNextChunkType() {
        return nextChunkType;
    }

    @Override
    public int read() throws IOException {
        if (numBytesAvailable == 0) {
            nextChunk();
        }

        if (numBytesAvailable == 0) {
            return -1;
        } else {
            --numBytesAvailable;
            return source.read();
        }
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (numBytesAvailable == 0) {
            nextChunk();
            if (numBytesAvailable == 0) {
                return -1;
            }
        }

        int totalRead = 0;
        while (numBytesAvailable > 0 && len > 0) {
            int numToRead = len < numBytesAvailable ? len : numBytesAvailable;

            int numRead = source.read(b, off, numToRead);
            if (numRead == -1) {
                throw new EOFException();
            }

            numBytesAvailable -= numRead;
            off += numRead;
            len -= numRead;
            totalRead += numRead;
            if (numBytesAvailable == 0 && len > 0) {
                nextChunk();
            }
        }

        return totalRead;
    }
}

