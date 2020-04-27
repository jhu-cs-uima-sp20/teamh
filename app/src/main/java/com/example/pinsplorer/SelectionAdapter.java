package com.example.pinsplorer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionViewHolder> {

    private ArrayList<PinSet> pinSetList;
    public SelectionAdapter(ArrayList<PinSet> list){
        pinSetList = list;
    }

    @NonNull
    @Override
    public SelectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.selection_view_holder, parent, false);
        return new SelectionViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull SelectionViewHolder holder, int position) {
        final PinSet set = pinSetList.get(position);
        holder.image.setImageResource(set.getImage());
        holder.setname.setText(pinSetList.get(position).getName());
        holder.creator.setText(pinSetList.get(position).getCreator());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFrag(position);
            }
        });
    }

    private void switchFrag(int position) {
        MapFragment frag = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Set_Index", position);
        frag.setArguments(bundle);
        MainActivity.MAINACTIVITY.switchFragment(frag);
    }

    @Override
    public int getItemCount() {
        return pinSetList.size();
    }
}
