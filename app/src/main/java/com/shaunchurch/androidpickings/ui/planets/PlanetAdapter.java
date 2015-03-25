package com.shaunchurch.androidpickings.ui.planets;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shaunchurch.androidpickings.App;
import com.shaunchurch.androidpickings.R;
import com.shaunchurch.androidpickings.data.entities.Planet;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class PlanetAdapter extends BaseAdapter {

    private Context context;
    private PlanetSupplier planetSupplier;

    private List<Planet> planets = Collections.emptyList();

    @Inject
    public PlanetAdapter(Application app, PlanetSupplier planetSupplier) {
        this.context = app;
        this.planetSupplier = planetSupplier;
        update();
    }

    public void update() {
        this.planets = planetSupplier.getPlanets();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // basic view holder pattern
        TextView planetView;
        if(convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.list_item_planet, parent, false);
            planetView = (TextView) convertView.findViewById(R.id.textPlanet);
            convertView.setTag(new ViewHolder(planetView));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            planetView = viewHolder.planetView;
        }

        Planet planet = getItem(position);
        planetView.setText(planet.getName());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Planet getItem(int position) {
        return this.planets.get(position);
    }

    @Override
    public int getCount() {
        return this.planets.size();
    }

    private static class ViewHolder {
        public final TextView planetView;

        public ViewHolder(TextView planetView) {
            this.planetView = planetView;
        }
    }
}
