package com.shaunchurch.androidpickings.ui.hello;

import javax.inject.Inject;

public class HelloPresenterImpl implements HelloPresenter {

    private final HelloView view;
    private final HelloSupplier messageSupplier;

    @Inject
    public HelloPresenterImpl(HelloView view, HelloSupplier messageSupplier) {
        this.view = view;
        this.messageSupplier = messageSupplier;
    }

    @Override
    public void requestMessage() {
        view.onMessageUpdated(messageSupplier.getMessage());
    }
}
