package com.kodelabs.boilerplate.presentation.presenters.impl;

import android.util.Log;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.SampleInteractor;
import com.kodelabs.boilerplate.domain.interactors.WelcomingInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.WelcomeInteractorImpl;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.presentation.presenters.base.AbstractPresenter;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        WelcomingInteractor.Callback {

    private MainPresenter.View mView;
    private MessageRepository mMessageRepository;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view,
                             MessageRepository messageRepository) {
        super(executor, mainThread);
        mView = view;
        mMessageRepository = messageRepository;
        Log.d("PRESENTER", "MainPresenterImpl was created");
    }

    @Override
    public void resume() {
        Log.d("PRESENTER", "@resume()");
        mView.showProgress();

        // initialize the interactor
        WelcomingInteractor interactor = new WelcomeInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mMessageRepository
        );

        // run the interactor
        interactor.execute();
        Log.d("PRESENTER", "@resume() - END");
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
    public void onMessageRetrieved(String message) {
        Log.d("PRESENTER", "@onMessageRetrieved()");
        mView.hideProgress();
        mView.displayWelcomeMessage(message);
        Log.d("PRESENTER", "@onMessageRetrieved() - Message was displayed");
    }

    @Override
    public void onRetrievalFailed(String error) {
        mView.hideProgress();
        onError(error);
    }
}
