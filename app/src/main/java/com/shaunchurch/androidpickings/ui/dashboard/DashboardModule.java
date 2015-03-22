package com.shaunchurch.androidpickings.ui.dashboard;

import com.shaunchurch.androidpickings.Motor;
import com.shaunchurch.androidpickings.Vehicle;

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
