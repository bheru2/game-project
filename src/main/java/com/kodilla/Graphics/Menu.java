package com.kodilla.Graphics;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Menu extends StackPane {

    void createMenu(String title, MenuItem... items) {
        Rectangle background = new Rectangle(Size.WIDTH / 2, Size.HEIGHT);
        background.setOpacity(0.4);

        DropShadow shadow = new DropShadow(15, 5, 0, Color.BLACK);
        shadow.setSpread(0.8);

        background.setEffect(shadow);

        Text text = new Text(title);
        text.setFont(Font.font(80));
        text.setFill(Color.WHITE);

        Line hSep = new Line();
        hSep.setEndX(512);
        hSep.setStroke(Color.DARKGREEN);
        hSep.setOpacity(0.4);

        Line vSep = new Line();
        vSep.setStartX(512);
        vSep.setEndX(512);
        vSep.setEndY(768);
        vSep.setStroke(Color.DARKGREEN);
        vSep.setOpacity(0.4);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(60, 0, 0, 0));
        vBox.getChildren().addAll(text, hSep);
        vBox.getChildren().addAll(items);

        setAlignment(Pos.TOP_RIGHT);
        getChildren().addAll(background, vSep, vBox);
    }

    void show() {
        setVisible(true);
        TranslateTransition transform = new TranslateTransition(Duration.seconds(0.8), this);
        transform.setToX(0);
        transform.play();
    }

    void hide(int translate) {
        TranslateTransition transform = new TranslateTransition(Duration.seconds(0.8), this);
        transform.setToX(translate);
        transform.setOnFinished(e -> setVisible(false));
        transform.play();
    }
}
