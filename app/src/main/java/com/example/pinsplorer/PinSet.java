package com.example.pinsplorer;

import android.widget.ImageView;

class PinSet {

    private ImageView image;
    private String name;

    public PinSet(String newName){
        name = newName;
    }

    public String getName() {
        return name;
    }
}
