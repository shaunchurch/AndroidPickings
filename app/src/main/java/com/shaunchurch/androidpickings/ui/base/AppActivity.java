package com.shaunchurch.androidpickings.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.shaunchurch.androidpickings.App;
import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.ui.AppContainer;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by shaun on 21/03/15.
 */
public abstract class AppActivity extends Activity {

    @Inject
    AppContainer appContainer;

    @Inject
    Picasso picasso;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        App app = App.get(this);
        onCreateComponent(app.component());

    }

    /**
     * Must be implemented by derived activities.
     * Otherwise IllegalStateException will be thrown.
     * Derived activity is responsible to store and save it's component.
     */
    protected abstract void onCreateComponent(AppComponent appComponent);

}
