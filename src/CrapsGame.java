/*
Patrick Farrell
51043027

This class simulates a single round of craps every time playGame is invoked on a CrapsGame object.
This class handles the rolling of dice and handling the various win/lose conditions.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class CrapsGame
{
    private CrapsMetricsMonitor gameMontor;
    private Random rand;

    private ArrayList<Integer> winningRolls = new ArrayList<Integer>( Arrays.asList( 7, 11) );
    private ArrayList<Integer> losingRolls = new ArrayList<Integer>( Arrays.asList( 2, 3, 12) );;
    private int losingNumber = 7;

    //basic constructor
    public CrapsGame( CrapsMetricsMonitor m)
    {
        gameMontor = m;
        rand = new Random();
    }

    //rolls dice to simulate a single game of craps
    public boolean playGame(double balance)
    {
        int roll = (rand.nextInt(6)+1 + rand.nextInt(6)+1);
        int targetRoll = 0;
        boolean out = false;

        System.out.println("Rolled a " +  roll );

        if( winningRolls.contains(roll) )
        {
            System.out.println("*****Natural! You win!*****");
            gameMontor.increment(true, 1, true, balance);
            out = true;
        }
        else if( losingRolls.contains(roll) )
        {
            System.out.println("*****Craps! You loose.*****");
            gameMontor.increment(false, 1, false, balance);
            out = false;
        }
        else
        {
            targetRoll = roll;
            int numRolls = 1;   //we aleady rolled once

            do
            {
                roll = (rand.nextInt(6)+1 + rand.nextInt(6)+1);
                System.out.println("Rolled a " +  roll );
                numRolls++;
            }
            while( roll != targetRoll && roll != losingNumber );

            if( roll == targetRoll)
            {
                System.out.println("*****Rolled the point! You win!*****");
                gameMontor.increment(true, numRolls, false, balance);
                out = true;
            }
            else
            {
                System.out.println("*****Crap out! You loose.*****");
                gameMontor.increment(false, numRolls, false, balance);
                out = false;
            }
        }

        return out;
    }

}