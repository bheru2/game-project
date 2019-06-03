package com.kodilla.Graphics;

import javafx.stage.Stage;

public class CloseApplication {

    public static void closeProgram(Stage stage){
        Boolean answer = ConfirmBox.display("Exit Application", "Are you sure you want to exit application?");
        if (answer){
            stage.close();
        }
    }
}
