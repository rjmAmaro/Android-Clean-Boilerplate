package com.kodelabs.boilerplate.storage;

import android.util.Log;

import com.kodelabs.boilerplate.domain.repository.MessageRepository;

/**
 * Created by ricar on 25/10/2016.
 */

public class WelcomeMessageRepository implements MessageRepository {
    @Override
    public String getWelcomeMessage() {
        Log.d("OUTER REPOSITORY", "@getWelcomeMessage()");
        String msg = "Welcome, friend!"; // let's be friendly

        // let's simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("OUTER REPOSITORY", "@getWelcomeMessage() - Message is about to be returned");
        return msg;
    }
}
