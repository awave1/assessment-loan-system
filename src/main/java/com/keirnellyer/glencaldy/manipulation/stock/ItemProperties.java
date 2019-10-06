package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.FloatProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

class ItemProperties extends PropertyManager {
    private final IntegerProperty idProperty = new IntegerProperty("Please enter the id.", false);
    private final StringProperty titleProperty = new StringProperty("Please enter the title.");
    private final StringProperty publisherProperty = new StringProperty("Please enter the publisher.");
    private final FloatProperty costProperty = new FloatProperty("Please enter the cost.");

    ItemProperties() {
        addProperty(idProperty);
        addProperty(titleProperty);
        addProperty(publisherProperty);
        addProperty(costProperty);
    }

    IntegerProperty getIdProperty() {
        return idProperty;
    }

    StringProperty getTitleProperty() {
        return titleProperty;
    }

    StringProperty getPublisherProperty() {
        return publisherProperty;
    }

    FloatProperty getCostProperty() {
        return costProperty;
    }

    void updateItem(Item item, InputResult result) {
        String title = result.getValue(titleProperty);
        String publisher = result.getValue(publisherProperty);
        Float cost = result.getValue(costProperty);

        if (title != null) item.setName(title);
        if (publisher != null) item.setPublisher(publisher);
        if (cost != null) item.setCost(cost);
    }
}
