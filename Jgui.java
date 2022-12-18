import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.Runnable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Jgui implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Jgui());
    }

    @Override
    public void run() {
        new JGuiFrame();
    }

    public class JGuiFrame extends JFrame {
        public JGuiFrame() {
            super("TITLE HERE");
            setPreferredSize(new Dimension(640, 480));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JGuiPanel panel = new JGuiPanel();
            add(panel);
            pack();
            setLocationByPlatform(true);
            setVisible(true);
        }
    }

    public class JGuiPanel extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener {

        int zoom;
        Point pos;

        public JGuiPanel() {
            super();
            zoom = 20;
            pos = new Point(0, 0);
            setPreferredSize(new Dimension(640, 480));
            setBackground(Color.DARK_GRAY);
            addMouseWheelListener(this);
            addMouseListener(this);
            addMouseMotionListener(this);
            setVisible(true);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {
            pos = e.getPoint();
            repaint();
        }

        @Override
	    public void mouseWheelMoved(MouseWheelEvent e) {
            int dir = e.getWheelRotation();
            if (dir > 0 && zoom < 200) {
               zoom+=5;
            } else if (zoom > 5) {
               zoom-=5;
            }
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i < getWidth(); i+=zoom) {
                g.drawLine(i, 0, i, getHeight());
            }
            for (int i = 0; i < getHeight(); i+=zoom) {
                g.drawLine(0, i, getWidth(), i);
            }
            g.setColor(Color.WHITE);
            g.drawString("mousePos: (" + pos.getX() + ", " + pos.getY() + ")", 5, 15);

        }
   }
}

