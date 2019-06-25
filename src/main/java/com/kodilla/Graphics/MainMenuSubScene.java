package com.kodilla.Graphics;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.*;
import javafx.util.Duration;


public class MainMenuSubScene extends SubScene {

    private boolean isHidden = true;

    public MainMenuSubScene() {
        super(new AnchorPane(), Size.WIDTH / 2, Size.HEIGHT);
        prefWidth(980);
        prefHeight(1024);
        setLayoutX(1990);
        setLayoutY(0);
    }

    public void moveSubScene() {
        TranslateTransition transform = new TranslateTransition();
        transform.setDuration(Duration.seconds(0.4));
        transform.setNode(this);
        if (isHidden) {
            transform.setToX(-980);
            isHidden = false;
        } else {
            transform.setToX(0);
            isHidden = true;
            transform.setOnFinished(e-> setVisible(false));
        }
        transform.play();
    }
}
