/*Copyright 2016 Bernd Porr

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.*/

package de.sensorlib.dataprocessinglib;

import uk.me.berndporr.iirj.Butterworth;

public class PPGFilterer {

    private Butterworth lpFilter;
    private Butterworth hpFilter;

    private int[] deriv1DerBuff;
    private int deriv1DerI = 0;

    /**
     * This constructor initializes a Butterworth low and highpass filter
     *
     * @param samplingRate This is the sampling rate of the PPG.
     * @param orderLow     This is the filter order of the lowpass filter.
     * @param orderHigh    This is the filter order of the highpass filter.
     * @param cutOffLow    This is the cutoff frequency of the lowpass filter.
     * @param cutOffHigh   This is the cutoff frequency of the highpass.
     */
    public PPGFilterer(int samplingRate, int orderLow, int orderHigh, double cutOffLow, double cutOffHigh) {
        lpFilter = new Butterworth();
        lpFilter.lowPass(orderLow, samplingRate, cutOffLow);
        hpFilter = new Butterworth();
        hpFilter.highPass(orderHigh, samplingRate, cutOffHigh);

        this.deriv1DerBuff = new int[((int) (10 / ((double) 1000 / (double) 250) + 0.5))];
    }

    /**
     * This constructor initializes a PPG Filterer, that is used for PAT calculation (LP: order 5, fc=8Hz; HP: order 2, fc=0.4Hz)
     *
     * @param samplingRate This is the sampling rate of the PPG signal
     */
    public PPGFilterer(int samplingRate) {
        this.lpFilter = new Butterworth();
        lpFilter.lowPass(5, samplingRate, 8);
        this.hpFilter = new Butterworth();
        hpFilter.highPass(2, samplingRate, 0.4);

        this.deriv1DerBuff = new int[((int) (10 / ((double) 1000 / (double) 250) + 0.5))];
    }

    /**
     * PPGFilter filters PPG data sample by sample by cascaded low and highpass filter.
     *
     * @param datum This is one sample of the PPG signal.
     * @return The filtered sample.
     */
    public int ppgFilter(int datum) {
        double fdatum;
        fdatum = lpFilter.filter((double) datum);  // Low pass filter data.
        fdatum = hpFilter.filter(fdatum); // High pass filter data.
        return ((int) fdatum);
    }

    /**
     * deriv1 implement derivative approximations represented by the difference equation:
     * <p>
     * y[n] = x[n] - x[n - 10ms]
     * <p>
     * Filter delay is DERIV_LENGTH/2
     *
     * @param x sample of an ECG signal
     * @return the result of the derivative approximation
     */
    public int deriv1(int x) {
        int y;
        y = x - deriv1DerBuff[deriv1DerI];
        deriv1DerBuff[deriv1DerI] = x;
        if (++deriv1DerI == ((int) (10 / ((double) 1000 / (double) 250) + 0.5)))
            deriv1DerI = 0;
        return (y);
    }

}
