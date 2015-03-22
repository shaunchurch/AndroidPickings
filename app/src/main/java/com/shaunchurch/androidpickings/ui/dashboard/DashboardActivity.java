package com.shaunchurch.androidpickings.ui.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.example.Vehicle;
import com.shaunchurch.androidpickings.ui.WebImageView;
import com.shaunchurch.androidpickings.ui.base.BaseActivity;
import com.shaunchurch.androidpickings.ui.base.HasComponent;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DashboardActivity extends BaseActivity implements HasComponent<DashboardComponent> {

    private DashboardComponent dashboardComponent;

    @Inject
    Picasso picasso;

    @InjectView(R.id.webImageView) WebImageView webImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        picasso.load("http://upload.wikimedia.org/wikipedia/commons/2/21/Mandel_zoom_00_mandelbrot_set.jpg").into(webImageView);
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
