/*
 * Copyright (C) 2018 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */
package de.fau.sensorlib;

import de.fau.sensorlib.dataframe.SensorDataFrame;
import de.fau.sensorlib.sensors.AbstractSensor;

/**
 * Base abstract class for all sensor data processors/handlers.
 */
public abstract class SensorDataProcessor {
    /**
     * This is called every time a new data frame (sample) is received from the sensor.
     *
     * @param data the data frame transmitted.
     */
    public abstract void onNewData(SensorDataFrame data);

    /**
     * This is called after the sensor has internally been initialized. This depends on the sensor. However it is guaranteed that it will always be called before the
     * first connection attempt to the sensor is made.
     *
     * @param sensor the corresponding sensor.
     */
    public void onSensorCreated(AbstractSensor sensor) {
    }

    /**
     * This is called after the sensor has been (successfully) connected.
     *
     * @param sensor the corresponding sensor.
     */
    public void onConnected(AbstractSensor sensor) {
    }

    /**
     * This is called when trying to connect to the sensor
     *
     * @param sensor the corresponding sensor.
     */
    public void onConnecting(AbstractSensor sensor) {

    }

    /**
     * This is called after the sensor has been disconnected.
     *
     * @param sensor the corresponding sensor.
     */
    public void onDisconnected(AbstractSensor sensor) {
    }

    /**
     * This is called when the connection has been lost.
     *
     * @param sensor the corresponding sensor.
     */
    public void onConnectionLost(AbstractSensor sensor) {

    }

    /**
     * This is called when the sensor is connected and starts streaming data.
     *
     * @param sensor the corresponding sensor.
     */
    public void onStartStreaming(AbstractSensor sensor) {
    }

    /**
     * This is called when the sensor stopped streaming data but is still connected.
     *
     * @param sensor the corresponding sensor.
     */
    public void onStopStreaming(AbstractSensor sensor) {
    }

    /**
     * Is sent when the sampling rate changed for the given sensor. This can happen e.g. when a sampling rate of 200 Hz is requested, but the sensor only supports 204 Hz,
     * then this will be sent as soon as the sensor reported its actually used sampling rate. This will ONLY be called if the new sampling rate is different from the old
     * one.
     *
     * @param sensor the corresponding sensor.
     */
    public void onSamplingRateChanged(AbstractSensor sensor, double newSamplingRate) {
    }

    /**
     * Is sent when the sensor provides any informative notifications.
     *
     * @param sensor       the corresponding sensor.
     * @param notification an object extended class (usually a string) that contains the notification.
     */
    public void onNotify(AbstractSensor sensor, Object notification) {
    }
}