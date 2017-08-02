package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Tourism implements Parcelable{

    private String mTourismName;
    private String mLocation;
    private int mResourceId;
    private String mDescription;
    private String mDate = "";

    @Override
    public int describeContents() {
        return 0;
    }

    public Tourism(String tourismName, String location, int id, String description) {
        mTourismName = tourismName;
        mLocation = location;
        mResourceId = id;
        mDescription = description;
    }

    public Tourism(String tourismName, String location, int id, String description, String date) {
        mTourismName = tourismName;
        mLocation = location;
        mResourceId = id;
        mDescription = description;
        mDate = date;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {mTourismName,
                mLocation,
                mDescription,
                mDate});
        dest.writeInt(mResourceId);
    }

    public static final Parcelable.Creator<Tourism> CREATOR = new Parcelable.Creator<Tourism>() {
        public Tourism createFromParcel(Parcel in) {
            return new Tourism(in);
        }

        public Tourism[] newArray(int size) {
            return new Tourism[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Tourism(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        mTourismName = data[0];
        mLocation = data[1];
        mDescription = data[2];
        mDate = data[3];
        mResourceId = in.readInt();
    }

    public String getTourismName() {return mTourismName;}

    public String getLocation() {return mLocation;}

    public int getResourceId() {return mResourceId;}

    public String getDescription() {return mDescription;}

    public String getDate() {return mDate;}
}
