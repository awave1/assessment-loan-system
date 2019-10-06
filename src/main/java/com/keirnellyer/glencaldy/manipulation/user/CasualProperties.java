package com.keirnellyer.glencaldy.manipulation.user;

import com.keirnellyer.glencaldy.manipulation.property.type.LocalDateProperty;
import com.keirnellyer.glencaldy.manipulation.property.type.StringProperty;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.user.Casual;
import com.keirnellyer.glencaldy.user.Member;
import com.keirnellyer.glencaldy.user.UserInfo;

import java.time.LocalDate;

public class CasualProperties extends UserProperties {
    private final StringProperty addressProperty = new StringProperty("Please enter the address.");
    private final StringProperty phoneProperty = new StringProperty("Please enter the phone number.");
    private final LocalDateProperty birthProperty = new LocalDateProperty("Please enter the birth date.");

    public CasualProperties() {
        super();
        addProperty(addressProperty);
        addProperty(phoneProperty);
        addProperty(birthProperty);
    }

    StringProperty getAddressProperty() {
        return addressProperty;
    }

    StringProperty getPhoneProperty() {
        return phoneProperty;
    }

    LocalDateProperty getBirthProperty() {
        return birthProperty;
    }

    public Member createFullMember(InputResult result) {
        UserInfo userInfo = processInput(result);
        return new Member(userInfo);
    }

    public Casual createCasual(InputResult result) {
        UserInfo userInfo = processInput(result);
        return new Casual(userInfo);
    }

    @Override
    public UserInfo processInput(InputResult result) {
        UserInfo userInfo = new UserInfo();
        return userInfo
            .setUsername(result.getValue(getUsernameProperty()))
            .setPassword(result.getValue(getPasswordProperty()))
            .setAddress(result.getValue(getAddressProperty()))
            .setPhoneNumber(result.getValue(getPhoneProperty()))
            .setBirthDate(result.getValue(getBirthProperty()));
    }

    public void updateCasual(Casual user, InputResult result) {
        super.updateUser(user, result);

        String address = result.getValue(addressProperty);
        String phone = result.getValue(phoneProperty);
        LocalDate birth = result.getValue(birthProperty);

        if (address != null) user.setAddress(address);
        if (phone != null)  user.setPhoneNumber(phone);
        if (birth != null) user.setBirthDate(birth);
    }
}
