package com.kodilla.core;

public class Board {

    private Tile[][] board;
    private PlayerPiece whitePlayer;
    private PlayerPiece blackPlayer;

    public Board(PlayerPiece whitePlayer, PlayerPiece blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = new  Tile[8][8];

        for (int row = 0; row<8;row++){
            for (int column = 0; column<8;column++){
            //    board[row][column] = new Tile(this,row,column);
            }
        }
    }
}
