package Game.GameComponent;

import Game.GameComponent.ChessBoard.ChessBoardComponent.Figure.Figure;

public class Player {

    private Figure figure;
    private int positionX;
    private int positionY;

    public Player(Figure figure, int positionX, int positionY) {
        this.figure = figure;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Player(Player player)
    {
        this.figure = player.getFigure();
        this.positionX = player.getPositionX();
        this.positionY = player.getPositionY();
    }

    public Player(Player player, int positionX, int positionY)
    {
        this.figure = player.getFigure();
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setFigure(Figure figure) { this.figure = figure; }

    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
    public int[] getPosition() { return new int[] {positionX, positionY}; }
    public Figure getFigure() { return figure; }


}
