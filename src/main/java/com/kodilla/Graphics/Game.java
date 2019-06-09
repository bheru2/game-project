package com.kodilla.Graphics;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game {

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;


    public Game(){
        initializeStage();
    }
    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.setOnCloseRequest(e->{
            e.consume();
            boolean answer = ConfirmBox.display("Exit Game","Do you want close game");
            if (answer) {
                gameStage.close();
                menuStage.show();
            }
        });
    }

    public void createNewGame(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();
    }
}
