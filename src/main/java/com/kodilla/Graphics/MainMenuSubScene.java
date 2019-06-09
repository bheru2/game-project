package com.kodilla.Graphics;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class MainMenuSubScene extends SubScene {

    private boolean isHidden = true;

    public MainMenuSubScene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);
        BackgroundImage image = new BackgroundImage(new Image("/backgrounds/green_panel.png", 600, 400 ,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(image));
        setLayoutX(1034);
        setLayoutY(185);
     //   setStyle("-fx-opacity: 0.3");
    }

    public void moveSubScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));
        transition.setNode(this);
        if (isHidden) {
            transition.setToX(-650);
            isHidden = false;
        } else{
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    public AnchorPane getPane(){
        return (AnchorPane) this.getRoot();
    }
}
