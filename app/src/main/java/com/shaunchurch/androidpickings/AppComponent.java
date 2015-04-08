package com.shaunchurch.androidpickings;

import android.app.Application;

import com.shaunchurch.androidpickings.data.DataModule;
import com.shaunchurch.androidpickings.ui.UiModule;

import dagger.Component;

@ApplicationScope
@Component(modules = { AppModule.class, UiModule.class, DataModule.class })
public interface AppComponent extends AppGraph {
    /**
     * An initializer that creates the graph from an application.
     */
    final static class Initializer {
        static AppComponent init(App app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
        private Initializer() {} // No instances.
    }

    Application provideApplication();
}
