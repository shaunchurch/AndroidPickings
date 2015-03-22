package com.shaunchurch.androidpickings.ui.hello;

import javax.inject.Inject;

/**
 * Created by shaun on 22/03/15.
 */
public class MessageSupplierImpl implements MessageSupplier {

    @Inject
    public MessageSupplierImpl() {
    }

    @Override
    public String getMessage() {
        return "Implemented!";
    }
}
