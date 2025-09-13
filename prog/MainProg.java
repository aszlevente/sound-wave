package prog;

import javax.sound.sampled.*;

import util.*;
import draw.*;

public class MainProg {
    public static void main(String[] args) throws LineUnavailableException {
        float sampleRate = 44100;
        int bufferSize = 4410;

        AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, true);
        SourceDataLine line = AudioSystem.getSourceDataLine(format);

        line.open(format, bufferSize);
        line.start();

        StackWaveForm stack = new StackWaveForm();
        stack.addLayer(new SawtoothWave(220, 32767, sampleRate));
        stack.addLayer(new SawtoothWave(440, 32767, sampleRate));
        stack.addLayer(new SawtoothWave(880, 32767, sampleRate));
        byte[] buffer = new byte[bufferSize];

        MainCanvas canvas = new MainCanvas();
        canvas.drawFunction(stack.getWaveFunction());

        while (true) {
            for (int i = 0; i < buffer.length / 2; ++i) {
                short sample = stack.getSample();
                buffer[2*i] = (byte) ((sample >> 8) & 0xFF);
                buffer[2*i + 1] = (byte) (sample & 0xFF);
            }
            line.write(buffer, 0, buffer.length);
        }
    }

    public interface WaveFunction {
        int f(int x);
    }
}
