package com.example.db;

import com.example.models.Library;

public class MyDBFake {
    private static Library dbFake=new Library();

    public static Library getDbFake() {
        return dbFake;
    }
}
