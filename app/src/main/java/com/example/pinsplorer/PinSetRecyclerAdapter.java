package com.example.pinsplorer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
        final PinSet set = pinSetList.get(position);

        holder.name.setText(pinSetList.get(position).getName());
        holder.pins.setText("" + pinSetList.get(position).getPins());
        holder.followers.setText("" + pinSetList.get(position).getFollowers());
        holder.creator.setText(pinSetList.get(position).getCreator());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentJump(set);
            }
        });
    }

    //TODO: almost working except for line 59.
    private void fragmentJump(PinSet mItemSelected) {
        ViewSetFragment frag = new ViewSetFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("item_selected_key", mItemSelected);
        frag.setArguments(bundle);
        switchContent(R.id.pin_set_view_holder, frag);
    }
//
    public void switchContent(int id, Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.switchFragment(fragment);
        }
//
    }



    @Override
    public int getItemCount() {
        return pinSetList.size();
    }
}
