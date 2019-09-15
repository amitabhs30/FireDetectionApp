package com.example.fireapp.Model;

public class DeviceDetails {
    private String name;
    private double temp;
    private double humidity;
    private double heatIndex;
    private boolean Indicator;

    public DeviceDetails() {
    }

    public DeviceDetails(String name, double temp, double humidity, double heatIndex, boolean indicator) {
        this.name = name;
        this.temp = temp;
        this.humidity = humidity;
        this.heatIndex = heatIndex;
        Indicator = indicator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public boolean isIndicator() {
        return Indicator;
    }

    public void setIndicator(boolean indicator) {
        Indicator = indicator;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(double heatIndex) {
        this.heatIndex = heatIndex;
    }
}
