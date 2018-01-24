package com.mlaf.hu.casestudy.sensoragent;

import com.mlaf.hu.helpers.exceptions.SensorReadException;
import com.mlaf.hu.models.Measurement;
import com.mlaf.hu.models.Measurements;
import com.mlaf.hu.sensoragent.Sensor;
import com.pi4j.system.SystemInfo;

import java.io.IOException;
import java.util.logging.Level;

public class TempCPUSensor extends Sensor {
    public TempCPUSensor() {
        super(10);
    }

    @Override
    public String getSensorID() {
        return "CPUTEMP";
    }

    @Override
    public Measurements getMeasurements() {
        Measurements measurements = new Measurements();
        try {
            measurements.addMeasurement(new Measurement("temperature", getCPUTemp()));
        } catch (SensorReadException e) {
            SensorAgent.sensorAgentLogger.log(Level.SEVERE, "Could not read CPU temperature", e);
        }
        return measurements;
    }

    private float getCPUTemp() throws SensorReadException {
        try {
            return SystemInfo.getCpuTemperature();
        } catch (IOException | InterruptedException e) {
            throw new SensorReadException(e);
        }
    }
}
