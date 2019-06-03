package com.kodilla;

import com.kodilla.Graphics.CloseApplication;
import com.kodilla.Graphics.Window;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Window window = new Window();
        primaryStage = window.getWindow();
        Stage finalPrimaryStage = primaryStage;
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            CloseApplication.closeProgram(finalPrimaryStage);
        });
        primaryStage.show();

    }
}
