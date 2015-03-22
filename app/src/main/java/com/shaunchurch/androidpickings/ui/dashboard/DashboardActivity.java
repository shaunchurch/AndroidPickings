package com.shaunchurch.androidpickings.ui.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.shaunchurch.androidpickings.AppComponent;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.ui.base.AppActivity;
import com.shaunchurch.androidpickings.ui.base.HasComponent;

import timber.log.Timber;

public class DashboardActivity extends AppActivity implements HasComponent<DashboardComponent> {

    private DashboardComponent dashboardComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        dashboardComponent = Dagger_DashboardComponent.builder()
                .appComponent(appComponent)
                .dashboardModule(new DashboardModule())
                .build();


        Timber.i("Created component in Dashboard activity.");

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
