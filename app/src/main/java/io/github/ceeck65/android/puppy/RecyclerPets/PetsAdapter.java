package io.github.ceeck65.android.puppy.RecyclerPets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.github.ceeck65.android.puppy.Pets.Pets;
import io.github.ceeck65.android.puppy.Picasso.PicassoClient;
import io.github.ceeck65.android.puppy.R;

/**
 * Created by mariofernandez on 8/8/16.
 */

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.petsViewHolder> {

    private ArrayList<Pets> item;
    Context context;



    public PetsAdapter(ArrayList<Pets> item, Context context) {
        this.item = item;
        this.context = context;
    }


    @Override
    public petsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rows, viewGroup, false);
        petsViewHolder pets = new petsViewHolder(view);
        return pets;
    }

    @Override
    public void onBindViewHolder(petsViewHolder petViewHolder, int position) {

        petViewHolder.namePet.setText(item.get(position).getNamePet());
        petViewHolder.pointPet.setText(item.get(position).getPointPet());

        PicassoClient.loadPicasso(context, item.get(position).getImgPetUrl(), petViewHolder.imagePet);

       if (item.get(position).getFavorite() == true)
       {
           petViewHolder.imgFavorite.setImageResource(R.drawable.isfavorite);
       }
        else
       {
           petViewHolder.imgFavorite.setImageResource(R.drawable.notfavorite);
       }

    }

    @Override
    public int getItemCount() {
        return item.size();
    }


    public class petsViewHolder  extends RecyclerView.ViewHolder {

        TextView namePet, pointPet;
        ImageView imagePet;
        ImageView imgFavorite;



        public petsViewHolder(View itemView) {
            super(itemView);

            namePet  = (TextView) itemView.findViewById(R.id.tvPet);
            pointPet = (TextView) itemView.findViewById(R.id.tvCalification);
            imagePet = (ImageView) itemView.findViewById(R.id.imgPets);
            imgFavorite = (ImageView) itemView.findViewById(R.id.active);
        }
    }


}
