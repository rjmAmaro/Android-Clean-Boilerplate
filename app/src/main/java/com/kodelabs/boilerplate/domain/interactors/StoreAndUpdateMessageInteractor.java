package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.interactors.base.Interactor;

/**
 * Created by ricar on 26/10/2016.
 */

public interface StoreAndUpdateMessageInteractor extends Interactor {

    interface Callback {
        void updateMessage(String message);
    }
}
