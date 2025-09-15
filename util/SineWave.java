package util;

public class SineWave extends WaveForm {
    public SineWave(double freq, double amp, float sampleRate) {
        super(freq, amp, sampleRate);
    }
    public double function(double x) {
        return Math.sin(x*frequency) * amplitude;
    }
}