package Game.GameComponent.ChessBoard.ChessBoardComponent.Cells;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;

public class Cell {

    protected char symW = '.';
    private int positionX;
    private int positionY;

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Figure getModifyFigure() { return null; }
    public boolean isCell(Class<?> cell) { return getClass() == cell; }

    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public char getSymW() { return symW; }
}
