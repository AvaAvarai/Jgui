import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.Runnable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Jgui implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Jgui());
    }

    @Override
    public void run() {
        JGuiFrame frame = new JGuiFrame();
    }

    public class JGuiFrame extends JFrame {
        public JGuiFrame() {
            super("TITLE HERE");
            setPreferredSize(new Dimension(640, 480));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(new JGuiPanel());
            pack();
            setLocationByPlatform(true);
            setVisible(true);
        }
    }

    public class JGuiPanel extends JPanel {
        public JGuiPanel() {
            super();
            setPreferredSize(new Dimension(640, 480));
            setBackground(Color.DARK_GRAY);
            setVisible(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i < getWidth(); i+=20) {
                g.drawLine(i, 0, i, getHeight());
            }
            for (int i = 0; i < getHeight(); i+=20) {
                g.drawLine(0, i, getWidth(), i);
            }
        }
    }
}

