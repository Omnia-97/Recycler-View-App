package com.example.normalrecyclerview.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.PlanetHolder2> {
    private Context context2;
    private ArrayList<PlanetCards> planetCardsArrayList;

    public CardAdapter(Context context2, ArrayList<PlanetCards> planetCardsArrayList) {
        this.context2 = context2;
        this.planetCardsArrayList = planetCardsArrayList;
    }

    @NonNull
    @Override
    public PlanetHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context2).inflate(R.layout.item_card , parent , false);
        return new PlanetHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder2 holder, int position) {
        PlanetCards planetCards = planetCardsArrayList.get(position);
        holder.SetDetails(planetCards);

    }

    @Override
    public int getItemCount() {
        return planetCardsArrayList.size();
    }

    public class PlanetHolder2 extends RecyclerView.ViewHolder{
        private TextView txtNameCard, txtDistanceCard, txtGravityCard, txtDiameterCard;

        public PlanetHolder2(@NonNull View itemView) {
            super(itemView);
             txtNameCard = itemView.findViewById(R.id.txtNameCard);
             txtDistanceCard = itemView.findViewById(R.id.txtDistanceCard);
             txtGravityCard = itemView.findViewById(R.id.txtGravityCard);
             txtDiameterCard = itemView.findViewById(R.id.txtDiameterCard);
        }
        void SetDetails(PlanetCards planet){
            txtNameCard.setText(planet.getPlanetName2());
            txtDistanceCard.setText(String.format(Locale.US,
                    "Distance from sun : %d Million KM", planet.getDistanceFromSun2()));
            txtGravityCard.setText(String.format(Locale.US,
                    "Surface Gravity : %d N/Kg", planet.getGravity2()));
            txtDiameterCard.setText(String.format(Locale.US,
                    "Diameter : %d KM", planet.getDiameter2()));
        }
    }
}
