package com.example.testapp;
import android.os.Parcel;
import android.os.Parcelable;

public class TeleGisPoiInfo implements Parcelable {

    public final static String EXTRA_NAME = "EXTRA_TELE_POI_INFO";

    public String name;
    public String phone;
    public String addr;
    public double latitude;
    public double longitude;
    public String note;

    public static final Creator<TeleGisPoiInfo> CREATOR = new Creator<TeleGisPoiInfo>() {
        public TeleGisPoiInfo createFromParcel(Parcel in) {
            return new TeleGisPoiInfo(in);
        }

        public TeleGisPoiInfo[] newArray( int size ) {
            return new TeleGisPoiInfo[size];
        }
    };

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeString(this.addr);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeString(this.note);
    }

    public TeleGisPoiInfo() {
    }

    public TeleGisPoiInfo(Parcel in) {
        this.name = in.readString();
        this.phone = in.readString();
        this.addr = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.note = in.readString();
    }
}
