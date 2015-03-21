package com.shaunchurch.androidpickings;

import com.shaunchurch.androidpickings.Motor;
import com.shaunchurch.androidpickings.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor provideMotor(){
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }

}
