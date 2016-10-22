package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.impl.WelcomeInteractorImpl;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Tests our welcoming interactor.
 *
 * Created by ricar on 22/10/2016.
 */

public class GetWelcomeMessageTest {

    private MainThread mMainThread;
    @Mock private Executor mExecutor;
    @Mock private MessageRepository mMessageRepository;
    @Mock private WelcomingInteractor.Callback mMockedCallback;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testWelcomeMessageFound() throws Exception {
        String msg = "Welcome, friend!";

        when(mMessageRepository.getWelcomeMessage()).thenReturn(msg);

        WelcomeInteractorImpl interactor = new WelcomeInteractorImpl(
                mExecutor,
                mMainThread,
                mMockedCallback,
                mMessageRepository);
        interactor.run();

        Mockito.verify(mMessageRepository).getWelcomeMessage();
        Mockito.verifyNoMoreInteractions(mMessageRepository);
        Mockito.verify(mMockedCallback).onMessageRetrieved(msg);
    }
}
