package com.keirnellyer.glencaldy.manipulation.property.type;

public abstract class BasicProperty<T> extends Property<T> {
    private final String askMsg;

    BasicProperty(String askMsg) {
        this(askMsg, true);
    }

    BasicProperty(String askMsg, boolean editable) {
        super();
        this.askMsg = askMsg;
        setEditable(editable);
    }

    @Override
    protected void ask() {
        System.out.println(askMsg);
    }
}
