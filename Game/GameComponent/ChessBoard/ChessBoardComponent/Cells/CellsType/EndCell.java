package Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.Cell;

public class EndCell extends Cell {

    public EndCell(int positionX, int positionY)
    {
        super(positionX, positionY);
        symW = 'E';
    }
}
