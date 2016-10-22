package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;

public class MainActivity extends AppCompatActivity implements View {

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // let's start welcome message retrieval when the app resumes
        mPresenter.resume();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
