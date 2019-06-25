package com.kodilla.Graphics;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class GamePiece extends Pane {

    private PieceType type;
    private double mouseX, mouseY;
    private double xPosition, yPosition;

    public GamePiece(PieceType type, int x, int y) {
        this.type = type;
        move(x, y);
        AnchorPane board = new AnchorPane();
        System.out.println(type.toString());
        try (InputStream pieceImage = Files.newInputStream(Paths.get("src/main/resources" + type.path))) {
            ImageView piece = new ImageView(new Image(pieceImage));
            board.getChildren().addAll(piece);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getChildren().addAll(board);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
            setEffect(new DropShadow(40, Color.GREENYELLOW));
        });

        setOnMouseExited(e -> setEffect(null));
        setOnMouseDragged(e -> relocate(e.getSceneX() - mouseX + xPosition, e.getSceneY() - mouseY + yPosition));
    }

    public void move(int x, int y) {
        xPosition = x * Size.TILE_SIZE;
        yPosition = y * Size.TILE_SIZE;
        relocate(xPosition, yPosition);
    }

    public void abortMove() {
        relocate(xPosition, yPosition);
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public PieceType getType() {
        return type;
    }
}
