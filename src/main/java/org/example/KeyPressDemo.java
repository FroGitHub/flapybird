package org.example;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressDemo extends JFrame implements KeyListener {

    private JPanel panel;

    public KeyPressDemo() {
        setTitle("Key Press");
        setSize(1, 1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        add(panel);
        panel.setFocusable(true);
        panel.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Викликається при натисканні та відпусканні символу клавіші
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Викликається при натисканні клавіші
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            System.out.println("Space key pressed");
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Викликається при відпусканні клавіші
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            System.out.println("Space key unpressed");
//        }
    }

}
