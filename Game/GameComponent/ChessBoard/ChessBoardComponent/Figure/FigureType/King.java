package Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;
import Game.GameComponent.ChessBoard.Field;

import java.util.ArrayList;

public class King extends Figure {

    private static final char sym = 'K';

    public King() {}
    public King(King knight) {}

    @Override
    public ArrayList<int[]> posibleMove(Field chessBoard, int positionX, int positionY) {
        ArrayList<int[]> posibleMovepos = new ArrayList<int[]>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (positionX + i >= 0 && positionY + j >= 0 && positionX + i < chessBoard.getSizeX() && positionY + j < chessBoard.getSizeY())
                    posibleMovepos.add(new int[]{positionX + i, positionY + j});
            }
        }
        return posibleMovepos;
    }
}
