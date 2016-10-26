package com.kodelabs.boilerplate.domain.model;

import android.util.Log;

/**
 * Created by ricar on 26/10/2016.
 */

public class Message {

    private String value;

    public Message(String value) {
        this.value = value;
        Log.v("MESSAGE", "Message object was created | value: " + value);
    }

    public String getValue() {
        return this.value;
    }
}
