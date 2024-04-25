package Game.Cheats;
import Game.Game;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType.EndCell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.CellsType.StartCell;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType.Knight;
import Game.GameComponent.ChessBoard.Field;
import Game.GameComponent.Player;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Cells.Cell;

import java.util.ArrayList;

public class ShortestMoveCounter {

    private int currentDepth = 1;
    private int maxDepth = Integer.MAX_VALUE;

    private Game game;
    private Player player;
    private Field chessBoard;
    private int[] endCellCords;

    public ShortestMoveCounter(Game game)
    {
        this.game = game;
        this.player = game.getPlayer();
        this.chessBoard = game.getChessBoard();
        this.endCellCords = chessBoard.getCellCoords(EndCell.class);
    }

    public int shortestPoaibleWayCounter()
    {
        return counter(game.getPlayer(), new ArrayList<>(), player.getPosition());
    }

    private int counter(Player player, ArrayList<int[]> moveMemory, int[] cords)
    {
        int counterM = Integer.MAX_VALUE;
        boolean deadlock = true;
        ArrayList<int[]> tempMoveMemory = new ArrayList<>(moveMemory);
        tempMoveMemory.add(player.getPosition());
        for(int[] posibleWayCoords : new FigureRouteOptimizer(player.getFigure().posibleMove(chessBoard ,cords[0], cords[1]), endCellCords).getOptimizedPosibleWays())
        {
            if (checkValid(moveMemory, posibleWayCoords))
            {
                deadlock = false;
                if (currentDepth >= maxDepth)
                    break;
                if (endCellCords[0] == posibleWayCoords[0] && endCellCords[1] == posibleWayCoords[1])
                {
                    maxDepth = currentDepth--;
                    return 1;
                }
                Player tempPlayer = chessBoard.getCell(posibleWayCoords).getModifyFigure() != null ?
                        new Player(chessBoard.getCell(posibleWayCoords).getModifyFigure(), posibleWayCoords[0], posibleWayCoords[1]) :
                        new Player(player, posibleWayCoords[0], posibleWayCoords[1]);
                currentDepth++;
                int temp = counter(tempPlayer, tempMoveMemory, posibleWayCoords);
                counterM = temp < counterM && temp != -1 ? temp : counterM;
            }
        }
        currentDepth--;
        return deadlock || counterM == Integer.MAX_VALUE?-1:counterM+1;
    }

    private boolean checkValid(ArrayList<int[]> moveMemory, int[] cords)
    {
        for(int[] checkMemory : moveMemory)
            if(cords[0] == checkMemory[0] && cords[1] == checkMemory[1])
                return false;
        return true;
    }
}
