package com.shaunchurch.androidpickings.ui.hello;

import javax.inject.Inject;

public class HelloSupplierImpl implements HelloSupplier {

    private final HelloTimeService helloTimeService;

    @Inject
    public HelloSupplierImpl(HelloTimeService helloTimeService) {
        this.helloTimeService = helloTimeService;
    }

    @Override
    public String getMessage() {
        int hour = helloTimeService.currentHour();
        int month = helloTimeService.currentMonth();
        return "Hello! It's around " + hour + "00 hours, during month " + month + ".";
    }
}
