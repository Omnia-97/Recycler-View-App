package com.example.normalrecyclerview.normalview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;

public class NormalRecyclerView extends AppCompatActivity {
    RecyclerView normal_recycler;
    private ArrayList<Planet> planets;
    private PlanetAdapter planetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);
        normal_recycler = findViewById(R.id.normal_recycler);
        normal_recycler.setLayoutManager(new LinearLayoutManager(this));
        planets = new ArrayList<>();
        planetAdapter = new PlanetAdapter(this, planets);
        normal_recycler.setAdapter(planetAdapter);
        normal_recycler.addItemDecoration(new DividerItemDecoration(this , LinearLayoutManager.VERTICAL));

        createListData();

    }

    private void createListData() {
        Planet planet = new Planet("Earth", 150,10,12750);
        planets.add(planet);

        // Adding some other info
        planet = new Planet("Jupiter", 778, 26, 143000);
        planets.add(planet);
        planet = new Planet("Mars", 228, 4, 6800);
        planets.add(planet);
        planet = new Planet("Pluto", 5900, 1, 2320);
        planets.add(planet);
        planet = new Planet("Venus", 108, 9, 12750);
        planets.add(planet);
        planet = new Planet("Saturn", 1429, 11, 120000);
        planets.add(planet);
        planet = new Planet("Mercury", 58, 4, 4900);
        planets.add(planet);
        planet = new Planet("Neptune", 4500, 12, 50500);
        planets.add(planet);
        planet = new Planet("Uranus", 2870, 9, 52400);
        planets.add(planet);

        planetAdapter.notifyDataSetChanged();
    }

}