package com.shaunchurch.androidpickings.ui.planets;

import dagger.Module;
import dagger.Provides;

@PlanetsScope
@Module
public class PlanetsModule {

    public final PlanetView view;

    public PlanetsModule(PlanetView view) {
        this.view = view;
    }

    @Provides
    PlanetSupplier planetSupplier(PlanetSupplierImpl impl) {return impl; }

    @Provides
    PlanetPresenter planetPresenter(PlanetPresenterImpl impl) { return impl; }

    @Provides
    PlanetView planetView() { return this.view; }

}
