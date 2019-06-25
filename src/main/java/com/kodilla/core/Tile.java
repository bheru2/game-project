package com.kodilla.core;

import com.kodilla.Graphics.GamePiece;
import com.kodilla.Graphics.Size;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private GamePiece gamePiece;

    public Tile(boolean isEven, int x, int y) {
        setWidth(Size.TILE_SIZE);
        setHeight(Size.TILE_SIZE);

        relocate(x * Size.TILE_SIZE, y * Size.TILE_SIZE);

        setFill(isEven ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }

    public boolean hasPiece() {
        return gamePiece != null;
    }

    public GamePiece getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }
}