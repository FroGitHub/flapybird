package org.example;


public class Action_with_pine {

    public void create_pine(char[][] field, int top_pine){
        int down_pine = 4 - top_pine;
        int vertical = field.length - 1;
        int gorizont = field[0].length - 2;

        for (int i = 0; i < top_pine; i++) {
            field[i][gorizont] = '|';
            field[i][gorizont - 1] = '|';
        }
        field[top_pine][gorizont] = '-';
        field[top_pine][gorizont - 1] = '-';

        for (int i = 0; i < down_pine; i++) {
            field[vertical - i][gorizont] = '|';
            field[vertical - i][gorizont - 1] = '|';
        }
        field[vertical - down_pine][gorizont] = '-';
        field[vertical - down_pine][gorizont - 1] = '-';

    }

    public String print_field(char[][] field, int score){
        StringBuilder field_in_string = new StringBuilder("");
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length - 3; j++) {
                field_in_string.append(field[i][j]);
            }
            if (i != field.length - 1) {
                field_in_string.append("<br>");
            }
        }
        field_in_string.append("<br>=================================|Score: " + score);
        return "<html>" + field_in_string + "</html>";
    }

    public void move_field(char[][] field){
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length - 1; j++) {
                field[i][j] = field[i][j + 1];
            }
        }
    }
}
