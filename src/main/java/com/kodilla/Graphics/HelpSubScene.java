package com.kodilla.Graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class HelpSubScene extends MainMenuSubScene {

    public HelpSubScene(String path) {
        super();
        Rectangle background = new Rectangle(980, 1024);
        background.setOpacity(0.2);
        DropShadow shadow = new DropShadow(15, 5, 0, Color.BLACK);
        shadow.setSpread(0.8);
        background.setEffect(shadow);
        AnchorPane root = (AnchorPane) this.getRoot();
        Text text;
        try (InputStream redPiece = Files.newInputStream(Paths.get("src/main/resources/text/"+ path))){
            BufferedReader buffer = new BufferedReader(new InputStreamReader(redPiece));
            String line = buffer.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buffer.readLine();
            }
            text = new Text(sb.toString());
        } catch (IOException e) {
            text = new Text("");
        }
        text.setFont(Font.font(19));
        text.setWrappingWidth(900);
        text.setFill(Color.WHITESMOKE);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(60, 60, 0, 0));
        vBox.getChildren().addAll(text);
        root.getChildren().addAll(background,vBox);
    }
}
