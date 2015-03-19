package com.shaunchurch.androidpickings;

import android.app.Activity;
import android.os.Bundle;

public abstract class DemoBaseActivity extends Activity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((DemoApplication) getApplication()).inject(this);
    }
}
