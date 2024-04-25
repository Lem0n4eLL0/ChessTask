package Game.GameComponent.ChessBoard.ChessBoardComponent.Figure;

import Game.GameComponent.ChessBoard.Field;
import java.util.ArrayList;

public abstract class Figure {
    public abstract ArrayList<int[]> posibleMove(Field chessBoard, int positionX, int positionY);
}
