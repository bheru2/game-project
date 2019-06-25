package com.kodilla.core;

import com.kodilla.Graphics.GamePiece;

import java.util.ArrayList;
import java.util.List;

public class PlayerPiece {

    private List<GamePiece> pieceListOnBoard;
    private List<GamePiece> deadPieceList;

    public PlayerPiece() {
        this.pieceListOnBoard = new ArrayList<>();
        this.deadPieceList = new ArrayList<>();
    }

    public List<GamePiece> getPieceListOnBoard() {
        return pieceListOnBoard;
    }

    public void setPieceListOnBoard(List<GamePiece> pieceListOnBoard) {
        this.pieceListOnBoard = pieceListOnBoard;
    }

    public List<GamePiece> getDeadPieceList() {
        return deadPieceList;
    }

    public void setDeadPieceList(List<GamePiece> deadPieceList) {
        this.deadPieceList = deadPieceList;
    }
}
