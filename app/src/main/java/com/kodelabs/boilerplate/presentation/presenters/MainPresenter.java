package com.kodelabs.boilerplate.presentation.presenters;

import com.kodelabs.boilerplate.presentation.presenters.base.BasePresenter;
import com.kodelabs.boilerplate.presentation.ui.BaseView;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        // TODO: Add your view methods
        void displayWelcomeMessage(String msg);
    }

    // TODO: Add your presenter methods

}
