package util;

import prog.MainProg.WaveFunction;

abstract public class WaveForm {
    protected double frequency;
    protected int amplitude;
    protected double increment;
    protected double angle = 0;
    WaveForm(double freq, int amp, float sampleRate) {
        frequency = freq;
        amplitude = amp;
        increment = 2.0 * Math.PI * frequency / sampleRate;
    }
    abstract public short getSample();
    abstract public WaveFunction getWaveFunction();
    protected void progress() {
        angle += increment;
    }
    public void resetAngle() {
        angle = 0;
    }
}