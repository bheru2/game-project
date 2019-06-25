package com.kodilla.Graphics;

public enum PieceType {

    RED_C(-1, "/backgrounds/black1.png"),
    WHITE_P(1, "/backgrounds/red5.png"),
    RED_P(1, "/backgrounds/black1.png"),
    WHITE_C(-1, "/backgrounds/red5.png");

    final int direction;
    final String path;


    PieceType(int direction, String path) {
        this.direction = direction;
        this.path = path;
    }
}
