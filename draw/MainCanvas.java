package draw;

import java.awt.*;
import javax.swing.*;
import prog.MainProg.WaveFunction;

public class MainCanvas extends JFrame {
    public MyCanvas canvas = new MyCanvas();
    private WaveFunction function;

    public static int W_WIDTH = 500;
    public static int W_HEIGHT = 375;
    private static int DELTA = 5;

    public MainCanvas() {
        drawFunction((x) -> { return 0; });

        setLayout(new BorderLayout());
        setSize(W_WIDTH, W_HEIGHT);
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
                g.drawLine(x, W_HEIGHT/2 - function.f(x), x+DELTA, W_HEIGHT/2 - function.f(x+DELTA));
            }
        }
    }

    public void drawFunction(WaveFunction func) {
        function = func;
        repaint();
    }
}
