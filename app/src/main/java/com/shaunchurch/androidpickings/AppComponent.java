package com.shaunchurch.androidpickings;

import dagger.Component;

@ApplicationScope
@Component(modules = { AppModule.class })
public interface AppComponent extends AppGraph {
    /**
     * An initializer that creates the graph from an application.
     */
    final static class Initializer {
        static AppComponent init(App app) {
            return Dagger_AppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
        private Initializer() {} // No instances.
    }
}
