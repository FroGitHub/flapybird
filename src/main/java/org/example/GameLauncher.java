package org.example;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLauncher extends KeyPressDemo {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private Bird bird = new Bird(4);
    private char[][] field;
    private int[] size = {10, 90};

    private final Action_with_pine action_with_pine = new Action_with_pine();

    public void createField(){
        char[][] field  = new char[size[0]][size[1]];
        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = '.';
            }
        }
        this.field = field;
    }

    public void start(){
        Random random = new Random();

        Thread fieldThread = new Thread(() -> {
            int score = 0;
            String fieldForLabel;
            while (true) {
                boolean started = true;
                action_with_pine.create_pine(field, random.nextInt(1,5));
                try {
                    for (int i = 0; i < random.nextInt(15,25); i++) {
                        action_with_pine.move_field(field);

                        score += 1;
                        int finalScore = score;
                        fieldForLabel = action_with_pine.print_field(bird.addBirdOnField(field.clone()), finalScore);
                        String finalFieldForLabel = fieldForLabel;

                        SwingUtilities.invokeLater(() -> {
                            label.setText("");
                            label.setText(finalFieldForLabel); // Оновлення лейбла в потоці подій Swing
                        });

                        bird.setY(bird.getY() + 1);
                        if (field[bird.getY()][5] == '-' || field[bird.getY()][5] == '|') {
                            started = false;
                            break;
                        }
                        Thread.sleep(250); // <------------------------ speed
                        score++;
                    }
                    if (!started) {
                        System.out.println("you got pipe");
                        break;
                    }


                } catch (Exception e) {
                    System.out.println("Out of field");
                    break;
                }
            }
        });

        setTitle("FlapyBird");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setFocusable(true);
        panel.addKeyListener(this);
        panel.add(label);

        this.add(panel);
        this.setVisible(true);

        fieldThread.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Викликається при відпусканні клавіші
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.setY(bird.getY() - 2);
        }
    }
}
