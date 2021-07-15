package com.example.newgbapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class UserText implements Parcelable {
    private String userInput;
    private String userOutput;


    public UserText(String userInput, String userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getUserOutput() {
        return userOutput;
    }

    public void setUserOutput(String userOutput) {
        this.userOutput = userOutput;
    }

    protected UserText(Parcel in) {
        userInput = in.readString();
        userOutput = in.readString();
    }

    public static final Creator<UserText> CREATOR = new Creator<UserText>() {
        @Override
        public UserText createFromParcel(Parcel in) {
            return new UserText(in);
        }

        @Override
        public UserText[] newArray(int size) {
            return new UserText[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userInput);
        dest.writeString(userOutput);
    }
}
