package com.kodilla.Graphics;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class MenuItem extends StackPane {

    public MenuItem(String name) {

        Rectangle menuBox = new Rectangle(600,48);
        LinearGradient gradient = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLACK),
                new Stop(0.4 ,Color.DARKGRAY));

        menuBox.setFill(gradient);
        menuBox.setVisible(false);
        menuBox.setEffect(new DropShadow(6,0,4,Color.BLACK));

        Text text = new Text(name+"          ");
        text.setFill(Color.LIGHTGRAY);
        text.setFont(Font.font(40));
        setAlignment(Pos.CENTER_RIGHT);
        getChildren().addAll(menuBox,text);

        setOnMouseEntered(e-> {
            menuBox.setVisible(true);
            text.setFill(Color.WHITE);
        });

        setOnMouseExited(e-> {
            menuBox.setVisible(false);
            text.setFill(Color.LIGHTGRAY);
        });

        setOnMousePressed(e-> {
            text.setFill(Color.BLACK);
            menuBox.setFill(Color.WHITE);
        });

        setOnMouseReleased(e-> {
            menuBox.setFill(gradient);
            text.setFill(Color.WHITE);
        });
    }
}
