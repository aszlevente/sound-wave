package util;

import java.util.ArrayList;

import draw.MainCanvas;

public class StackWaveForm extends WaveForm {
    protected ArrayList<WaveForm> layers = new ArrayList<>();
    
    public StackWaveForm() {
        super(1, 1, 1);
    }
    public StackWaveForm(ArrayList<WaveForm> lys) {
        super(1, 1, 1);
        layers = lys;
    }

    public void addLayer(WaveForm layer) {
        layers.add(layer);
        for (WaveForm wave : layers) { wave.resetAngle(); }
    }

    @Override
    public short getSample() {
        short ret = (short) Math.round(function(angle));
        for (WaveForm layer : layers) { layer.progress(); }
        return ret;
    }
    
    @Override
    public int getDrawY(int x) {
        double xPrec = x / 10000.0;
        double maxFreqHeight = 32767 / (MainCanvas.W_HEIGHT/2.0);
        return (int) Math.round(function(xPrec) / maxFreqHeight);
    }

    public double function(double x) {
        double sum = 0;
        for (WaveForm layer : layers) {
            sum += layer.function(x);
        }
        return Math.min(sum, 32767);
    }
}
