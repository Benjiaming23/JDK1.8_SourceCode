/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.robot;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

/**
 * Defines interface for generation of FX level events for purposes of test
 * automation, self running demos and other applications where control of the
 * mouse and keyboard is needed.
 * 
 */
public abstract class FXRobot {
    protected boolean autoWait = false;

    /**
     * Block until events in the queue are processed.
     */
    public abstract void waitForIdle();
    
    /**
     * Whether to wait for events to be processed after each robot command
     * @param wait if true, wait until events in the queue are processed
     */
    public void setAutoWaitForIdle(boolean wait) {
        wait = autoWait;
    }

    /**
     * Generate a key pressed event.
     * @param code key code for this event
     */
    public abstract void keyPress(KeyCode code);

    /**
     * Generate a key released event.
     *
     * Note that KeyTyped event will not be generated automatically on key
     * released,
     * {@link #keyType(javafx.scene.input.KeyCode, java.lang.String)} will
     * need to be called explicitly.
     * 
     * @param code key code for this event
     */
    public abstract void keyRelease(KeyCode code);

    /**
     * Generate a key typed event. The {@code keyChar} argument will need to
     * depend on what character is generated by this event. That is, the user
     * will need to take into account different modifiers currently applied and
     * so forth. If shift is presumed to be pressed, the char will be "A",
     * otherwise it will be "a".
     *
     * @param code key code for this event
     * @param keyChar char for this event 
     */
    public abstract void keyType(KeyCode code, String keyChar);

    /**
     * Generate a mouse moved event.
     * 
     * @param x scene coordinate x
     * @param y scene coordinate y
     */
    public abstract void mouseMove(int x, int y);

    /**
     * Generate a mouse press event with specified click count.
     *
     * Note that a multi-click gesture consists of multiple sets of 
     * MousePressed/MouseReleased/MouseClicked events, with second and following
     * sets having appropriate click count set.
     * <br>
     * For example, a double click is emulated with:
     * {@code press/release/click} followed by {@code press(2)/release(2)/click(2)}
     *
     * @param button button to have generated the event
     * @param clickCount number of clicks for this event
     */
    public abstract void mousePress(MouseButton button, int clickCount);

    /**
     * Generate a mouse release event with specified click count.
     *
     * Note that this method will not generate a MouseClicked event, use
     * {@link #mouseClick(javafx.scene.input.MouseButton) } for that.
     *
     * Note that a multi-click gesture consists of multiple sets of
     * MousePressed/MouseReleased/MouseClicked events, with second and following
     * sets having appropriate click count set.
     * <br>
     * For example, a double click is emulated with:
     * {@code press/release/click} followed by {@code press(2)/release(2)/click(2)}
     *
     * @param button button to have generated the event
     * @param clickCount number of clicks for this event
     */
    public abstract void mouseRelease(MouseButton button, int clickCount);
    
    /**
     * Generate a mouse clicked event with specified click count.
     *
     * Note that a multi-click gesture consists of multiple sets of
     * MousePressed/MouseReleased/MouseClicked events, with second and following
     * sets having appropriate click count set.
     * <br>
     * For example, a double click is emulated with:
     * {@code press/release/click} followed by {@code press(2)/release(2)/click(2)}
     *
     * @param button button to have generated the event
     * @param clickCount number of clicks for this event
     */
    public abstract void mouseClick(MouseButton button, int clickCount);

    /**
     * Generate a mouse pressed event with click count of 1.
     *
     * @param button button to have generated the event
     */
    public void mousePress(MouseButton button) {
        mousePress(button, 1);
    }
    
    /**
     * Generate a mouse pressed event with click count of 1.
     *
     * Note that this method will not generate a MouseClicked event, use
     * {@link #mouseClick(javafx.scene.input.MouseButton) } for that.
     *
     * @param button button to have generated the event
     */
    public void mouseRelease(MouseButton button) {
        mouseRelease(button, 1);
    }

    /**
     * Generate a mouse clicked event with click count of 1.
     *
     * @param button button to have generated the event
     */
    public void mouseClick(MouseButton button) {
        mouseClick(button, 1);
    }

    /**
     * Generate a mouse dragged event.
     *
     * @param button button to have generated the event
     */
    public abstract void mouseDrag(MouseButton button);

    /**
     * Generate a mouse wheel event.
     *
     * @param wheelAmt amount the wheel has turned of wheel turning
     */
    public abstract void mouseWheel(int wheelAmt);

    /**
     * Returns pixel color at specified scene coordinates in IntARGB format,
     * {@code 0} if the passed coordinates are outside of the scene's bounds or
     * if pixel grabbing isn't supported.
     * 
     * @param x scene coordinate
     * @param y scene coordinate
     * @return pixel color in IntARGB format or {@code 0} if outside of scene
     * bounds or if pixel grabbing isn't supported
     */
    public abstract int getPixelColor(int x, int y);

    /**
     * Returns a {@link FXRobotImage} object representing in image with contents 
     * of the scene at specified coordinates, or null if scene pixel capturing
     * isn't supported.
     *
     * Implementation note: current implementation ignores passed parameters and
     * always captures complete scene.
     * 
     * @param x scene coordinate
     * @param y scene coordinate
     * @param width of the area to capture
     * @param height of the area to capture
     * @return {@code FXRobotImage} containing captured pixels or null if pixel
     * capturing isn't supproted
     */
    public abstract FXRobotImage getSceneCapture(int x, int y, int width, int height);
}
