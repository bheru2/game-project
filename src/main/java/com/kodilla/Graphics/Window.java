package com.kodilla.Graphics;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Window {

    private Pane root;
    private static Scene mainScene;
    static Stage window;
    private MainMenuSubScene player1SubScene;
    private Players2SubScene player2SubScene;
    private MainMenuSubScene newHelpSubScene;
    private MainMenuSubScene sceneToHide;
    private Menu menu;
    static Pane scene;

    public Window() {
        scene = createWindow();
        mainScene = new Scene(scene, Size.WIDTH, Size.HEIGHT);
        window = new Stage();
        window.setScene(mainScene);
        window.setResizable(false);
        window.setTitle("Game");
        mainScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                if (menu.isVisible()) {
                    menu.hide(-Size.WIDTH / 2);
                    if (sceneToHide != null) {
                        sceneToHide.moveSubScene();
                    }
                } else {
                    menu.show();
                }
            }
        });
    }

    public Stage getWindow() {
        return window;
    }

    private void showSubScene(MainMenuSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private Pane createWindow() {
        root = new Pane();
        root.setPrefSize(Size.WIDTH, Size.HEIGHT);

        try (InputStream backgroundImage = Files.newInputStream(Paths.get("src/main/resources/backgrounds/fancy.jpg"));
             InputStream logoImage = Files.newInputStream(Paths.get("src/main/resources/backgrounds/logo.png"))) {

            ImageView background = new ImageView(new Image(backgroundImage));
            background.setFitWidth(Size.WIDTH);
            background.setFitHeight(Size.HEIGHT);

            ImageView logo = new ImageView(new Image(logoImage));
            logo.setOnMouseEntered(event -> logo.setEffect(new DropShadow(50, Color.BLUEVIOLET)));
            logo.setOnMouseExited(event -> logo.setEffect(null));
            logo.setLayoutY(50);


            root.heightProperty().addListener((observable, oldValue, newValue) -> {
                double height = (double) newValue;
                background.setFitHeight(height);
            });

            root.widthProperty().addListener((observable, oldValue, newValue) -> {
                double width = (double) newValue;
                background.setFitWidth(width);
                logo.setLayoutX(width - 380);
            });

            root.getChildren().addAll(background, logo);
        } catch (IOException e) {
            System.out.println("Not able to load images");
        }

        MenuItem player1 = new MenuItem("1 PLAYER");
        player1.setOnMouseClicked(e -> {
            player1SubScene = new Player1SubScene("Please choose color of your piece");
            root.getChildren().add(player1SubScene);
            showSubScene(player1SubScene);
        });

        MenuItem player2 = new MenuItem("2 PLAYERS");
        player2.setOnMouseClicked(e -> {
            player2SubScene = new Players2SubScene("HElp");
            player2SubScene.setLayoutX(Size.WIDTH);
            root.getChildren().add(player2SubScene);
            player2SubScene.show();
        });

        MenuItem help = new MenuItem("HELP");
        help.setOnMouseClicked(e -> {
            newHelpSubScene = new HelpSubScene("rules.txt");
            root.getChildren().add(newHelpSubScene);
            showSubScene(newHelpSubScene);
        });

        MenuItem exit = new MenuItem("EXIT");
        exit.setOnMouseClicked(e -> {
            e.consume();
            CloseApplication.closeProgram(window);
        });


        menu = new Menu();
        menu.createMenu("CHECKERS",
                player1,
                player2,
                help,
                new MenuItem("SETTINGS"),
                exit);
        root.getChildren().add(menu);
        return root;
    }
}
