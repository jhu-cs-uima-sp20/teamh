package com.example.pinsplorer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FollowRecyclerAdapter extends RecyclerView.Adapter<FollowViewHolder> {

    private ArrayList<PinSet> pinSetFollowedList;
    private PinSet recentlyDeletedPinSet;
    private int recentlyDeletedPinSetPosition;

    public FollowRecyclerAdapter(ArrayList<PinSet> list) {
        pinSetFollowedList = list;
    }

    @NonNull
    @Override
    public FollowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.pin_set_view_holder, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowViewHolder holder, final int position) {

        final PinSet set = pinSetFollowedList.get(position);
        holder.image.setImageResource(set.getImage());
        holder.setname.setText(pinSetFollowedList.get(position).getName());
        holder.pins.setText("" + pinSetFollowedList.get(position).getPins());
        holder.followers.setText("" + pinSetFollowedList.get(position).getFollowers());
        holder.creator.setText(pinSetFollowedList.get(position).getCreator());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentJump(set, position);
            }
        });
    }

    private void fragmentJump(PinSet mItemSelected, int position) {
        ViewSetFragment frag = new ViewSetFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("item_selected_key", mItemSelected);
        bundle.putInt("item_index", position);
        frag.setArguments(bundle);
        MainActivity.MAINACTIVITY.switchFragment(frag);
    }

    @Override
    public int getItemCount() {
        return pinSetFollowedList.size();
    }

    public void deleteItem(int position) {
        recentlyDeletedPinSet = pinSetFollowedList.get(position);
        recentlyDeletedPinSetPosition = position;
        pinSetFollowedList.remove(position);
        notifyItemRemoved(position);
        showUndoSnackbar();
    }

    private void showUndoSnackbar() {
        View view = MainActivity.MAINACTIVITY.findViewById(R.id.saved_pinsets);
        Snackbar snackbar = Snackbar.make(view, "",
                Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snack_bar_undo, v -> undoDelete());
        snackbar.show();
    }

    private void undoDelete() {
        pinSetFollowedList.add(recentlyDeletedPinSetPosition,
                recentlyDeletedPinSet);
        notifyItemInserted(recentlyDeletedPinSetPosition);
    }
}