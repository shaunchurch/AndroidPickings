package com.shaunchurch.androidpickings.ui.planets;

import com.shaunchurch.androidpickings.AppComponent;

import dagger.Component;

@PlanetsScope
@Component(
        dependencies = AppComponent.class,
        modules = PlanetsModule.class
)
public interface PlanetsComponent {
    void inject(PlanetsActivity activity);
}
