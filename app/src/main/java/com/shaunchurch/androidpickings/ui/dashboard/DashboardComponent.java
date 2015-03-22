package com.shaunchurch.androidpickings.ui.dashboard;

import com.shaunchurch.androidpickings.AppComponent;

import dagger.Component;

@DashboardScope
@Component(
        dependencies = AppComponent.class,
        modules = DashboardModule.class
)
public interface DashboardComponent {
}
