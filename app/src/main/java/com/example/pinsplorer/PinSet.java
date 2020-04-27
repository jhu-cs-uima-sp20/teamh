package com.example.pinsplorer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

class PinSet implements Parcelable {

    private int image;
    private String name;
    private int pins;
    private int followers;
    private String creator;
    private ArrayList<Pin> pinList;
    private boolean owned;

    public PinSet(String newName){
        name = newName;
        pins = 0;
        followers = 0;
        creator = "Me";
        image = R.drawable.gilman;
        pinList = new ArrayList<>();
    }

    //constructor for hard-coded data
    public PinSet(String newName, int newPins, int newFollowers, String newCreator, int im,
                  ArrayList<Pin> list, boolean own) {
        name = newName;
        pins = newPins;
        followers = newFollowers;
        creator = newCreator;
        image = im;
        pinList = list;
        owned = own;
    }

    protected PinSet(Parcel in) {
        name = in.readString();
        pins = in.readInt();
        followers = in.readInt();
        creator = in.readString();
    }

    public static final Creator<PinSet> CREATOR = new Creator<PinSet>() {
        @Override
        public PinSet createFromParcel(Parcel in) {
            return new PinSet(in);
        }

        @Override
        public PinSet[] newArray(int size) {
            return new PinSet[size];
        }
    };

    public void addPin(Pin newPin) {
        pinList.add(newPin);
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

    public int getImage() {
        return image;
    }

    public ArrayList<Pin> getPinList() {
        return pinList;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(pins);
        dest.writeInt(followers);
        dest.writeString(creator);
    }
}
