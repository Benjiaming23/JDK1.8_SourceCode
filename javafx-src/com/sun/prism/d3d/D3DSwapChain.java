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

package com.sun.prism.d3d;

import com.sun.glass.ui.Screen;
import com.sun.javafx.geom.Rectangle;
import com.sun.prism.CompositeMode;
import com.sun.prism.Graphics;
import com.sun.prism.Presentable;
import com.sun.prism.PresentableState;
import com.sun.prism.RTTexture;

class D3DSwapChain
    extends D3DResource
    implements D3DRenderTarget, Presentable, D3DContextSource {

    private final D3DRTTexture texBackBuffer;

    D3DSwapChain(D3DContext context, long pResource, D3DRTTexture rtt) {
        super(new D3DRecord(context, pResource));
        texBackBuffer = rtt;
    }

    @Override
    public void dispose() {
        texBackBuffer.dispose();
        super.dispose();
    }

    public boolean prepare(Rectangle clip) {
        D3DContext context = getContext();
        context.flushVertexBuffer();
        D3DGraphics g = (D3DGraphics) D3DGraphics.create(this, context);
        if (g == null) {
            return false;
        }
        Rectangle rectDST = new Rectangle(0, 0, this.getContentWidth(), this.getContentHeight());
        if (clip != null) {
            rectDST.intersectWith(clip);
        }
        int x0 = rectDST.x;
        int y0 = rectDST.y;
        int x1 = x0 + rectDST.width;
        int y1 = y0 + rectDST.height;
        if (isMSAA()) {
            context.flushVertexBuffer();
            g.blit(texBackBuffer, null, x0, y0, x1, y1, x0, y0, x1, y1);
        } else {
            g.setCompositeMode(CompositeMode.SRC);
            g.drawTexture(texBackBuffer, x0, y0, x1, y1);
        }
        context.flushVertexBuffer();
        texBackBuffer.unlock();
        return true;
    }

    public boolean present() {
        D3DContext context = getContext();
        int res = nPresent(context.getContextHandle(), d3dResRecord.getResource());
        return context.validatePresent(res);
    }

    public long getResourceHandle() {
        return d3dResRecord.getResource();
    }

    public int getPhysicalWidth() {
        return D3DResourceFactory.nGetTextureWidth(d3dResRecord.getResource());
    }

    public int getPhysicalHeight() {
        return D3DResourceFactory.nGetTextureHeight(d3dResRecord.getResource());
    }

    public int getContentWidth() {
        return getPhysicalWidth();
    }

    public int getContentHeight() {
        return getPhysicalHeight();
    }

    public int getContentX() {
        return 0;
    }

    public int getContentY() {
        return 0;
    }

    private static native int nPresent(long context, long pSwapChain);

    public D3DContext getContext() {
        return d3dResRecord.getContext();
    }

    public boolean lockResources(PresentableState pState) {
        if (pState.getWidth() != getPhysicalWidth() ||
            pState.getHeight() != getPhysicalHeight())
        {
            return true;
        }
        texBackBuffer.lock();
        return texBackBuffer.isSurfaceLost();
    }

    public Graphics createGraphics() {
        return D3DGraphics.create(texBackBuffer, getContext());
    }

    public RTTexture getRTTBackBuffer() {
        return texBackBuffer;
    }

    public Screen getAssociatedScreen() {
        return getContext().getAssociatedScreen();
    }

    public float getPixelScaleFactor() {
        return 1.0f;
    }

    public boolean isOpaque() {
        return texBackBuffer.isOpaque();
    }

    public void setOpaque(boolean opaque) {
        texBackBuffer.setOpaque(opaque);
    }

    public boolean isMSAA() {
        return texBackBuffer != null ? texBackBuffer.isMSAA() : false;
    }
}
