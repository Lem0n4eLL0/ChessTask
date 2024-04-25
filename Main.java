
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType.King;
import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.FigureType.Knight;
import Game.GameComponent.ChessBoard.Field;
import Game.Game;
import Game.Cheats.ShortestMoveCounter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = scanner.nextInt();
        scanner.nextLine();
        String[] field = new String[fieldSize];
        for(int i = 0; i < fieldSize; i++)
            field[i] = scanner.nextLine();
        Game game = new Game(new Knight(), new Field(field));

        game.printChessBoard();
        long start = System.nanoTime();
        ShortestMoveCounter shortestMoveCounter = new ShortestMoveCounter(game);
        System.out.println("Итог: " + shortestMoveCounter.shortestPoaibleWayCounter());
        System.out.println("Время: " + (System.nanoTime() - start));

    }
}

