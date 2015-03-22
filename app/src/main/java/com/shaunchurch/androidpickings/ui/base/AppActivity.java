package com.shaunchurch.androidpickings.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import com.shaunchurch.androidpickings.App;
import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.ui.AppContainer;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by shaun on 21/03/15.
 */
public abstract class AppActivity extends ActionBarActivity {

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
