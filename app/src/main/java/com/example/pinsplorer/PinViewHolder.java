package com.example.pinsplorer;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PinViewHolder extends RecyclerView.ViewHolder{

    public TextView pinname;
    public TextView visited;
    public TextView description;
    public ImageView image;
    public Button markButton;

    public PinViewHolder(View itemView) {
        super(itemView);
        pinname = itemView.findViewById(R.id.pinNameTextView);
        visited = itemView.findViewById(R.id.pinVisitStatusTextView);
        description = itemView.findViewById(R.id.pinDescriptionTextView);
        image = itemView.findViewById(R.id.pinImageView);
        markButton = itemView.findViewById(R.id.mark_visited_button);
    }
}
