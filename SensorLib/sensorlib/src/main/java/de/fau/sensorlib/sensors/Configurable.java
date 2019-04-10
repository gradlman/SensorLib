/*
 * Copyright (C) 2019 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */
package de.fau.sensorlib.sensors;

import java.util.HashMap;

import de.fau.sensorlib.sensors.configs.ConfigItem;

public interface Configurable {

    /**
     * Sets the sensor to the default configuration.
     */
    void setDefaultConfig();

    void setConfigMap(HashMap<String, Object> configMap);

    HashMap<String, ConfigItem> getConfigMap();

    HashMap<String, Object> getCurrentConfigMap();


}
