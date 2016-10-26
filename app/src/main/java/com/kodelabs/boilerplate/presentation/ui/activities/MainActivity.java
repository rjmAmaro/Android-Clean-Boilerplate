package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.executor.impl.ThreadExecutor;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;
import com.kodelabs.boilerplate.presentation.presenters.StoreAndUpdateMessagePresenter;
import com.kodelabs.boilerplate.presentation.presenters.impl.MainPresenterImpl;
import com.kodelabs.boilerplate.presentation.presenters.impl.StoreAndUpdateMessagePresenterImpl;
import com.kodelabs.boilerplate.storage.WelcomeMessageRepository;
import com.kodelabs.boilerplate.threading.MainThreadImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View, StoreAndUpdateMessagePresenter.View {

    @Bind(R.id.welcome_textview)
    TextView mWelcomeTextView;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ACTIVITY", "@onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // create a presenter for this view
        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new WelcomeMessageRepository()
        );
        Log.d("ACTIVITY", "@onCreate() - END");
    }

    @Override
    protected void onResume() {
        Log.d("ACTIVITY", "@onResume()");
        super.onResume();

        // let's start welcome message retrieval when the app resumes
        mPresenter.resume();
        Log.d("ACTIVITY", "@onResume() - END");
    }

    @Override
    public void showProgress() {
        mWelcomeTextView.setText("Retrieving...");
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this, "Retrieved!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        mWelcomeTextView.setText(message);
    }

    @Override
    public void displayWelcomeMessage(String msg) {
        Log.d("ACTIVITY", "@displayWelcomeMessage()");
        mWelcomeTextView.setText(msg);
        Log.d("ACTIVITY", "@displayWelcomeMessage() - END");
    }

    public void changeText(android.view.View view) {
        EditText editText = (EditText) findViewById(R.id.edit_welcome_text);
        String text = editText.getText().toString();

        StoreAndUpdateMessagePresenter storeAndUpdatePresenter = new StoreAndUpdateMessagePresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this
        );

        storeAndUpdatePresenter.storeAndUpdateMessage(text);
    }

    @Override
    public void updateMessage(String msg) {
        mWelcomeTextView.setText(msg);
        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
}
