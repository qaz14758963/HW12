package pingpong;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {
    static int score;
    Ball ball;
    Racquet racquet;

    public Window() {
        this.setTitle("不要讓球掉下去!!");
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ball = new Ball(this);
        racquet = new Racquet(this);
        addKeyListener(this);
        setFocusable(true);
    }

    public void incrementScore() {
        score++;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 50));
        g2d.drawString(String.valueOf(score), 500, 120);
        ball.paint(g2d);
        racquet.paint(g2d);
    }

    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        while (true) {
            window.move();
            window.repaint();
            Thread.sleep(300);
        }
    }

    private void move() {
        ball.moveBall();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            racquet.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            racquet.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed
    }
}
