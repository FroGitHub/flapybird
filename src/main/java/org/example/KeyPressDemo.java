package org.example;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressDemo extends JFrame implements KeyListener {

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
