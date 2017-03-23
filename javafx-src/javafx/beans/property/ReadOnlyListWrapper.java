/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.beans.property;

import com.sun.javafx.binding.ListExpressionHelper;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import static javafx.collections.ListChangeListener.Change;

/**
 * This class provides a convenient class to define read-only properties. It
 * creates two properties that are synchronized. One property is read-only
 * and can be passed to external users. The other property is read- and
 * writable and should be used internally only.
 *
 * @since JavaFX 2.1
 */
public class ReadOnlyListWrapper<E> extends SimpleListProperty<E> {

    private ReadOnlyPropertyImpl readOnlyProperty;

    /**
     * The constructor of {@code ReadOnlyListWrapper}
     */
    public ReadOnlyListWrapper() {
    }

    /**
     * The constructor of {@code ReadOnlyListWrapper}
     *
     * @param initialValue
     *            the initial value of the wrapped value
     */
    public ReadOnlyListWrapper(ObservableList<E> initialValue) {
        super(initialValue);
    }

    /**
     * The constructor of {@code ReadOnlyListWrapper}
     *
     * @param bean
     *            the bean of this {@code ReadOnlyListWrapper}
     * @param name
     *            the name of this {@code ReadOnlyListWrapper}
     */
    public ReadOnlyListWrapper(Object bean, String name) {
        super(bean, name);
    }

    /**
     * The constructor of {@code ReadOnlyListWrapper}
     *
     * @param bean
     *            the bean of this {@code ReadOnlyListWrapper}
     * @param name
     *            the name of this {@code ReadOnlyListWrapper}
     * @param initialValue
     *            the initial value of the wrapped value
     */
    public ReadOnlyListWrapper(Object bean, String name,
            ObservableList<E> initialValue) {
        super(bean, name, initialValue);
    }

    /**
     * Returns the readonly property, that is synchronized with this
     * {@code ReadOnlyListWrapper}.
     *
     * @return the readonly property
     */
    public ReadOnlyListProperty<E> getReadOnlyProperty() {
        if (readOnlyProperty == null) {
            readOnlyProperty = new ReadOnlyPropertyImpl();
        }
        return readOnlyProperty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(InvalidationListener listener) {
        getReadOnlyProperty().addListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(InvalidationListener listener) {
        if (readOnlyProperty != null) {
            readOnlyProperty.removeListener(listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(ChangeListener<? super ObservableList<E>> listener) {
        getReadOnlyProperty().addListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(ChangeListener<? super ObservableList<E>> listener) {
        if (readOnlyProperty != null) {
            readOnlyProperty.removeListener(listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(ListChangeListener<? super E> listener) {
        getReadOnlyProperty().addListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(ListChangeListener<? super E> listener) {
        if (readOnlyProperty != null) {
            readOnlyProperty.removeListener(listener);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void fireValueChangedEvent() {
        if (readOnlyProperty != null) {
            readOnlyProperty.fireValueChangedEvent();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void fireValueChangedEvent(Change<? extends E> change) {
        if (readOnlyProperty != null) {
            readOnlyProperty.fireValueChangedEvent(change);
        }
    }

    private class ReadOnlyPropertyImpl extends ReadOnlyListProperty<E> {

        private ListExpressionHelper<E> helper = null;

        @Override
        public ObservableList<E> get() {
            return ReadOnlyListWrapper.this.get();
        }

        @Override
        public void addListener(InvalidationListener listener) {
            helper = ListExpressionHelper.addListener(helper, this, listener);
        }

        @Override
        public void removeListener(InvalidationListener listener) {
            helper = ListExpressionHelper.removeListener(helper, listener);
        }

        @Override
        public void addListener(ChangeListener<? super ObservableList<E>> listener) {
            helper = ListExpressionHelper.addListener(helper, this, listener);
        }

        @Override
        public void removeListener(ChangeListener<? super ObservableList<E>> listener) {
            helper = ListExpressionHelper.removeListener(helper, listener);
        }

        @Override
        public void addListener(ListChangeListener<? super E> listener) {
            helper = ListExpressionHelper.addListener(helper, this, listener);
        }

        @Override
        public void removeListener(ListChangeListener<? super E> listener) {
            helper = ListExpressionHelper.removeListener(helper, listener);
        }

        private void fireValueChangedEvent() {
            ListExpressionHelper.fireValueChangedEvent(helper);
        }

        private void fireValueChangedEvent(Change<? extends E> change) {
            ListExpressionHelper.fireValueChangedEvent(helper, change);
        }

        @Override
        public Object getBean() {
            return ReadOnlyListWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyListWrapper.this.getName();
        }

        @Override
        public ReadOnlyIntegerProperty sizeProperty() {
            return ReadOnlyListWrapper.this.sizeProperty();
        }

        @Override
        public ReadOnlyBooleanProperty emptyProperty() {
            return ReadOnlyListWrapper.this.emptyProperty();
        }
    }
}
