package com.mlaf.hu.casestudy.sensoragent;

public class DHTReading {
    private float temp_c;
    private float humidity;

    public DHTReading(float temp_c, float humidity) {
        this.temp_c = temp_c;
        this.humidity = humidity;
    }

    public float getTemperatureC() {
        return this.temp_c;
    }

    public float getTemperatureF() {
        return this.temp_c * 1.8f + 32;
    }

    public float getHumidity() {
        return this.humidity;
    }
}
