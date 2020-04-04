package com.example.pinsplorer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PinSetRecyclerAdapter extends RecyclerView.Adapter<PinSetViewHolder> {

    private ArrayList<PinSet> pinSetList;
    private Context context;
    public PinSetRecyclerAdapter(ArrayList<PinSet> list){
        pinSetList = list;
    }

    @NonNull
    @Override
    public PinSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.pin_set_view_holder, parent, false);
        context = v.getContext();
        return new PinSetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PinSetViewHolder holder, int position) {
        holder.name.setText(pinSetList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //****TODO Take user to ViewSetFragment
            }
        });
    }

    @Override
    public int getItemCount() {
        return pinSetList.size();
    }
}
