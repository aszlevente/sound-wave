package util;

import prog.MainProg.WaveFunction;

public class SawtoothWave extends WaveForm {
    public SawtoothWave(double freq, int amp, float sampleRate) {
        super(freq, amp, sampleRate);
    }
    public short getSample() {
        double x = angle / (2.0 * Math.PI);
        short ret = (short) ((x-Math.floor(x))*amplitude);
        progress();
        return ret;
    }
    public WaveFunction getWaveFunction() {
        return (x) -> { return (int) ((x-Math.floor(x))*amplitude); };
    }
}
