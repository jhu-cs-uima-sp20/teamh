package com.example.pinsplorer;

import android.widget.ImageView;

class PinSet {

    private ImageView image;
    private String name;
    private int pins;
    private int followers;
    private String creator;

    public PinSet(String newName){
        name = newName;
        pins = 0;
        followers = 0;
        creator = "Me";
    }

    //constructor for hard-coded data
    public PinSet(String newName, int newPins, int newFollowers, String newCreator) {
        name = newName;
        pins = newPins;
        followers = newFollowers;
        creator = newCreator;
    }

    public String getName() {
        return name;
    }

    public int getPins() {
        return pins;
    }

    public int getFollowers() {
        return followers;
    }

    public String getCreator() {
        return creator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPins(int pins) {
        this.pins = pins;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
