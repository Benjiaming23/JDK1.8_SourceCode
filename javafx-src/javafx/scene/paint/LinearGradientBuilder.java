/* 
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.paint;

/**
Builder class for javafx.scene.paint.LinearGradient
@see javafx.scene.paint.LinearGradient
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public final class LinearGradientBuilder implements javafx.util.Builder<javafx.scene.paint.LinearGradient> {
    protected LinearGradientBuilder() {
    }
    
    /** Creates a new instance of LinearGradientBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.paint.LinearGradientBuilder create() {
        return new javafx.scene.paint.LinearGradientBuilder();
    }
    
    private javafx.scene.paint.CycleMethod cycleMethod;
    /**
    Set the value of the {@link javafx.scene.paint.LinearGradient#getCycleMethod() cycleMethod} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder cycleMethod(javafx.scene.paint.CycleMethod x) {
        this.cycleMethod = x;
        return this;
    }
    
    private double endX = 1;
    /**
    Set the value of the {@link javafx.scene.paint.LinearGradient#getEndX() endX} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder endX(double x) {
        this.endX = x;
        return this;
    }
    
    private double endY = 1;
    /**
    Set the value of the {@link javafx.scene.paint.LinearGradient#getEndY() endY} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder endY(double x) {
        this.endY = x;
        return this;
    }
    
    private boolean proportional = true;
    /**
    Set the value of the {@link javafx.scene.paint.LinearGradient#isProportional() proportional} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder proportional(boolean x) {
        this.proportional = x;
        return this;
    }
    
    private double startX;
    /**
    Set the value of the {@link javafx.scene.paint.LinearGradient#getStartX() startX} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder startX(double x) {
        this.startX = x;
        return this;
    }
    
    private double startY;
    /**
    Set the value of the {@link javafx.scene.paint.LinearGradient#getStartY() startY} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder startY(double x) {
        this.startY = x;
        return this;
    }
    
    private java.util.List<javafx.scene.paint.Stop> stops;
    /**
    Add the given items to the List of items in the {@link javafx.scene.paint.LinearGradient#getStops() stops} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder stops(java.util.List<javafx.scene.paint.Stop> x) {
        this.stops = x;
        return this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.paint.LinearGradient#getStops() stops} property for the instance constructed by this builder.
    */
    public javafx.scene.paint.LinearGradientBuilder stops(javafx.scene.paint.Stop... x) {
        return stops(java.util.Arrays.asList(x));
    }
    
    /**
    Make an instance of {@link javafx.scene.paint.LinearGradient} based on the properties set on this builder.
    */
    public javafx.scene.paint.LinearGradient build() {
        javafx.scene.paint.LinearGradient x = new javafx.scene.paint.LinearGradient(this.startX, this.startY, this.endX, this.endY, this.proportional, this.cycleMethod, this.stops);
        return x;
    }
}
