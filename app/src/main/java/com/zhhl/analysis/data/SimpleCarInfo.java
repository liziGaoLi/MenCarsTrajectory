package com.zhhl.analysis.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by miao on 2018/12/24.
 */
public class SimpleCarInfo implements Parcelable {
    private String carCode;
    private String company;
    private String carName;
    private String belongTo;

    public SimpleCarInfo() {
    }

    public SimpleCarInfo(String carCode, String company, String carName,String belongTo) {

        this.carCode = carCode;
        this.company = company;
        this.carName = carName;
        this.belongTo = belongTo;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.carCode);
        dest.writeString(this.company);
        dest.writeString(this.carName);
        dest.writeString(this.belongTo);
    }

    protected SimpleCarInfo(Parcel in) {
        this.carCode = in.readString();
        this.company = in.readString();
        this.carName = in.readString();
        this.belongTo = in.readString();
    }

    public static final Parcelable.Creator<SimpleCarInfo> CREATOR = new Parcelable.Creator<SimpleCarInfo>() {
        @Override
        public SimpleCarInfo createFromParcel(Parcel source) {
            return new SimpleCarInfo(source);
        }

        @Override
        public SimpleCarInfo[] newArray(int size) {
            return new SimpleCarInfo[size];
        }
    };
}
