package Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;
import Game.GameComponent.ChessBoard.Field;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class Knight extends Figure {

    private static final char sym = 'k';
    public Knight() {}
    public Knight(Knight knight) {}

    @Override
    public ArrayList<int[]> posibleMove(Field chessBoard, int positionX, int positionY) {
        ArrayList<int[]> posibleMovePosition = new ArrayList<int[]>();
        int posibleX = 0;
        int posibleY = 0;
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                for (int o = 1; o <= 2; o++) {
                    posibleX = (int) (pow(-1, j) * i);
                    posibleY = (int) (pow(-1, o) * (3 - i));
                    if ((positionX + posibleX >= 0) &&
                            (positionX + posibleX < chessBoard.getSizeX()) &&
                            (positionY + posibleY >= 0) &&
                            ((positionY + posibleY) < chessBoard.getSizeY())) {
                        posibleMovePosition.add(new int[]{positionX + posibleX, positionY + posibleY});
                    }
                }
            }
        }
        return posibleMovePosition;
    }
}
