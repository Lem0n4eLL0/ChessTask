package Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.Cell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType.King;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType.Knight;

public class ModifyCell extends Cell {

    private final Class<?> modifyClass;

    public ModifyCell(Class<?> modifyClass, int positionX, int positionY) {
        super(positionX, positionY);
        this.modifyClass = modifyClass;
        symW = 'K';
    }

    @Override
    public Figure getModifyFigure()
    {
        try {
            return (Figure) modifyClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
