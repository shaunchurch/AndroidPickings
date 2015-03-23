package com.shaunchurch.androidpickings.ui.planets;

import com.shaunchurch.androidpickings.data.entities.Planet;

import java.util.List;

public interface PlanetView {
    void onPlanetsReceived(List<Planet> planets);
}
