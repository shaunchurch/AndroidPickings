package com.shaunchurch.androidpickings.ui.planets;

import javax.inject.Inject;

public class PlanetPresenterImpl implements PlanetPresenter {

    private PlanetView view;
    private PlanetSupplier planetSupplier;

    @Inject
    public PlanetPresenterImpl(PlanetView planetView, PlanetSupplier planetSupplier) {
        this.view = planetView;
        this.planetSupplier = planetSupplier;
    }

    @Override
    public void requestPlanets() {
        planetSupplier.getPlanets();
    }
}
