package Game;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.Cell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType.ModifyCell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType.StartCell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;
import Game.GameComponent.ChessBoard.Field;
import Game.GameComponent.Player;

public class Game {
    private Player player;
    private Field chessBoard;

    public Game(Figure startFigure, Field chessBoard) {
        this.chessBoard = chessBoard;
        int[] sSellCoords = chessBoard.getCellCoords(StartCell.class);
        this.player = new Player(startFigure, sSellCoords[0], sSellCoords[1]);
    }

    public void printChessBoard() {
        chessBoard.printChessBoard(player.getPositionX(), player.getPositionY());
    }
    public Player getPlayer() { return player; }
    public Field getChessBoard() { return chessBoard; }
}
