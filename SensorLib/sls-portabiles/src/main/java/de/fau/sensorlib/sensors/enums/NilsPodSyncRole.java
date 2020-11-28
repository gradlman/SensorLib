/*
 * Copyright (C) 2019 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */
package de.fau.sensorlib.sensors.enums;

import androidx.annotation.NonNull;

import org.apache.commons.text.WordUtils;

/**
 * Enum describing the synchronization role of the NilsPod sensor
 */
public enum NilsPodSyncRole {
    SYNC_ROLE_DISABLED,
    SYNC_ROLE_SLAVE,
    SYNC_ROLE_MASTER;

    @NonNull
    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace("SYNC_ROLE", "").replace('_', ' '));
    }
}
