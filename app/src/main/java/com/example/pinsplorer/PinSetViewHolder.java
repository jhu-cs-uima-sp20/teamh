package com.example.pinsplorer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PinSetViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    private ImageView image;
    public PinSetViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.pinSetImageView);
        name = itemView.findViewById(R.id.pinSetNameTextView);
    }
}
