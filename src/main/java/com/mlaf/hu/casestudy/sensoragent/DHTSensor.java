package com.mlaf.hu.casestudy.sensoragent;

import com.mlaf.hu.helpers.exceptions.SensorReadException;
import com.mlaf.hu.models.Measurement;
import com.mlaf.hu.models.Measurements;
import com.mlaf.hu.sensoragent.Sensor;
import com.pi4j.system.SystemInfo;

import java.io.IOException;
import java.util.logging.Level;

public class DHTSensor extends Sensor {
    private DHT11 dhtSensor;
    public DHTSensor(int pin, int readinterval) {
        super(10);
        dhtSensor = new DHT11(pin);
    }

    @Override
    public String getSensorID() {
        return "DHT11";
    }

    @Override
    public Measurements getMeasurements() {
        Measurements measurements = new Measurements();
        try {
            DHTReading reading = readDHT(30);
            measurements.addMeasurement(new Measurement("temperature", reading.getTemperatureC()));
            measurements.addMeasurement(new Measurement("humidity", reading.getHumidity()));
        } catch (SensorReadException e) {
            SensorAgent.sensorAgentLogger.log(Level.SEVERE, "Could not read sensor", e);
        }
        return measurements;
    }

    private DHTReading readDHT(int maxAttempts) throws SensorReadException {
        int x = 0;
        while (x < maxAttempts) {
            DHTReading reading = this.dhtSensor.read();
            if (reading != null) {
                return reading;
            }
            x++;
        }
        throw new SensorReadException("Could nog get valid reading");
    }
}
