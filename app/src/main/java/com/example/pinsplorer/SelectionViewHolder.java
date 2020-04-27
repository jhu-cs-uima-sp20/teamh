package com.example.pinsplorer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SelectionViewHolder extends RecyclerView.ViewHolder {

    public TextView setname;
    public TextView creator;
    public ImageView image;

    public SelectionViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.selectionImageView);
        setname = itemView.findViewById(R.id.selectionNameTextView);
        creator = itemView.findViewById(R.id.selectionCreatorTextView);
    }
}
