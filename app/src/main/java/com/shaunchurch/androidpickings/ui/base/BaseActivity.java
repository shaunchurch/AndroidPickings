package com.shaunchurch.androidpickings.ui.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.shaunchurch.androidpickings.App;
import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.ui.AppContainer;

import javax.inject.Inject;

public abstract class BaseActivity extends ActionBarActivity {

    @Inject
    AppContainer appContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App app = App.get(this);
        onCreateComponent(app.component());

        if(appContainer == null ){
            throw new IllegalStateException("No injection happened. Add component.inject(this) in onCreateComponent.");
        }
    }

    /**
     * Must be implemented by derived activities.
     * Otherwise IllegalStateException will be thrown.
     * Derived activity is responsible to store and save it's component.
     */
    protected abstract void onCreateComponent(AppComponent appComponent);

}
