package com.kodelabs.boilerplate.threading;

import com.kodelabs.boilerplate.domain.executor.MainThread;

/**
 * Created by ricar on 22/10/2016.
 */

public class TestMainThread implements MainThread{
    @Override
    public void post(Runnable runnable) {
        // tests can run on this thread, no need to invoke other threads
        runnable.run();
    }
}
