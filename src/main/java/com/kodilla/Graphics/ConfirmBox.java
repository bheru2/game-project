package com.kodilla.Graphics;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    private static boolean answer;

    public static boolean display(String title, String message) {
        Stage confirmWindow = new Stage();
        confirmWindow.initModality(Modality.APPLICATION_MODAL);
        confirmWindow.setTitle(title);
        confirmWindow.setMaxWidth(430);
        confirmWindow.setMaxHeight(170);
        confirmWindow.setResizable(false);

        Label label = new Label(message);
        label.setStyle("-fx-font-size: 21; -fx-text-fill: white");
        label.setLayoutX(12);
        label.setLayoutY(10);

        GameButton yesButton = new GameButton("Yes", "underType.ttf");
        yesButton.setLayoutY(60);
        yesButton.setLayoutX(10);
        GameButton noButton = new GameButton("No", "underType.ttf");
        noButton.setLayoutY(60);
        noButton.setLayoutX(210);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(430, 120);
        anchorPane.getChildren().addAll(label,yesButton, noButton);
        Image backgroundImage = new Image("/backgrounds/background.black.jpg", 256, 256, false, true);
        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        anchorPane.setBackground(new Background(backgroundImage1));
        yesButton.setOnAction(e -> {
            answer = true;
            confirmWindow.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            confirmWindow.close();
        });

        Scene scene = new Scene(anchorPane);
        confirmWindow.setScene(scene);
        confirmWindow.showAndWait();

        return answer;
    }
}
