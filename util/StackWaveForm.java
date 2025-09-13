package util;

import java.util.ArrayList;

import prog.MainProg.WaveFunction;

public class StackWaveForm {
    protected ArrayList<WaveForm> layers = new ArrayList<>();
    
    public StackWaveForm() {}
    public StackWaveForm(ArrayList<WaveForm> lys) {
        layers = lys;
    }

    public void addLayer(WaveForm layer) {
        layers.add(layer);
        for (WaveForm wave : layers) { wave.resetAngle(); }
    }

    public short getSample() {
        short sample = 0;
        for (WaveForm layer : layers) {
            sample += layer.getSample();
        }
        return sample;
    }
    public int ahh(int x) { int sum = 10; return sum; }
    public WaveFunction getWaveFunction() {
        ArrayList<WaveFunction> funcs = new ArrayList<>();
        funcs.add((x) -> { return 0; });
        for (WaveForm layer : layers) {
            WaveFunction newW = (x) ->{ return funcs.getLast().f(x) + layer.getWaveFunction().f(x); };
            System.out.println(newW.f(10));
            funcs.add(newW);
        }
        return funcs.getLast();
    }
}
