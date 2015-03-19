package com.shaunchurch.androidpickings.ui;

import android.location.LocationManager;
import android.os.Bundle;

import com.shaunchurch.androidpickings.DemoBaseActivity;

import javax.inject.Inject;

public class HomeActivity extends DemoBaseActivity {

    @Inject LocationManager locationManager;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // After the super.onCreate call returns we are guaranteed our injections are available.

        // TODO do something with the injected dependencies here!
    }
}
