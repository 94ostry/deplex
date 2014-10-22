package com.pioost.dependency;

/**
 * Created by pioost on 10/21/14.
 */
public interface Bindable {

    Object getValue();

    void setValue( Object value );

    void onValueChange(ValueChangeListener valueChangeListener);

    public interface ValueChangeListener
    {
        public void onValueChange();
    }
}
