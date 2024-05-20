package org.example;

public class Bird {
    private int Y;
    private char[][] field_for_bird;
    private int[] X = {2, 3, 4};

    public Bird() {
    }

    public Bird(int y) {
        Y = y;
    }

    public int getY() {
        return Y;
    }
    public void setY(int y) {
        Y = y;
    }

    public int[] getX() {
        return X;
    }

    public char[][] getField_for_bird() {
        return field_for_bird;
    }

    public void setField_for_bird(char[][] field_for_bird) {
        this.field_for_bird = field_for_bird;
    }

    public char[][] addBirdOnField(char[][] field){

        char[][] newField = new char[field.length][]; // клоную
        for (int i = 0; i < field.length; i++) {
            newField[i] = field[i].clone();
        }

        newField[Y][X[0]] = '[';
        newField[Y][X[1]] = ']';
        newField[Y][X[2]] = '>';
        return newField;
    }

    public void test(){
        while (this.Y == 10){
            System.out.println("Y:" + this.Y);
        }
    }
}
