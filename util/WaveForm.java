package util;

import draw.MainCanvas;

abstract public class WaveForm {
    protected double frequency;
    protected double amplitude;
    protected double increment;
    protected double angle = 0;
    WaveForm(double freq, double amp, float sampleRate) {
        frequency = freq;
        amplitude = amp;
        increment = 2.0 * Math.PI * frequency / sampleRate;
    }
    abstract public double function(double x);
    public int getDrawY(int x) {
        double xPrec = x / 10000.0;
        double maxFreqHeight = 32767 / (MainCanvas.W_HEIGHT/2.0);
        return (int) Math.round(function(xPrec) / maxFreqHeight);
    }
    public short getSample() {
        short ret = (short) Math.round(function(angle)*MainCanvas.W_HEIGHT/amplitude);
        progress();
        return ret;
    }
    protected void progress() {
        angle += increment;
    }
    public void resetAngle() {
        angle = 0;
    }
}