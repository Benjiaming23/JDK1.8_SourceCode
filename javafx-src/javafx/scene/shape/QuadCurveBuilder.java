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

package javafx.scene.shape;

/**
Builder class for javafx.scene.shape.QuadCurve
@see javafx.scene.shape.QuadCurve
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class QuadCurveBuilder<B extends javafx.scene.shape.QuadCurveBuilder<B>> extends javafx.scene.shape.ShapeBuilder<B> implements javafx.util.Builder<javafx.scene.shape.QuadCurve> {
    protected QuadCurveBuilder() {
    }
    
    /** Creates a new instance of QuadCurveBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.shape.QuadCurveBuilder<?> create() {
        return new javafx.scene.shape.QuadCurveBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.shape.QuadCurve x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setControlX(this.controlX);
        if ((set & (1 << 1)) != 0) x.setControlY(this.controlY);
        if ((set & (1 << 2)) != 0) x.setEndX(this.endX);
        if ((set & (1 << 3)) != 0) x.setEndY(this.endY);
        if ((set & (1 << 4)) != 0) x.setStartX(this.startX);
        if ((set & (1 << 5)) != 0) x.setStartY(this.startY);
    }
    
    private double controlX;
    /**
    Set the value of the {@link javafx.scene.shape.QuadCurve#getControlX() controlX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B controlX(double x) {
        this.controlX = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private double controlY;
    /**
    Set the value of the {@link javafx.scene.shape.QuadCurve#getControlY() controlY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B controlY(double x) {
        this.controlY = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private double endX;
    /**
    Set the value of the {@link javafx.scene.shape.QuadCurve#getEndX() endX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B endX(double x) {
        this.endX = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    private double endY;
    /**
    Set the value of the {@link javafx.scene.shape.QuadCurve#getEndY() endY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B endY(double x) {
        this.endY = x;
        __set |= 1 << 3;
        return (B) this;
    }
    
    private double startX;
    /**
    Set the value of the {@link javafx.scene.shape.QuadCurve#getStartX() startX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B startX(double x) {
        this.startX = x;
        __set |= 1 << 4;
        return (B) this;
    }
    
    private double startY;
    /**
    Set the value of the {@link javafx.scene.shape.QuadCurve#getStartY() startY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B startY(double x) {
        this.startY = x;
        __set |= 1 << 5;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.shape.QuadCurve} based on the properties set on this builder.
    */
    public javafx.scene.shape.QuadCurve build() {
        javafx.scene.shape.QuadCurve x = new javafx.scene.shape.QuadCurve();
        applyTo(x);
        return x;
    }
}
