package io.github.ceeck65.android.puppy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.ceeck65.android.puppy.Pets.Pets;
import io.github.ceeck65.android.puppy.RecyclerPets.PetsAdapter;

public class PetsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPets;
    private RecyclerView.LayoutManager layoutManagerPets;
    private RecyclerView.Adapter adapterPets;
    private ImageView imgview, logoBar, imgFavorite;
    private TextView titleBar;
    private Toolbar toolbar;

    ArrayList<Pets> dataPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgview = (ImageView) findViewById(R.id.imgPets);
        logoBar = (ImageView) findViewById(R.id.logoBar);
        imgFavorite = (ImageView) findViewById(R.id.btnFavorites);
        titleBar = (TextView) findViewById(R.id.titleBar);

        logoBar.setImageResource(R.drawable.fetdog);
        imgFavorite.setImageResource(R.drawable.star);
        titleBar.setText(getResources().getString(R.string.titleBar));

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerViewPets = (RecyclerView) findViewById(R.id.rvPets);
        layoutManagerPets = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPets.setLayoutManager(layoutManagerPets);

        inicializePetsList(savedInstanceState);
        adapterPets();

    }


    public  void inicializePetsList(Bundle bundle) {
        ArrayList<Pets> listPets = null;
        try {
            listPets = (ArrayList<Pets>) bundle.getSerializable("Pets");
        } catch (Exception e){

        }

        if (listPets == null) {
            dataPets  = new ArrayList<Pets>();

            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/d31c02171770706d32358d4b1678d1f2.jpg", "Azabache"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/e8b99819376e1f6cad519e15afead182.jpg", "Missiu"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/33b8f3619da779a1ae409ac708da1aa6.jpg", "Negrin"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/ef29a541ba49353ffaacfe18bce25c76.jpg", "Nerón"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/930f13cb029d66edb18265cebebd3035.jpg", "Puppy"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/f3eaeb1a408c8e5540b18a93294c56a1.jpg", "Titi"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/17d4242071c488b1e0a481b8f0d1268e.jpg", "Yailon"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/b3f7c82d39c02bbcd3952d86fc412949.jpg", "Xiena"));
            dataPets.add(new Pets("http://www.mascotasderaza.com/arch/d31c02171770706d32358d4b1678d1f2.jpg", "Azabache"));
        } else {
            dataPets = listPets;
        }


    }

    public  void adapterPets() {
        adapterPets = new PetsAdapter(dataPets, this);
        recyclerViewPets.setAdapter(adapterPets);
    }


    public void goFavorite(View view) {
        Intent intent = new Intent(PetsActivity.this, FavoritesActivity.class);

        Bundle bundleObject = new Bundle();
        bundleObject.putSerializable("PetsFavorite", dataPets);


      //  intent.putExtras(bundleObject);
        startActivity(intent);
    }

}
