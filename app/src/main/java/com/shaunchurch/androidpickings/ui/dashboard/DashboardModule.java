package com.shaunchurch.androidpickings.ui.dashboard;

import com.shaunchurch.androidpickings.example.Motor;
import com.shaunchurch.androidpickings.example.Vehicle;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    @Provides
    @DashboardScope
    Vehicle provideVehicle() {
            return new Vehicle(new Motor());
    }
}
