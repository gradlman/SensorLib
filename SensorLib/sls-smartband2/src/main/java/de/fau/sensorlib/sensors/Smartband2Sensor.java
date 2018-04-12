/**
 * Copyright (C) 2015-2016 Digital Sports Group, Friedrich-Alexander University Erlangen-Nuremberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */
package de.fau.sensorlib.sensors;

import android.content.Context;
import android.os.Handler;

import de.fau.sensorlib.SensorDataProcessor;
import de.fau.sensorlib.SensorInfo;
import de.fau.sensorlib.enums.HardwareSensor;

/**
 * Implementation for the Sony Smartband 2.
 */
public class Smartband2Sensor extends GenericBleSensor {

    private static final String TAG = Smartband2Sensor.class.getSimpleName();

    private static final String DEVICE_NAME = "SWR12";

    public Smartband2Sensor(Context context, SensorInfo knownSensor, SensorDataProcessor dataHandler) {
        this(context, knownSensor.getName(), knownSensor.getDeviceAddress(), dataHandler);
    }

    public Smartband2Sensor(Context context, String deviceName, String deviceAddress, SensorDataProcessor dataHandler) {
        super(context, deviceName, deviceAddress, dataHandler, -1);
    }

    @Override
    public boolean connect() throws Exception {
        useHardwareSensor(HardwareSensor.HEART_RATE);
        return super.connect();
    }

    @Override
    public void startStreaming() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Smartband2Sensor.super.startStreaming();
            }
        }, 5000);
    }
}
