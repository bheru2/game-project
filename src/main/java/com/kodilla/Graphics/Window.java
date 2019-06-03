package com.kodilla.Graphics;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Window {

    private static final int HEIGHT = 768;
    private static final int WIDTH = 1024;
    private static final int MENU_BUTTONS_POS_X = 100;
    private static final int MENU_BUTTONS_POS_Y = 150;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage window;
    private List<GameButton> menuGameButtons = new ArrayList<>();
    private MainMenuSubScene newGameSubScene;
    private MainMenuSubScene helpSubScene;
    private MainMenuSubScene settingsSubScene;

    public Window() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        window = new Stage();
        window.setScene(mainScene);
        window.setResizable(false);
        createButtons();
        createBackground();
    }

    public Stage getWindow() {
        return window;
    }

    private void addMenuButton(GameButton gameButton) {
        gameButton.setLayoutX(MENU_BUTTONS_POS_X);
        gameButton.setLayoutY(MENU_BUTTONS_POS_Y + menuGameButtons.size() * 130);
        menuGameButtons.add(gameButton);
        mainPane.getChildren().add(gameButton);
    }

    private void createButtons() {
        GameButton newGame = new GameButton("New Game", "underType.ttf");
        addMenuButton(newGame);
        newGameSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(newGameSubScene);
        newGame.setOnAction(e -> newGameSubScene.moveSubScene());

        GameButton help = new GameButton("Help", "underType.ttf");
        addMenuButton(help);
        helpSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(helpSubScene);
        help.setOnAction(e-> helpSubScene.moveSubScene());

        GameButton settings = new GameButton("Settings", "underType.ttf");
        addMenuButton(settings);
        settingsSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(settingsSubScene);
        settings.setOnAction(e-> settingsSubScene.moveSubScene());

        GameButton exit = new GameButton("Exit", "underType.ttf");
        addMenuButton(exit);
        exit.setOnAction(e -> CloseApplication.closeProgram(window));
    }

    private void createBackground() {
        Image backgroundImage = new Image("/backgrounds/background.main.png", WIDTH + 10, HEIGHT + 10, false, true);
        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage1));
    }
}
