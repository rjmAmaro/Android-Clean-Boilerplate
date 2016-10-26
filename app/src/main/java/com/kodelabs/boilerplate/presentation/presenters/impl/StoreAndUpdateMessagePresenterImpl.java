package com.kodelabs.boilerplate.presentation.presenters.impl;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.StoreAndUpdateMessageInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.StoreAndUpdateMessageInteractorImpl;
import com.kodelabs.boilerplate.presentation.presenters.StoreAndUpdateMessagePresenter;
import com.kodelabs.boilerplate.presentation.presenters.base.AbstractPresenter;

/**
 * Created by ricar on 26/10/2016.
 */

public class StoreAndUpdateMessagePresenterImpl extends AbstractPresenter implements StoreAndUpdateMessagePresenter, StoreAndUpdateMessageInteractor.Callback {

    private StoreAndUpdateMessagePresenter.View mView;

    public StoreAndUpdateMessagePresenterImpl(
            Executor executor,
            MainThread mainThread,
            View view) {
        super(executor, mainThread);
        mView = view;
    }

    @Override
    public void storeAndUpdateMessage(String message) {
        StoreAndUpdateMessageInteractor interactor = new StoreAndUpdateMessageInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                message
        );

        interactor.execute();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void updateMessage(String message) {
        mView.updateMessage(message);
    }
}
