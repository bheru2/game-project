package com.kodilla.Graphics;

import com.kodilla.core.MoveResult;
import com.kodilla.core.Tile;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game {

    private static final int ROW = 8;
    private static final int COLUMN = 8;
    private Tile[][] board = new Tile[ROW][COLUMN];
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    private static Stage gameStage;
    private Stage menuStage;
    private boolean isRed;
    boolean isFirstPlayer = true;


    public Game(boolean isRed) {
        this.isRed = isRed;
        initializeStage();
    }

    private Parent createBoard() {
        Pane root = new Pane();
        root.setPrefSize(ROW * Size.TILE_SIZE, COLUMN * Size.TILE_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        for (int y = 0; y < COLUMN; y++) {
            for (int x = 0; x < ROW; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y);
                board[x][y] = tile;
                tileGroup.getChildren().add(tile);
                GamePiece gamePiece = null;
                if (!this.isRed) {
                    if (y <= 2 && (x + y) % 2 != 0) {
                        gamePiece = makePiece(PieceType.WHITE_P, x, y);
                    }

                    if (y >= 5 && (x + y) % 2 != 0) {
                        gamePiece = makePiece(PieceType.RED_C, x, y);
                    }
                } else {
                    if (y <= 2 && (x + y) % 2 != 0) {
                        gamePiece = makePiece(PieceType.RED_P, x, y);
                    }

                    if (y >= 5 && (x + y) % 2 != 0) {
                        gamePiece = makePiece(PieceType.WHITE_C, x, y);
                    }

                }

                if (gamePiece != null) {
                    tile.setGamePiece(gamePiece);
                    pieceGroup.getChildren().add(gamePiece);
                }
            }
        }
        return root;
    }

    private MoveResult move(GamePiece gamePiece, int newXPosition, int newYPosition) {
        if (board[newXPosition][newYPosition].hasPiece() || (newXPosition + newYPosition) % 2 == 0) {
            return new MoveResult(MoveType.NONE);
        }

        int x0 = toBoard(gamePiece.getXPosition());
        int y0 = toBoard(gamePiece.getYPosition());

        if (Math.abs(newXPosition - x0) == 1 && newYPosition - y0 == gamePiece.getType().direction) {
            return new MoveResult(MoveType.NORMAL);
        } else if (Math.abs(newXPosition - x0) == 2 && newYPosition - y0 == gamePiece.getType().direction * 2) {

            int x1 = x0 + (newXPosition - x0) / 2;
            int y1 = y0 + (newYPosition - y0) / 2;

            if (board[x1][y1].hasPiece() && board[x1][y1].getGamePiece().getType() != gamePiece.getType()) {
                return new MoveResult(MoveType.KILL, board[x1][y1].getGamePiece());
            }
        }

        return new MoveResult(MoveType.NONE);
    }

    private int toBoard(double pixel) {
        return (int) (pixel + Size.TILE_SIZE / 2) / Size.TILE_SIZE;
    }

    private GamePiece makePiece(PieceType type, int x, int y) {
        GamePiece gamePiece = new GamePiece(type, x, y);
        gamePiece.setOnMouseReleased(e -> {
            int newXPosition = toBoard(gamePiece.getLayoutX());
            int newYPosition = toBoard(gamePiece.getLayoutY());

            MoveResult result;

            if (newXPosition < 0 || newYPosition < 0 || newXPosition >= ROW || newYPosition >= COLUMN) {
                result = new MoveResult(MoveType.NONE);
            } else {
                if (!isFirstPlayer && gamePiece.getType() == PieceType.WHITE_P){
                    result = move(gamePiece, newXPosition, newYPosition);
                    isFirstPlayer=true;
                }else if(isFirstPlayer&&gamePiece.getType()!=PieceType.WHITE_P) {
                    result = move(gamePiece, newXPosition, newYPosition);
                    isFirstPlayer=false;
                }else{
                    result = new MoveResult(MoveType.NONE);
                }
            }

            int x0 = toBoard(gamePiece.getXPosition());
            int y0 = toBoard(gamePiece.getYPosition());

            switch (result.getType()) {
                case NONE:
                    gamePiece.abortMove();
                    break;
                case NORMAL:
                    gamePiece.move(newXPosition, newYPosition);
                    board[x0][y0].setGamePiece(null);
                    board[newXPosition][newYPosition].setGamePiece(gamePiece);
                    break;
                case KILL:
                    gamePiece.move(newXPosition, newYPosition);
                    board[x0][y0].setGamePiece(null);
                    board[newXPosition][newYPosition].setGamePiece(gamePiece);

                    GamePiece enemyGamePiece = result.getGamePiece();
                    board[toBoard(enemyGamePiece.getXPosition())][toBoard(enemyGamePiece.getYPosition())].setGamePiece(null);
                    pieceGroup.getChildren().remove(enemyGamePiece);
                    break;
            }
        });

        return gamePiece;
    }

    private void initializeStage() {
        Pane gamePane = (Pane) createBoard();
        Scene gameScene = new Scene(gamePane);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = ConfirmBox.display("Exit Game", "Do you want close game");
            if (answer) {
                gameStage.close();
                menuStage.show();
            }
        });
    }

    public void createNewGame(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();
    }
}
