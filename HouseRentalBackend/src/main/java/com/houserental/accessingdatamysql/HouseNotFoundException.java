package com.houserental.accessingdatamysql;

public class HouseNotFoundException extends RuntimeException {
    HouseNotFoundException(int id) {
        super("Could not find employee " + id);
    }
}
