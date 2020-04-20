package com.example.pinsplorer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PinRecyclerAdapter extends RecyclerView.Adapter<PinViewHolder> {

    private ArrayList<Pin> pinList;
    public PinRecyclerAdapter(ArrayList<Pin> list){
        pinList = list;
    }
    public Pin recentlyDeletedPin;
    int recentlyDeletedPinPosition;

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
        holder.image.setImageResource(pin.getImage());
        holder.pinname.setText(pin.getName());

        if (pinList.get(position).getVisited()) {
            holder.visited.setText("Visited");
        }
        else {
            holder.visited.setText("Unvisited");
        }

        holder.description.setText(pinList.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentJump(pin);
            }
        });
        holder.markButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pin.setVisited(true);
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

    public void deleteItem(int position) {
        recentlyDeletedPin = pinList.get(position);
        recentlyDeletedPinPosition = position;
        pinList.remove(position);
        notifyItemRemoved(position);
        showUndoSnackbar();
    }

    private void showUndoSnackbar() {
        View view = MainActivity.MAINACTIVITY.findViewById(R.id.fragment_view_set);
        Snackbar snackbar = Snackbar.make(view, "",
                Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snack_bar_undo, v -> undoDelete());
        snackbar.show();
    }

    private void undoDelete() {
        pinList.add(recentlyDeletedPinPosition,
                recentlyDeletedPin);
        notifyItemInserted(recentlyDeletedPinPosition);
    }
}
