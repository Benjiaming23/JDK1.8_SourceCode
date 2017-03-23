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

package javafx.scene.layout;

/**
Builder class for javafx.scene.layout.VBox
@see javafx.scene.layout.VBox
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class VBoxBuilder<B extends javafx.scene.layout.VBoxBuilder<B>> extends javafx.scene.layout.PaneBuilder<B> {
    protected VBoxBuilder() {
    }
    
    /** Creates a new instance of VBoxBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.layout.VBoxBuilder<?> create() {
        return new javafx.scene.layout.VBoxBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.layout.VBox x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setAlignment(this.alignment);
        if ((set & (1 << 1)) != 0) x.setFillWidth(this.fillWidth);
        if ((set & (1 << 2)) != 0) x.setSpacing(this.spacing);
    }
    
    private javafx.geometry.Pos alignment;
    /**
    Set the value of the {@link javafx.scene.layout.VBox#getAlignment() alignment} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B alignment(javafx.geometry.Pos x) {
        this.alignment = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private boolean fillWidth;
    /**
    Set the value of the {@link javafx.scene.layout.VBox#isFillWidth() fillWidth} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B fillWidth(boolean x) {
        this.fillWidth = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private double spacing;
    /**
    Set the value of the {@link javafx.scene.layout.VBox#getSpacing() spacing} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B spacing(double x) {
        this.spacing = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.layout.VBox} based on the properties set on this builder.
    */
    public javafx.scene.layout.VBox build() {
        javafx.scene.layout.VBox x = new javafx.scene.layout.VBox();
        applyTo(x);
        return x;
    }
}