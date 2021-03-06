package com.example.pinsplorer;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.android.gms.maps.model.LatLng;

public class Pin implements Parcelable {

    private int image;
    private String name;
    private Boolean visited;
    private String description;
    private LatLng coords;

    public Pin(String newName, Boolean newVisited, String newDescription, int im) {
        name = newName;
        visited = newVisited;
        description = newDescription;
        image = im;
    }

    public Pin(String newName, Boolean newVisited, String newDescription, int im, LatLng newCoords) {
        name = newName;
        visited = newVisited;
        description = newDescription;
        image = im;
        coords = newCoords;
    }

    public Pin(String newName, String newDescription, LatLng newCoords) {
        name = newName;
        visited = false;
        description = newDescription;
        image = R.drawable.miracle;
        coords = newCoords;
    }

    protected Pin(Parcel in) {
        name = in.readString();
        boolean[] bool = new boolean[1];
        in.readBooleanArray(bool); // readBool not implemented in SDK 18
        visited = bool[0];
        description = in.readString();
    }

    public static final Creator<Pin> CREATOR = new Creator<Pin>() {
        @Override
        public Pin createFromParcel(Parcel in) {
            return new Pin(in);
        }

        @Override
        public Pin[] newArray(int size) {
            return new Pin[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        boolean bool[] = {visited};
        dest.writeBooleanArray(bool);
        dest.writeString(description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public LatLng getCoords() {
        return coords;
    }
}
