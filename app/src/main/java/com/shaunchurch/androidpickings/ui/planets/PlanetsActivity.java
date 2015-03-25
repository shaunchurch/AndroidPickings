package com.shaunchurch.androidpickings.ui.planets;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.data.entities.Planet;
import com.shaunchurch.androidpickings.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PlanetsActivity extends BaseActivity
    implements PlanetView {

    private PlanetsComponent planetsComponent;

    @Inject PlanetPresenter presenter;
    @Inject PlanetAdapter planetAdapter;

    @InjectView(R.id.listPlanets) ListView listPlanets;

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        planetsComponent = Dagger_PlanetsComponent.builder()
                .appComponent(appComponent)
                .planetsModule(new PlanetsModule(this))
                .build();
        planetsComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
        ButterKnife.inject(this);

        // set list adapter
        listPlanets.setAdapter(planetAdapter);
    }

    @Override
    public void onPlanetsReceived(List<Planet> planets) {
//        textPlanet.setText(planets.get(0).getName());
    }
}
