package com.example.pinsplorer;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Pin implements Parcelable {

    private ImageView image;
    private String name;
    private String visited;
    private String description;

    public Pin(String newName, String newVisited, String newDescription) {
        name = newName;
        visited = newVisited;
        description = newDescription;
    }

    protected Pin(Parcel in) {
        name = in.readString();
        visited = in.readString();
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
        dest.writeString(visited);
        dest.writeString(description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVisited() {
        return visited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisited(String visited) {
        this.visited = visited;
    }
}
