package com.kodelabs.boilerplate.presentation.presenters;

import com.kodelabs.boilerplate.presentation.presenters.base.BasePresenter;
import com.kodelabs.boilerplate.presentation.ui.BaseView;

/**
 * Created by ricar on 26/10/2016.
 */

public interface StoreAndUpdateMessagePresenter extends BasePresenter {

    interface View extends BaseView {
        void updateMessage(String msg);
    }

    void storeAndUpdateMessage(String message);
}
