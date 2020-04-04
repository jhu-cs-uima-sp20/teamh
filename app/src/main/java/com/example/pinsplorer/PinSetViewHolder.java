package com.example.pinsplorer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PinSetViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView pins;
    public TextView followers;
    public TextView creator;
    private ImageView image;

    public PinSetViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.pinSetImageView);
        name = itemView.findViewById(R.id.pinSetNameTextView);
        pins = itemView.findViewById(R.id.numPinsTextView);
        followers = itemView.findViewById(R.id.numFollowersTextView);
        creator = itemView.findViewById(R.id.pinSetCreatorTextView);

    }
}
