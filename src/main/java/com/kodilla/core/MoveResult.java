package com.kodilla.core;

import com.kodilla.Graphics.GamePiece;
import com.kodilla.Graphics.MoveType;

public class MoveResult {
    private MoveType type;

    public MoveType getType() {
        return type;
    }

    private GamePiece gamePiece;

    public GamePiece getGamePiece() {
        return gamePiece;
    }


    public MoveResult(MoveType type) {
        this(type, null);
    }

    public MoveResult(MoveType type, GamePiece gamePiece) {
        this.type = type;
        this.gamePiece = gamePiece;
    }
}
