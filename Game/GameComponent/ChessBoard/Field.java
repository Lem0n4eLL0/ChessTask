package Game.GameComponent.ChessBoard;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.Cell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellCreater;

public class Field {

    private Cell[][] chessBoard;
    private int sizeX;
    private int sizeY;

    public Field(String[] chessBoard) {
        this.sizeX = chessBoard[0].length();
        this.sizeY = chessBoard.length;
        this.chessBoard = new Cell[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++)
                this.chessBoard[i][j] = CellCreater.getTypeCell(chessBoard[i].charAt(j), i, j);
    }

    public void printChessBoard(int playerPositionX, int playerPositionY) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i != playerPositionX || j != playerPositionY)
                    System.out.print(this.chessBoard[i][j].getSymW() + " ");
                else
                    System.out.print("P ");
            }
            System.out.println();
        }
    }

    public Cell getCell(int positionX, int positionY) {
        return chessBoard[positionX][positionY];
    }
    public Cell getCell(int[] position) { return chessBoard[position[0]][position[1]]; }
    public Cell getCell(Class<?> cell)
    {
        int[] cords = getCellCoords(cell);
        return chessBoard[cords[0]][cords[1]];
    }

    public int[] getCellCoords(Class<?> cell) {
        for (int i = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++)
                if (isCell(cell, i, j))
                    return new int[] {chessBoard[i][j].getPositionX(), chessBoard[i][j].getPositionY()};
        return new int[] {0, 0};
    }

    public boolean isCell(Class<?> cell, int positionX, int positionY)
    {
        return chessBoard[positionX][positionY].isCell(cell);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

}
