package util;

import prog.MainProg.WaveFunction;

public class SineWave extends WaveForm {
    public SineWave(double freq, int amp, float sampleRate) {
        super(freq, amp, sampleRate);
    }
    public short getSample() {
        short ret = (short) (Math.sin(angle)*amplitude);
        progress();
        return ret;
    }
    public WaveFunction getWaveFunction() {
        return (x) -> { return (int) Math.sin(angle)*amplitude; };
    }
}
