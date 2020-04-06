package com.example.maps;

public class Data {

    private double latitude;
    private double longitude;
    private String text;

    public Data(double latitude, double longitude, String text) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.text = text;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
