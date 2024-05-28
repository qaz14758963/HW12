package pingpong;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball extends JPanel {
    private static final int ballsize = 60;
    int x = 0; // �p�y���w�]��m
    int y = 0;
    int step = 10;
    int incx = step; // �o�O�p�y�n���ʪ����
    int incy = step;
    private Window window;

    public Ball(Window w) {
        this.window = w;
    }

    private boolean collision() {
        return window.racquet.getBounds().intersects(getBounds());
    }

    public static int getBallsize() {
        return ballsize;
    }

    void moveBall() {
        if (x + incx > window.getWidth() - ballsize) // �p�G�p�y���ʫ᪺��m�W�X�����d�򪺸�,���ʤ�V�N�O-1; �A�����y���j�p
            incx = -step;
        if (x + incx < 0) // �P�z
            incx = step;
        if (y + incy > window.getHeight() - ballsize)
            incy = -step;
        if (y + incy < 0)
            incy = step;

        if (collision()) {
            incy = -step;
            window.incrementScore();
        }

        x += incx;
        y += incy;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.darkGray); //�]�w�C��
        g.fillOval(x, y, ballsize, ballsize); //(x�b, y�b, �y���e��, �y������)
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ballsize, ballsize);
    }
}
