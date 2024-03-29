package com.kodilla.Graphics;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameButton extends Button {

    public GameButton(String text, String fontName) {
        setText(text);
        setButtonFont("src/main/resources/font/" + fontName);
        setPrefWidth(201);
        setPrefHeight(56);
        setTextFill(Color.BLACK);
        setStyle("-fx-background-color: transparent; -fx-background-image: url('/buttons/test.png')");
        buttonOnAction();
    }

    private void setButtonFont(String path) {
        try {
            setFont(Font.loadFont(new FileInputStream(path), 24));
        } catch (FileNotFoundException e) {
            setFont((Font.font("Verdana", 24)));
        }
    }

    private void buttonOnAction() {
        setOnMousePressed(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                setLayoutY(getLayoutY() - 4);
            }
        });

        setOnMouseReleased(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                setLayoutY(getLayoutY() + 4);
            }
        });

        setOnMouseEntered(e -> setEffect(new DropShadow()));
        setOnMouseExited(e -> setEffect(null));
    }
}
