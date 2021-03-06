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

package javafx.scene.control.cell;

/**
Builder class for javafx.scene.control.cell.ChoiceBoxTableCell
@see javafx.scene.control.cell.ChoiceBoxTableCell
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.2
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class ChoiceBoxTableCellBuilder<S, T, B extends javafx.scene.control.cell.ChoiceBoxTableCellBuilder<S, T, B>> extends javafx.scene.control.TableCellBuilder<S, T, B> {
    protected ChoiceBoxTableCellBuilder() {
    }
    
    /** Creates a new instance of ChoiceBoxTableCellBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static <S, T> javafx.scene.control.cell.ChoiceBoxTableCellBuilder<S, T, ?> create() {
        return new javafx.scene.control.cell.ChoiceBoxTableCellBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.control.cell.ChoiceBoxTableCell<S, T> x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setConverter(this.converter);
        if ((set & (1 << 1)) != 0) x.getItems().addAll(this.items);
    }
    
    private javafx.util.StringConverter<T> converter;
    /**
    Set the value of the {@link javafx.scene.control.cell.ChoiceBoxTableCell#getConverter() converter} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B converter(javafx.util.StringConverter<T> x) {
        this.converter = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private java.util.Collection<? extends T> items;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.cell.ChoiceBoxTableCell#getItems() items} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B items(java.util.Collection<? extends T> x) {
        this.items = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.cell.ChoiceBoxTableCell#getItems() items} property for the instance constructed by this builder.
    */
    public B items(T... x) {
        return items(java.util.Arrays.asList(x));
    }
    
    /**
    Make an instance of {@link javafx.scene.control.cell.ChoiceBoxTableCell} based on the properties set on this builder.
    */
    public javafx.scene.control.cell.ChoiceBoxTableCell<S, T> build() {
        javafx.scene.control.cell.ChoiceBoxTableCell<S, T> x = new javafx.scene.control.cell.ChoiceBoxTableCell<S, T>();
        applyTo(x);
        return x;
    }
}
