/*
 * Copyright (C) 2018 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */

package de.fau.sensorlib.dataframe;

/**
 * Humidity data frame.
 */
public interface HumidityDataFrame {

    String[] COLUMNS = new String[]{"humidity"};

    /**
     * Returns the humidity value.
     *
     * @return humidity value
     */
    double getHumidity();
}
