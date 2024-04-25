package Game.GameComponent.ChessBoard.ChessBoardComponent.Cells;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType.*;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType.*;

public class CellCreater {

    public static Cell getTypeCell(char sym, int positionX, int positionY) {
        if (sym == 'K') {
            return new ModifyCell(King.class, positionX, positionY);
        } else if (sym == 'S') {
            return new StartCell(positionX, positionY);
        } else if (sym == 'E') {
            return new EndCell(positionX, positionY);
        }else {
            return new Cell(positionX, positionY);
        }
    }
}
