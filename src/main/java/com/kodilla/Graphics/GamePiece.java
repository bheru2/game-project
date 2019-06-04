package com.kodilla.Graphics;

public enum GamePiece {
    RED("/pieces/black.png"),
    WHITE("/pieces/white.png");

    String path;

    GamePiece(String path){
        this.path = path;
    }
}
