package monopoly.gui;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Dice {
    private Group diceGroup;
    private Group numberGroup;

    public Dice(){
        diceGroup = new Group();
        Rectangle cube = new Rectangle(50, 50);
        cube.setFill(Color.BEIGE);
        cube.setStrokeWidth(2.0);
        cube.setStroke(Color.DARKGRAY);
        cube.setArcHeight(10.0);
        cube.setArcWidth(10.0);
        diceGroup.getChildren().add(cube);

        numberGroup = drawDice(3);
        diceGroup.getChildren().add(numberGroup);
    }

    public Group getDiceGroup(){
        return diceGroup;
    }

    public void setTranslate(double x, double y){
        diceGroup.setTranslateX(x);
        diceGroup.setTranslateY(y);
    }

    public void setNumber(int number){
        diceGroup.getChildren().remove(numberGroup);
        numberGroup = drawDice(number);
        diceGroup.getChildren().add(numberGroup);
    }

    private Group drawDice(int num){
        Group number = new Group();
        switch (num){
            case 5:
                Circle cube5 = new Circle(25 - 15, 25 + 15, 5, Color.BLACK);
                Circle cube6 = new Circle(25 + 15, 25 - 15, 5, Color.BLACK);
                number.getChildren().addAll(cube5, cube6);
            case 3:
                Circle cube3 = new Circle(25 - 15, 25 - 15, 5, Color.BLACK);
                Circle cube4 = new Circle(25 + 15, 25 + 15, 5, Color.BLACK);
                number.getChildren().addAll(cube3, cube4);
            case 1:
                Circle cube2 = new Circle(25, 25, 5, Color.BLACK);
                number.getChildren().add(cube2);
                break;
            case 2:
                Circle cube7 = new Circle(25 - 10, 25 - 10, 5, Color.BLACK);
                Circle cube8 = new Circle(25 + 10, 25 + 10, 5, Color.BLACK);
                number.getChildren().addAll(cube7, cube8);
                break;
            case 4:
                for(int i = 0; i < 4; ++i) {
                    Circle c = new Circle(15 + i % 2 * 20, 15 + (i >> 1) * 20, 5, Color.BLACK);
                    number.getChildren().add(c);
                }
                break;
            case 6:
                for(int x = 0; x < 3; ++x) {
                    for(int y = 0; y < 2; ++y){
                        Circle c = new Circle(15 + y * 20, 11 + x * 14, 5, Color.BLACK);
                        number.getChildren().add(c);
                    }
                }
        }

        return number;
    }
}
