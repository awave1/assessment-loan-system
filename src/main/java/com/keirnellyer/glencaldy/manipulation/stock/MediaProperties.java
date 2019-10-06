package com.keirnellyer.glencaldy.manipulation.stock;

import com.keirnellyer.glencaldy.item.Media;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;

class MediaProperties extends ItemProperties {
    private final IntegerProperty runningTimeProperty = new IntegerProperty("Please enter the " +
            "running time.");
    private final StringProperty caseTypeProperty = new StringProperty("Please enter the case type.");

    MediaProperties() {
        super();

        addProperty(runningTimeProperty);
        addProperty(caseTypeProperty);
    }

    IntegerProperty getRunningTimeProperty() {
        return runningTimeProperty;
    }

    StringProperty getCaseTypeProperty() {
        return caseTypeProperty;
    }

    void updateMedia(Media item, InputResult result) {
        super.updateItem(item, result);

        Integer runningTime = result.getValue(runningTimeProperty);
        String caseType = result.getValue(caseTypeProperty);

        if (runningTime != null) item.setRunningTime(runningTime);
        if (caseType != null) item.setCaseType(caseType);
    }
}
