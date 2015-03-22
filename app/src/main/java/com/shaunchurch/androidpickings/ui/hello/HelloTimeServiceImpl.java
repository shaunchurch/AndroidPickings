package com.shaunchurch.androidpickings.ui.hello;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Inject;

/**
 * Created by shaun on 22/03/15.
 */
public class HelloTimeServiceImpl implements HelloTimeService {

    @Inject
    public HelloTimeServiceImpl() {
    }

    @Override
    public int currentHour() {
        return new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
    }

}
