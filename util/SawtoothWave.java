package util;

public class SawtoothWave extends WaveForm {
    public SawtoothWave(double freq, double amp, float sampleRate) {
        super(freq, amp, sampleRate);
    }
    public double function(double x) {
        x *= frequency;
        return ((x-Math.floor(x)) * 2*amplitude) - amplitude;
    }
}
