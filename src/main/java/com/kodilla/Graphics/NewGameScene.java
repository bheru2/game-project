package com.kodilla.Graphics;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NewGameScene {

    public static MainMenuSubScene createNewGameSubScene(){
        MainMenuSubScene newGameSubScene = new MainMenuSubScene();
        Window.mainPane.getChildren().add(newGameSubScene);
        GameButton start = new GameButton("Start","underType.ttf");
        start.setLayoutX(200);
        start.setLayoutY(200);
        newGameSubScene.getPane().getChildren().add(start);
        newGameSubScene.getPane().getChildren().add(text());
        start.setOnAction(e-> {
            Game game = new Game();
            game.createNewGame(Window.window);
        });
        return newGameSubScene;
    }

    private static Label text() {
        Label label = new Label("Test");
        label.setPrefWidth(380);
        label.setPrefHeight(49);
        try {
            label.setFont(Font.loadFont(new FileInputStream("src/main/resources/font/underType.ttf"),21));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        return label;
    }
}
