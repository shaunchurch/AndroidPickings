package com.shaunchurch.androidpickings.ui.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.shaunchurch.androidpickings.Dagger_VehicleComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.Vehicle;
import com.shaunchurch.androidpickings.VehicleComponent;
import com.shaunchurch.androidpickings.VehicleModule;
import com.shaunchurch.androidpickings.ui.base.AppActivity;

import javax.inject.Inject;


public class DashboardActivity extends AppActivity {

    @Inject
    Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // use dagger to create our component
        // modules don't require any arguments, so we could remove the .vehicleModule bit, it will auto-instantiate
        VehicleComponent component = Dagger_VehicleComponent.builder().vehicleModule(new VehicleModule()).build();

        // get an instance of a vehicle
        vehicle = component.provideVehicle();

        // see if we can drive
        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();
        vehicle.increaseSpeed(100);
        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();

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
