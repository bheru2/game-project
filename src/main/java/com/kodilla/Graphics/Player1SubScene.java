package com.kodilla.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Player1SubScene extends MainMenuSubScene {
    private boolean red = false;
    private boolean white = false;

    public Player1SubScene(String text1) {
        super();
        Rectangle background = new Rectangle(Size.WIDTH/2, Size.HEIGHT);
        background.setOpacity(0.2);
        DropShadow shadow = new DropShadow(15, 5, 0, Color.BLACK);
        shadow.setSpread(0.8);
        background.setEffect(shadow);
        AnchorPane root = (AnchorPane) this.getRoot();
        Text text = new Text(text1);
        text.setFont(Font.font(39));
        text.setFill(Color.WHITE);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(60, 0, 0, 0));
        vBox.setLayoutX(150);
        vBox.setLayoutY(150);
        vBox.getChildren().addAll(text);
        HBox hBox = new HBox();
        hBox.setMinWidth(500);
        hBox.setLayoutX(250);
        hBox.setLayoutY(250);
        hBox.setPadding(new Insets(100));
        VBox vBox1 = new VBox();
        vBox1.setLayoutY(550);
        vBox1.setLayoutX(450);
        try (InputStream redPiece = Files.newInputStream(Paths.get("src/main/resources/backgrounds/red5.png"));
             InputStream blackPiece = Files.newInputStream(Paths.get("src/main/resources/backgrounds/black1.png"));
             InputStream newGameButton = Files.newInputStream(Paths.get("src/main/resources/buttons/NewGame.png"))) {
            ImageView red = new ImageView(new Image(redPiece));
            ImageView black = new ImageView(new Image(blackPiece));
            ImageView button = new ImageView(new Image(newGameButton));
            red.setOnMouseClicked(e -> {
                if (!this.red) {
                    red.setEffect(new DropShadow(40, Color.GREENYELLOW));
                    black.setEffect(null);
                    this.red = true;
                    button.setEffect(new DropShadow(40, Color.GREENYELLOW));
                    white = false;
                }
            });

            black.setOnMouseClicked(e -> {
                if (!white) {
                    black.setEffect(new DropShadow(40, Color.GREENYELLOW));
                    red.setEffect(null);
                    button.setEffect(new DropShadow(40, Color.GREENYELLOW));
                    white = true;
                    this.red = false;
                }
            });
            button.setOnMouseClicked(e -> {
                if (this.red || white) {
                    Game game = new Game(this.red);
                    game.createNewGame(Window.window);
                }
            });
            hBox.getChildren().addAll(black, red);
            vBox1.getChildren().addAll(button);
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().addAll(background, vBox, hBox, vBox1);
    }
}
