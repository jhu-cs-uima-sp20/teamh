package com.example.pinsplorer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PinRecyclerAdapter extends RecyclerView.Adapter<PinViewHolder> {

    private ArrayList<Pin> pinList;

    public PinRecyclerAdapter(ArrayList<Pin> list){
        pinList = list;
    }

    @NonNull
    @Override
    public PinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.pin_view_holder, parent, false);
        return new PinViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PinViewHolder holder, int position) {
        final Pin pin = pinList.get(position);
        holder.pinname.setText(pinList.get(position).getName());
        holder.visited.setText(pinList.get(position).getVisited());
        holder.description.setText(pinList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return pinList.size();
    }
}
