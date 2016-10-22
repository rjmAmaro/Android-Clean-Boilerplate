package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;

/**
 * Created by ricar on 22/10/2016.
 */

public interface WelcomingInteractor extends Interactor {

    interface Callback {

        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);

    }
}
