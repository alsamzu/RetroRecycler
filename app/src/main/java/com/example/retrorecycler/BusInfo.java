package com.example.retrorecycler;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BusInfo implements Parcelable {

        private int id;

        @SerializedName("title")
    private String busdetials;

    public BusInfo(int id, String busdetials) {
        this.id = id;
        this.busdetials = busdetials;
    }

    protected BusInfo(Parcel in) {
        id = in.readInt();
        busdetials = in.readString();
    }

    public static final Creator<BusInfo> CREATOR = new Creator<BusInfo>() {
        @Override
        public BusInfo createFromParcel(Parcel in) {
            return new BusInfo(in);
        }

        @Override
        public BusInfo[] newArray(int size) {
            return new BusInfo[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getBusdetials() {
        return busdetials;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(busdetials);
    }
}
