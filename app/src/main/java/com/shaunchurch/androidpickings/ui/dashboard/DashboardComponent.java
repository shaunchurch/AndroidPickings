package com.shaunchurch.androidpickings.ui.dashboard;

import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.example.Vehicle;

import dagger.Component;

@DashboardScope
@Component(
        dependencies = AppComponent.class,
        modules = DashboardModule.class
)
public interface DashboardComponent {
        void inject(DashboardActivity activity);
        Vehicle provideVehicle();
}
