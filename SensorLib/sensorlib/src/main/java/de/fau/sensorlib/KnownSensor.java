package de.fau.sensorlib;

import java.util.EnumSet;

import de.fau.sensorlib.DsSensor.HardwareSensor;

/**
 * List of all known sensors implemented in the SensorLib with
 * a descriptive and identifying String for each, a set of available hardware sensors,
 * and if the sensor device offers battery measurement.
 */
public enum KnownSensor {
    // =============================================================================================
    // = List of all implemented sensors in the SensorLib
    // =============================================================================================
    INTERNAL("<Internal>", new String[]{"n/a"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.ORIENTATION,
                    HardwareSensor.LIGHT,
                    HardwareSensor.PRESSURE,
                    HardwareSensor.TEMPERATURE
            ), true),

    GENERIC_BLE("Generic BLE Sensor", new String[]{"BLE", "Polar", "miCoach"},
            EnumSet.noneOf(
                    HardwareSensor.class
            ), false),

    GENERIC_SIMULATED("Generic Simulated Sensor", new String[]{"n/a"},
            EnumSet.noneOf(
                    HardwareSensor.class
            ), true),

    EMPATICA("Empatica", new String[]{"Empatica"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.BLOOD_VOLUME_PRESSURE,
                    HardwareSensor.GALVANIC_SKIN_RESPONSE,
                    HardwareSensor.HEART_RATE
            ), true),

    FITNESS_SHIRT("FitnessSHIRT", new String[]{"FSv3"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.ECG,
                    HardwareSensor.HEART_RATE,
                    HardwareSensor.RESPIRATION
            ), false),

    MYO("Myo", new String[]{"Myo"},
            EnumSet.of(
                    HardwareSensor.GESTURE,
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.ORIENTATION
            ), false),

    MYO_RAW("Myo Raw", new String[]{"Myo Raw"},
            EnumSet.of(
                    HardwareSensor.EMG
            ), false),

    SHIMMER("Shimmer", new String[]{"RN42", "Shimmer3"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER,
                    HardwareSensor.ECG,
                    HardwareSensor.EMG
            ), false),

    BLE_ECG_SENSOR("BleEcgSensor", new String[]{"POSTAGE"},
            EnumSet.of(
                    HardwareSensor.ECG
            ), false),

    SIMBLEE("Simblee", new String[]{"Simblee"},
            EnumSet.of(
                    HardwareSensor.ECG,
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.RESPIRATION
            ), false),

    SMARTWATCH("SmartWatch", new String[]{"Moto"},
            EnumSet.of(
                    HardwareSensor.ACCELEROMETER,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.MAGNETOMETER
            ), true),

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
            ), true),

    SMARTBAND2("Smartband 2", new String[]{"SWR12"},
            EnumSet.of(
                    HardwareSensor.HEART_RATE
            ), true),
    MUSE("Muse", new String[]{"Muse"},
            EnumSet.of(
                    HardwareSensor.EEG_RAW,
                    HardwareSensor.EEG_FREQ_BANDS,
                    HardwareSensor.GYROSCOPE,
                    HardwareSensor.ACCELEROMETER
            ), true);
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

    /**
     * Boolean indicating whether the sensor device offers battery measurement
     */
    private boolean mHasBatteryMeasurement;

    /**
     * Default constructor.
     *
     * @param descriptiveName     a descriptive name for the sensor type/class.
     * @param identifyingKeywords keywords that can be used to identify this sensor type/class given only the name e.g. reported via Bluetooth.
     */
    KnownSensor(String descriptiveName, String[] identifyingKeywords, EnumSet<HardwareSensor> availableSensors, boolean hasBatteryMeasurement) {
        mDescriptiveName = descriptiveName;
        mIdentifyingKeywords = identifyingKeywords;
        mAvailableSensors = availableSensors;
        mHasBatteryMeasurement = hasBatteryMeasurement;
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
     * Checks if the sensor offers battery measurement.
     *
     * @return true if battery measurement is available, false otherwise
     */
    public boolean hasBatteryMeasurement() {
        return mHasBatteryMeasurement;
    }

    /**
     * Infers the most likely sensor class based on the device name.
     *
     * @param deviceName    the device name of the sensor/device.
     * @param deviceAddress address of the device.
     * @return the KnownSensors enum corresponding to the given deviceName or null if it could not be associated with any entry.
     */
    public static KnownSensor inferSensorClass(String deviceName, String deviceAddress) {
        // TODO: Do we need the device address as parameter?
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
