package com.shaunchurch.androidpickings.ui.planets;


import com.shaunchurch.androidpickings.data.entities.Planet;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PlanetSupplierImpl implements PlanetSupplier {

    List<Planet> mPlanets;

    @Inject
    public PlanetSupplierImpl() {
    }

    public List<Planet> getPlanets() {

        mPlanets = new ArrayList<>();

        mPlanets.add(new Planet("Mercury", "Rock"));
        mPlanets.add(new Planet("Venus", "Rock"));
        mPlanets.add(new Planet("Earth", "Rock"));
        mPlanets.add(new Planet("Mars", "Rock"));

        return mPlanets;

    }
}
