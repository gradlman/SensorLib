package de.fau.sensorlib.widgets;

import java.util.HashMap;

import de.fau.sensorlib.R;
import de.fau.sensorlib.enums.HardwareSensor;

/**
 * Maps a {@link de.fau.sensorlib.enums.HardwareSensor} to color values for plotting sensor data.
 */
public class PlotColorMap {

    private static HashMap<HardwareSensor, int[]> sColorMap = new HashMap<>();


    static {
        sColorMap.put(HardwareSensor.ACCELEROMETER, new int[]{R.color.accel_x, R.color.accel_y, R.color.accel_z});
        sColorMap.put(HardwareSensor.GYROSCOPE, new int[]{R.color.gyro_x, R.color.gyro_y, R.color.gyro_z});
        sColorMap.put(HardwareSensor.ECG, new int[]{R.color.ecg_1, R.color.ecg_2});
        sColorMap.put(HardwareSensor.PPG, new int[]{R.color.ppg_1, R.color.ppg_2});
        sColorMap.put(HardwareSensor.FSR, new int[]{R.color.press_1, R.color.press_2, R.color.press_3});
        sColorMap.put(HardwareSensor.BAROMETER, new int[]{R.color.baro});
    }


    public static int[] getColors(HardwareSensor sensor) {
        int[] colors = sColorMap.get(sensor);
        if (colors == null) {
            try {
                colors = new int[((String[]) (sensor.getDataFrameClass().getDeclaredField("COLUMNS").get(null))).length];
            } catch (Exception ignore) {
            }
        }
        return colors;
    }

}
