/*
 * Copyright (C) 2019 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. If you reuse
 * this code you have to keep or cite this comment.
 */

package de.fau.sensorlib.sensors.logging;

import java.util.Date;

public class Session {

    private static final String TAG = Session.class.getSimpleName();

    private int mStartPage;
    private int mEndPage;

    private int mSamplingRate;
    private boolean mVoltageTerminated;

    private Date mStartTime;
    private int mSampleSize;


    public Session(byte[] sessionPacket) {
        int offset = 0;
        mStartPage = (sessionPacket[offset++] << 16) | (sessionPacket[offset++] << 8) | sessionPacket[offset++];
        mEndPage = (sessionPacket[offset++] << 16) | (sessionPacket[offset++] << 8) | sessionPacket[offset++];

        mSamplingRate = sessionPacket[offset] & 0x7F;
        mVoltageTerminated = (sessionPacket[offset++] & 0x80) != 0;

        int tmpTime = (sessionPacket[offset++] << 24) | (sessionPacket[offset++] << 16) | (sessionPacket[offset++] << 8) | sessionPacket[offset++];
        mStartTime = new Date(((long) tmpTime) * 1000);

        mSampleSize = sessionPacket[offset];
    }


    @Override
    public String toString() {
        return "<Session> [" +
                mStartPage + "-" + mEndPage + "] @ " + mStartTime + " | " +
                "sampling rate: " + mSamplingRate + " Hz, sample size: " +
                mSampleSize + ", voltage terminated: " + mVoltageTerminated;
    }
}