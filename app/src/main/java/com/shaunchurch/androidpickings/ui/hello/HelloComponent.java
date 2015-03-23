package com.shaunchurch.androidpickings.ui.hello;

import com.shaunchurch.androidpickings.AppComponent;

import dagger.Component;

@HelloScope
@Component(
        dependencies = AppComponent.class,
        modules = HelloModule.class
)
public interface HelloComponent {
    void inject(HelloActivity activity);
}
