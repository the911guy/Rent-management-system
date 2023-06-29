package com.houserental.accessingdatamysql;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(int id) {
        super("Could not find employee " + id);
    }
}
