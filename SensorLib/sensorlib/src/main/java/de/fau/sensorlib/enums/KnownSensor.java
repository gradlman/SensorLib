/*
 * Copyright (C) 2018 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */
package de.fau.sensorlib.enums;

import java.util.EnumSet;

/**
 * List of all known sensors implemented in the SensorLib with
 * a descriptive and identifying String for each, a set of available hardware sensors,
 * and if the sensor device offers battery measurement.
 */
public enum KnownSensor {
    // =============================================================================================
    // = List of all implemented sensors in the sensor lib
    // =============================================================================================
    INTERNAL("<Internal Sensor>", new String[]{"Internal"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.ORIENTATION,
                    HardwareSensor.LIGHT,
                    HardwareSensor.BAROMETER,
                    HardwareSensor.TEMPERATURE,
                    HardwareSensor.HUMIDITY
            ), "InternalSensor"),

    GENERIC_BLE("Generic BLE Sensor", new String[]{"BLE", "Polar", "miCoach"},
            EnumSet.noneOf(
                    HardwareSensor.class
            ), "GenericBleSensor"),

    GENERIC_SIMULATED("Generic Simulated Sensor", new String[]{"Simulator"},
            EnumSet.noneOf(
                    HardwareSensor.class
            ), "SimulatedSensor"),

    EMPATICA("Empatica", new String[]{"Empatica"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.BLOOD_VOLUME_PRESSURE,
                    HardwareSensor.GALVANIC_SKIN_RESPONSE,
                    HardwareSensor.HEART_RATE
            ), "EmpaticaSensor"),

    FITNESS_SHIRT("FitnessSHIRT", new String[]{"FSv3"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.ECG,
                    HardwareSensor.HEART_RATE,
                    HardwareSensor.RESPIRATION
            ), "FitnessShirt"),

    MYO("Myo", new String[]{"Myo"},
            EnumSet.of(
                    HardwareSensor.GESTURE,
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.ORIENTATION
            ), "MyoSensor"),

    MYO_RAW("Myo Raw", new String[]{"Myo Raw"},
            EnumSet.of(
                    HardwareSensor.EMG
            ), "MyoRawSensor"),

    SHIMMER("Shimmer", new String[]{"RN42", "Shimmer3"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.ECG,
                    HardwareSensor.EMG
            ), "ShimmerSensor"),

    BLE_ECG_SENSOR("BleEcgSensor", new String[]{"POSTAGE"},
            EnumSet.of(
                    HardwareSensor.ECG
            ), "BleEcgSensor"),

    SIMBLEE("Simblee", new String[]{"Simblee"},
            EnumSet.of(
                    HardwareSensor.ECG,
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.RESPIRATION
            ), "SimbleeSensor"),

    SMARTWATCH("SmartWatch", new String[]{"Moto"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER
            ), "SmartWatch"),

    TEK("Bosch TEK", new String[]{"PRM-TECH"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.QUATERNION,
                    HardwareSensor.TEMPERATURE,
                    HardwareSensor.HUMIDITY,
                    HardwareSensor.PRESSURE,
                    HardwareSensor.LIGHT,
                    HardwareSensor.NOISE
            ), "TekSensor"),

    SMARTBAND2("Smartband 2", new String[]{"SWR12"},
            EnumSet.of(
                    HardwareSensor.HEART_RATE
            ), "Smartband2Sensor"),

    FIT_SMART("FIT SMART", new String[]{"FIT SMART"},
            EnumSet.of(
                    HardwareSensor.HEART_RATE
            ), "FitSmart"),

    MUSE("Muse", new String[]{"Muse"},
            EnumSet.of(
                    HardwareSensor.EEG_RAW,
                    HardwareSensor.EEG_FREQ_BANDS,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.ACCELEROMETER
            ), "MuseSensor"),

    HOOP_SENSOR("Hoop Sensor", new String[]{"Hoop", "HOOP", "Portabiles"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE
            ), "HoopSensor"),

    NILSPOD("NilsPod", new String[]{"NilsPod-", "NilsPodX"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.BAROMETER,
                    HardwareSensor.TEMPERATURE
            ), "NilsPodSensor"),
    OPEN_BADGE("OpenBadge", new String[]{"HDBDG", "BADGE"},
            EnumSet.of(
                    HardwareSensor.MICROPHONE,
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.RSSI
            ), "OpenBadgeSensor"),
    DFU_TARG("DfuTarg", new String[]{"DfuTarg"},
            EnumSet.noneOf(HardwareSensor.class),
            "DfuTargSensor"
    );

    // =============================================================================================

    /**
     * Descriptive sensor device name
     */
    private String mDescriptiveName;
    /**
     * Identifiers for the sensor device
     */
    private String[] mIdentifyingKeywords;

    /**
     * The available hardware sensors for this sensor device
     */
    private EnumSet<HardwareSensor> mAvailableSensors;

    private Class<?> mSensorClass;

    /**
     * Default constructor.
     *
     * @param descriptiveName     a descriptive name for the sensor type/class.
     * @param identifyingKeywords keywords that can be used to identify this sensor type/class given only the name e.g. reported via Bluetooth.
     */
    KnownSensor(String descriptiveName, String[] identifyingKeywords, EnumSet<HardwareSensor> availableSensors) {
        this(descriptiveName, identifyingKeywords, availableSensors, null);
    }

    /**
     * Default constructor.
     *
     * @param descriptiveName     a descriptive name for the sensor type/class.
     * @param identifyingKeywords keywords that can be used to identify this sensor type/class given only the name e.g. reported via Bluetooth.
     */
    KnownSensor(String descriptiveName, String[] identifyingKeywords, EnumSet<HardwareSensor> availableSensors, String className) {
        mDescriptiveName = descriptiveName;
        mIdentifyingKeywords = identifyingKeywords;
        mAvailableSensors = availableSensors;
        try {
            mSensorClass = Class.forName("de.fau.sensorlib.sensors." + className);
        } catch (ClassNotFoundException ignored) {

        }
    }

    /**
     * Returns a set of available hardware sensors.
     *
     * @return Set of available hardware sensors for the sensor device
     */
    public EnumSet<HardwareSensor> getAvailableSensors() {
        return mAvailableSensors;
    }


    /**
     * Returns the class type of the corresponding Sensor.
     *
     * @return the class type of the sensor as Java-Class
     */
    public Class<?> getClassType() {
        return mSensorClass;
    }

    /**
     * Infers the most likely sensor class based on the device name.
     *
     * @param deviceName the device name of the sensor/device.
     * @return the KnownSensors enum corresponding to the given deviceName or null if it could not be associated with any entry.
     */
    public static KnownSensor inferSensorClass(String deviceName) {
        for (KnownSensor s : KnownSensor.values()) {
            if (s.mIdentifyingKeywords == null || s.mIdentifyingKeywords.length <= 0) {
                continue;
            }
            for (String str : s.mIdentifyingKeywords) {
                if (deviceName == null || deviceName.isEmpty()) {
                    continue;
                }
                if (deviceName.contains(str)) {
                    return s;
                }
            }
        }
        return null;
    }
}
