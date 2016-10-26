package com.kodelabs.boilerplate.domain.interactors.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.StoreAndUpdateMessageInteractor;
import com.kodelabs.boilerplate.domain.interactors.base.AbstractInteractor;
import com.kodelabs.boilerplate.domain.model.Message;
import com.kodelabs.boilerplate.presentation.presenters.impl.StoreAndUpdateMessagePresenterImpl;

/**
 * Created by ricar on 26/10/2016.
 */

public class StoreAndUpdateMessageInteractorImpl extends AbstractInteractor implements StoreAndUpdateMessageInteractor {

    private StoreAndUpdateMessageInteractor.Callback mCallback;

    private String message;

    public StoreAndUpdateMessageInteractorImpl(
            Executor executor,
            MainThread mainThread,
            Callback callback,
            String message) {
        super(executor, mainThread);
        this.mCallback = callback;
        this.message = message;
    }

    @Override
    public void run() {
        final Message myMessage = new Message(this.message);

        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.updateMessage(myMessage.getValue());
            }
        });
    }
}
