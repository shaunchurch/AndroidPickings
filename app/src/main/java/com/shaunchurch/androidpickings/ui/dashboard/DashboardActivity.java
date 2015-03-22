package com.shaunchurch.androidpickings.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.example.Vehicle;
import com.shaunchurch.androidpickings.ui.WebImageView;
import com.shaunchurch.androidpickings.ui.base.BaseActivity;
import com.shaunchurch.androidpickings.ui.base.HasComponent;
import com.shaunchurch.androidpickings.ui.hello.HelloActivity;
import com.shaunchurch.androidpickings.ui.planets.PlanetsActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DashboardActivity extends BaseActivity
        implements HasComponent<DashboardComponent>, View.OnClickListener {

    private DashboardComponent dashboardComponent;

    @Inject Picasso picasso;

    @InjectView(R.id.webImageView) WebImageView webImageView;
    @InjectView(R.id.buttonHello) Button buttonHello;
    @InjectView(R.id.buttonPlanets) Button buttonPlanets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        // listen for clicks
        buttonHello.setOnClickListener(this);
        buttonPlanets.setOnClickListener(this);

        picasso.load("http://upload.wikimedia.org/wikipedia/commons/2/21/Mandel_zoom_00_mandelbrot_set.jpg")
                .into(webImageView);
        Vehicle vehicle = dashboardComponent.provideVehicle();
        vehicle.increaseSpeed(100);
    }

    /**
     * Implements parent activity interface to set up component
     * @param appComponent
     */
    @Override
    public void onCreateComponent(AppComponent appComponent) {
        dashboardComponent = Dagger_DashboardComponent.builder()
                .appComponent(appComponent)
                .dashboardModule(new DashboardModule())
                .build();
        dashboardComponent.inject(this);
    }

    @Override
    public DashboardComponent getComponent() {
        return dashboardComponent;
    }

    /**
     * Implements onClick so we can listen for clicks in one place.
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonHello:
                startActivity(new Intent(this, HelloActivity.class));
                break;
            case R.id.buttonPlanets:
                startActivity(new Intent(this, PlanetsActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
