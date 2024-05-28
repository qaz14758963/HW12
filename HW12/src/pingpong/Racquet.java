package pingpong;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racquet extends JPanel {
    int x = 0;
    int step = 10;
    private static final int y = 570; // 新增三個球拍屬性的final變數,因為已經確定下來了不會再改
    private static final int WIDTH = 120;
    private static final int HEIGHT = 30;

    private Window window;

    public Racquet(Window w) {
        this.window = w;
    }

    public void moveLeft() {
        if (x - step >= 0) {
            x -= step;
        }
    }

    public void moveRight() {
        if (x + step <= window.getWidth() - WIDTH) {
            x += step;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
