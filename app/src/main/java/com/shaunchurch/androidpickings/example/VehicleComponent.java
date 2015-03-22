package com.shaunchurch.androidpickings.example;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();

}
