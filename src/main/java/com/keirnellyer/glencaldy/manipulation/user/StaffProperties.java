package com.keirnellyer.glencaldy.manipulation.user;

import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.type.IntegerProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;
import com.keirnellyer.glencaldy.user.Administrative;
import com.keirnellyer.glencaldy.user.Staff;
import com.keirnellyer.glencaldy.user.UserInfo;

public class StaffProperties extends CasualProperties {

    private final IntegerProperty staffIdProperty = new IntegerProperty("Please enter the staff id.", false);
    private final StringProperty emailProperty = new StringProperty("Please enter the email address.");
    private final StringProperty extensionProperty = new StringProperty("Please enter the extension.");

    public StaffProperties() {
        super();
        addProperty(staffIdProperty);
        addProperty(emailProperty);
        addProperty(extensionProperty);
    }

    private IntegerProperty getStaffIdProperty() {
        return staffIdProperty;
    }

    private StringProperty getEmailProperty() {
        return emailProperty;
    }

    private StringProperty getExtensionProperty() {
        return extensionProperty;
    }

    public Administrative createAdministrative(InputResult result) {
        UserInfo userInfo = processInput(result);
        return new Administrative(userInfo);
    }

    public Staff createStaff(InputResult result) {
        UserInfo userInfo = processInput(result);
        return new Staff(userInfo);
    }

    public void updateStaff(Staff user, InputResult result) {
        super.updateCasual(user, result);

        String email = result.getValue(emailProperty);
        String extension = result.getValue(extensionProperty);

        if (email != null) user.setEmail(email);
        if (extension != null) user.setExtension(extension);
    }

    @Override
    public UserInfo processInput(InputResult result) {
        UserInfo userInfo = new UserInfo();

        return userInfo
            .setUsername(result.getValue(getUsernameProperty()))
            .setPassword(result.getValue(getPasswordProperty()))
            .setAddress(result.getValue(getAddressProperty()))
            .setPhoneNumber(result.getValue(getPhoneProperty()))
            .setBirthDate(result.getValue(getBirthProperty()))
            .setStaffId(result.getValue(getStaffIdProperty()))
            .setEmail(result.getValue(getEmailProperty()))
            .setExtension(result.getValue(getExtensionProperty()));
    }
}
