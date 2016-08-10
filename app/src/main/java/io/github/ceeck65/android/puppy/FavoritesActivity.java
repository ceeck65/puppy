package io.github.ceeck65.android.puppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.ceeck65.android.puppy.Pets.Pets;
import io.github.ceeck65.android.puppy.RecyclerPets.PetsAdapter;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPets;
    private RecyclerView.LayoutManager layoutManagerPets;
    private RecyclerView.Adapter adapterPets;
    Toolbar toolbar;
    private ImageView  logoBar;
    private TextView titleBarFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Pets> dataPets =  new ArrayList<Pets>();

        setContentView(R.layout.activity_favorites);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logoBar = (ImageView) findViewById(R.id.logoBar);
        titleBarFavorite = (TextView) findViewById(R.id.titleBar);

        logoBar.setImageResource(R.drawable.fetdog);
        titleBarFavorite.setText(getResources().getString(R.string.titleBarFavorites));

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/e8b99819376e1f6cad519e15afead182.jpg", "Missiu", "7", true));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/33b8f3619da779a1ae409ac708da1aa6.jpg", "Negrin", "10", true));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/f3eaeb1a408c8e5540b18a93294c56a1.jpg", "Titi", "6", true));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/b3f7c82d39c02bbcd3952d86fc412949.jpg", "Xiena", "9", true));

        recyclerViewPets = (RecyclerView) findViewById(R.id.rvPetsFavorite);
        layoutManagerPets = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPets.setLayoutManager(layoutManagerPets);

        adapterPets = new PetsAdapter(dataPets, this);
        recyclerViewPets.setAdapter(adapterPets);

    }
}
