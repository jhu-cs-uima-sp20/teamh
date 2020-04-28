package com.example.pinsplorer;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FollowViewHolder extends RecyclerView.ViewHolder {
    public TextView setname;
    public TextView pins;
    public TextView followers;
    public TextView creator;
    public ImageView image;
    public Button btn;

    public FollowViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.pinSetImageView);
        setname = itemView.findViewById(R.id.pinSetNameTextView);
        pins = itemView.findViewById(R.id.numPinsTextView);
        followers = itemView.findViewById(R.id.numFollowersTextView);
        creator = itemView.findViewById(R.id.pinSetCreatorTextView);
        btn = itemView.findViewById(R.id.follow_button);

    }
}

