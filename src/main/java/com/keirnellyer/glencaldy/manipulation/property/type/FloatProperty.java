package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;

public class FloatProperty extends BasicProperty<Float> {
    public FloatProperty(String askMsg) {
        super(askMsg);
    }

    @Override
    protected Float parse(String input) {
        return Float.parseFloat(input);
    }
}
