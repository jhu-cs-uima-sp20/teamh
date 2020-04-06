package com.example.pinsplorer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PinSetRecyclerAdapter extends RecyclerView.Adapter<PinSetViewHolder> {

    private ArrayList<PinSet> pinSetList;

    public PinSetRecyclerAdapter(ArrayList<PinSet> list){
        pinSetList = list;
    }

    @NonNull
    @Override
    public PinSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.pin_set_view_holder, parent, false);
        return new PinSetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PinSetViewHolder holder, int position) {
        final PinSet set = pinSetList.get(position);
        holder.image.setImageResource(set.getImage());
        holder.setname.setText(pinSetList.get(position).getName());
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

    private void fragmentJump(PinSet mItemSelected) {
        ViewSetFragment frag = new ViewSetFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("item_selected_key", mItemSelected);
        frag.setArguments(bundle);
        MainActivity.MAINACTIVITY.switchFragment(frag);
    }

    @Override
    public int getItemCount() {
        return pinSetList.size();
    }
}
