package com.keirnellyer.glencaldy;

public class Session {
    private int computerId;
    private final long loginTime;
    private Long logoutTime = null;

    public Session(int computerId) {
        this(computerId, System.currentTimeMillis());
    }

    private Session(int computerId, long loginTime) {
        this.computerId = computerId;
        this.loginTime = loginTime;
    }

    public void setLogoutTime(Long logoutTime) {
        this.logoutTime = logoutTime;
    }

    public boolean isActive() {
        return this.logoutTime == null;
    }

    @Override
    public String toString() {
        return "Session{" +
                "computerId=" + computerId +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                '}';
    }
}
