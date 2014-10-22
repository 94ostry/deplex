package com.pioost.dependency;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * Created by pioost on 10/21/14.
 */
public class TextFiledBindable implements Bindable {

    private final TextField textField;

    public TextFiledBindable(TextField textField) {
        this.textField = textField;

        this.textField.focusedProperty().addListener( new ChangeListener<Boolean>() {
            @Override public void changed(ObservableValue<? extends Boolean> observable,
                Boolean oldValue,
                Boolean newValue) {

                System.out.println("Alamakota" + oldValue + newValue);
            }
        });

    }

    @Override public Object getValue()
    {
        return textField.getText();
    }

    @Override public void setValue(Object value)
    {
        textField.setText((String) value);

    }

    @Override public void onValueChange(ValueChangeListener valueChangeListener)
    {
        textField.textProperty().addListener( new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> observable,
                String oldValue,
                String newValue) {

                valueChangeListener.onValueChange();
            }
        });

    }
}
