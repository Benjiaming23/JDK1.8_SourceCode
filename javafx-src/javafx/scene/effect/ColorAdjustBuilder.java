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

package javafx.scene.effect;

/**
Builder class for javafx.scene.effect.ColorAdjust
@see javafx.scene.effect.ColorAdjust
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class ColorAdjustBuilder<B extends javafx.scene.effect.ColorAdjustBuilder<B>> implements javafx.util.Builder<javafx.scene.effect.ColorAdjust> {
    protected ColorAdjustBuilder() {
    }
    
    /** Creates a new instance of ColorAdjustBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.effect.ColorAdjustBuilder<?> create() {
        return new javafx.scene.effect.ColorAdjustBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.effect.ColorAdjust x) {
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setBrightness(this.brightness);
        if ((set & (1 << 1)) != 0) x.setContrast(this.contrast);
        if ((set & (1 << 2)) != 0) x.setHue(this.hue);
        if ((set & (1 << 3)) != 0) x.setInput(this.input);
        if ((set & (1 << 4)) != 0) x.setSaturation(this.saturation);
    }
    
    private double brightness;
    /**
    Set the value of the {@link javafx.scene.effect.ColorAdjust#getBrightness() brightness} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B brightness(double x) {
        this.brightness = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private double contrast;
    /**
    Set the value of the {@link javafx.scene.effect.ColorAdjust#getContrast() contrast} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B contrast(double x) {
        this.contrast = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private double hue;
    /**
    Set the value of the {@link javafx.scene.effect.ColorAdjust#getHue() hue} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B hue(double x) {
        this.hue = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    private javafx.scene.effect.Effect input;
    /**
    Set the value of the {@link javafx.scene.effect.ColorAdjust#getInput() input} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B input(javafx.scene.effect.Effect x) {
        this.input = x;
        __set |= 1 << 3;
        return (B) this;
    }
    
    private double saturation;
    /**
    Set the value of the {@link javafx.scene.effect.ColorAdjust#getSaturation() saturation} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B saturation(double x) {
        this.saturation = x;
        __set |= 1 << 4;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.effect.ColorAdjust} based on the properties set on this builder.
    */
    public javafx.scene.effect.ColorAdjust build() {
        javafx.scene.effect.ColorAdjust x = new javafx.scene.effect.ColorAdjust();
        applyTo(x);
        return x;
    }
}
