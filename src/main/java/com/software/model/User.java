package com.software.model;

/**
 * Created by Andrey on 2/23/2018.
 */
public class User {

    private final String userName;
    private final String password;

    public User(final String userName, final String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
