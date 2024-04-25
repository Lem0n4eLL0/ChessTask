package Game.Cheats;

import java.util.ArrayList;

public class FigureRouteOptimizer
{
    private int[] endSellCords;
    private ArrayList<int[]> posibleWays;

    public FigureRouteOptimizer(ArrayList<int[]> posibleWays, int[] endSellCords)
    {
        this.posibleWays = new ArrayList<>(posibleWays);
        this.endSellCords = new int[2];
        this.endSellCords[0] = endSellCords[0];
        this.endSellCords[1] = endSellCords[1];
    }

    public ArrayList<int[]> getOptimizedPosibleWays()
    {
        ArrayList<int[]> optimizedPosibleWays = new ArrayList<>();
        ArrayList<int[]> requiredPathsToCheck = new ArrayList<>();
        int deviation = Integer.MAX_VALUE, deviationX = 0, deviationY = 0;
        for(int[] i : posibleWays)
        {
            deviationX = Math.abs(endSellCords[0] - i[0]);
            deviationY = Math.abs(endSellCords[1] - i[1]);
            if(deviationX <= 2 && deviationY <= 2)
            {
                deviation = deviationX + deviationY;
                requiredPathsToCheck.add(i);
            }
            else if(deviationX + deviationY <= deviation)
            {
                if(deviationX + deviationY < deviation)
                    optimizedPosibleWays.clear();
                optimizedPosibleWays.add(i);
                deviation = deviationX + deviationY;
            }
        }
        optimizedPosibleWays.addAll(requiredPathsToCheck);
        return optimizedPosibleWays;
    }
}
