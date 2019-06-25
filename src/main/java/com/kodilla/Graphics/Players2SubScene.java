package com.kodilla.Graphics;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Players2SubScene extends StackPane {

    public Players2SubScene(String path) {
        Rectangle background = new Rectangle(Size.WIDTH / 2, Size.HEIGHT);
        background.setOpacity(0.4);

        DropShadow shadow = new DropShadow(15, 5, 0, Color.BLACK);
        shadow.setSpread(0.8);

        background.setEffect(shadow);
        getChildren().addAll(background);
    }

    void show() {
        setVisible(true);
        TranslateTransition transform = new TranslateTransition(Duration.seconds(0.8), this);
        transform.setToX(-Size.WIDTH/2);
        transform.play();
    }

    void hide(int translate) {
        TranslateTransition transform = new TranslateTransition(Duration.seconds(0.8), this);
        transform.setToX(translate);
        transform.setOnFinished(e -> setVisible(false));
        transform.play();
    }
}
