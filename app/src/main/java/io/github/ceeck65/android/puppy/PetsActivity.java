package io.github.ceeck65.android.puppy;

import android.content.Context;
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        ArrayList<Pets> dataPets =  new ArrayList<Pets>();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgview = (ImageView) findViewById(R.id.imgPets);
        logoBar = (ImageView) findViewById(R.id.logoBar);
        imgFavorite = (ImageView) findViewById(R.id.btnFavorites);
        titleBar = (TextView) findViewById(R.id.titleBar);

        logoBar.setImageResource(R.drawable.fetdog);
        imgFavorite.setImageResource(R.drawable.star);
        titleBar.setText("PuppyApp");

        setSupportActionBar(toolbar);


        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/d31c02171770706d32358d4b1678d1f2.jpg", "Azabache", "0", false));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/e8b99819376e1f6cad519e15afead182.jpg", "Missiu", "7", true));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/33b8f3619da779a1ae409ac708da1aa6.jpg", "Negrin", "10", true));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/ef29a541ba49353ffaacfe18bce25c76.jpg", "Nerón", "0", false));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/930f13cb029d66edb18265cebebd3035.jpg", "Puppy", "0", false));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/f3eaeb1a408c8e5540b18a93294c56a1.jpg", "Titi", "6", true));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/17d4242071c488b1e0a481b8f0d1268e.jpg", "Yailon", "0", false));
        dataPets.add(new Pets("http://www.mascotasderaza.com/arch/b3f7c82d39c02bbcd3952d86fc412949.jpg", "Xiena", "9", true));


        recyclerViewPets = (RecyclerView) findViewById(R.id.rvPets);
        layoutManagerPets = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPets.setLayoutManager(layoutManagerPets);

        adapterPets = new PetsAdapter(dataPets, this);
        recyclerViewPets.setAdapter(adapterPets);



        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });







    }



}
