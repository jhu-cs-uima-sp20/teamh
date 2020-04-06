package com.example.pinsplorer;

import android.os.Bundle;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentJump(pin);
            }
        });
    }

    private void fragmentJump(Pin mItemSelected) {
        ViewPinFragment frag = new ViewPinFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("item_selected_key", mItemSelected);
        frag.setArguments(bundle);
        MainActivity.MAINACTIVITY.switchFragment(frag);
    }

    @Override
    public int getItemCount() {
        return pinList.size();
    }
}
