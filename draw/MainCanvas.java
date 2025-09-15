package draw;

import java.awt.*;
import javax.swing.*;

import util.SineWave;
import util.WaveForm;

public class MainCanvas extends JFrame {
    public MyCanvas canvas = new MyCanvas();
    protected WaveForm wave;

    public static int W_WIDTH = 500;
    public static int W_HEIGHT = 375;
    private static int DELTA = 1;

    public MainCanvas() {
        wave = new SineWave(220, 32767, 44100);

        setLayout(new BorderLayout());
        setSize(W_WIDTH, W_HEIGHT+40);
        setTitle("Wave Generator");
        add("Center", canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            for (int x = 0; x < W_WIDTH; x += DELTA) {
                g.drawLine(x, W_HEIGHT/2 - wave.getDrawY(x), x+DELTA, W_HEIGHT/2 - wave.getDrawY(x+DELTA));
            }
        }
    }

    public void drawFunction(WaveForm newWave) {
        wave = newWave;
        repaint();
    }
}
