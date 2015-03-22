package com.shaunchurch.androidpickings;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

/**
 * Default app class
 */
public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        component = AppComponent.Initializer.init(this);
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}
