package com.example.normalrecyclerview.cardview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyclerview.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.PlanetHolder2> {

    @NonNull
    @Override
    public PlanetHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder2 holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlanetHolder2 extends RecyclerView.ViewHolder{
        private TextView txtNameCard, txtDistanceCard, txtGravityCard, txtDiameterCard;

        public PlanetHolder2(@NonNull View itemView, TextView txtNameCard, TextView txtDistanceCard, TextView txtGravityCard, TextView txtDiameterCard) {
            super(itemView);
             txtNameCard = itemView.findViewById(R.id.txtNameCard);
             txtDistanceCard = itemView.findViewById(R.id.txtDistanceCard);
             txtDiameterCard = itemView.findViewById(R.id.txtDiameterCard);
        }
    }
}
