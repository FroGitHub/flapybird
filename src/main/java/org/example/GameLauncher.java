package org.example;


import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLauncher extends KeyPressDemo {

    private Bird bird = new Bird(4);
    private char[][] field;
    private int[] size = {9, 51};

    private final Action_with_pine action_with_pine = new Action_with_pine();

    public void createField(){
        char[][] field  = new char[size[0]][size[1]];
        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ' ';
            }
        }
        this.field = field;
    }

    public void start(){
        Random random = new Random();

        this.setVisible(true);

        Thread fieldThread = new Thread(() ->
        {
            int score = 0;
            while (true) {
                boolean started = true;
                action_with_pine.create_pine(field, random.nextInt(1,5));

                try {
                    for (int i = 0; i < random.nextInt(15,25); i++) {
                        action_with_pine.move_field(field);

                        action_with_pine.print_field(bird.addBirdOnField(field.clone()), score);
                        bird.setY(bird.getY() + 1);
                        if (field[bird.getY()][5] == '-' || field[bird.getY()][5] == '|') {
                            started = false;
                            break;
                        }
                        Thread.sleep(650); // <------------------------ speed
                        score++;
                    }
                    if (!started) {
                        this. dispose();
                        System.out.println("you got pipe");
                        break;
                    }


                } catch (Exception e) {
                    this.  dispose();
                    System.out.println("Out of field");
                    break;
                }
            }
        });

        fieldThread.start();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Викликається при відпусканні клавіші
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.setY(bird.getY() - 2);
        }
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

}
