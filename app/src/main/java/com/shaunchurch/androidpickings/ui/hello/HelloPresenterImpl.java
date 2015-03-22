package com.shaunchurch.androidpickings.ui.hello;

import javax.inject.Inject;

/**
 * Created by shaun on 22/03/15.
 */
public class HelloPresenterImpl implements HelloPresenter {

    private final HelloView view;
    private final MessageSupplier messageSupplier;

    @Inject
    public HelloPresenterImpl(HelloView view, MessageSupplier messageSupplier) {
        this.view = view;
        this.messageSupplier = messageSupplier;
    }

    @Override
    public void requestMessage() {
        view.onMessageUpdated(messageSupplier.getMessage());
    }
}
