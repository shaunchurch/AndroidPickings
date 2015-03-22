package com.shaunchurch.androidpickings.ui.planets;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.ui.base.BaseActivity;

/**
 * Created by shaun on 22/03/15.
 */
public class PlanetsActivity extends BaseActivity {

    private PlanetsComponent planetsComponent;

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        planetsComponent = Dagger_PlanetsComponent.builder()
                .appComponent(appComponent)
                .build();
        planetsComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
    }
}
