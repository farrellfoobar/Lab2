/*
Patrick Farrell
51043027

This class keeps track of various metrics about the series of games currently being played.
The increment method handles changing the metrics after a game is complete and the printStatistics method displays the data after the game is over.

 */

class CrapsMetricsMonitor
{

    private int gamesPlayed;
    private int gamesWon;
    private int maxRolls;
    private int natCount;
    private int crapsCount;
    private int bestWinStreak;  //I am tracking "streaks" as games won/lost after winning/loosing once, i.e. win win win = streak of 2, loose loose = streak of 1
    private int bestLoseStreak; //best? worst?
    private double maxBalance;
    private int gameOfMaxBal;
    private boolean wonLast;
    private int currentWinStreak;
    private int currentLoseStreak;

    //default constructor
    public CrapsMetricsMonitor()
    {

    }

    //prints all statistics for end screen
    public void printStatistics()
    {
        System.out.print("" +
                "*****************************\n" +
                "*** SIMULATION STATISTICS ***\n" +
                "*****************************\n"
        );

        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Games won: " + gamesWon);
        System.out.println("Games lost: " + (gamesPlayed - gamesWon) );
        System.out.println("Maximum Rolls in a single game: " + maxRolls);
        System.out.println("Natural count: " + natCount);
        System.out.println("Craps count: " + crapsCount);
        System.out.println("Maximum Winning streak: " + bestWinStreak);
        System.out.println("Maximum Losing streak: " + bestLoseStreak);
        System.out.println("Maximum balance: " + maxBalance + " during game: " + gameOfMaxBal);
    }

    //resets the counters
    public void reset()
    {
        gamesPlayed = 0;
        gamesWon = 0;
        maxRolls = 0;
        natCount = 0;
        crapsCount = 0;
        bestWinStreak = 0;
        bestLoseStreak = 0;
        maxBalance = 0;
        gameOfMaxBal = 0;
        wonLast = false;
    }

    //changes the statistics based upon a new game
    public void increment(boolean won, int maxRolls, boolean wasNatural, double ballance)
    {
        gamesPlayed++;

        if( maxRolls > this.maxRolls)
            this.maxRolls = maxRolls;

        if(wasNatural)
            natCount++;
        else if( maxRolls == 1 ) //there was only one roll and it wasnt natual, it was craps
            crapsCount++;

        if( wonLast && won )
        {
            currentWinStreak++;
            if (currentWinStreak > bestWinStreak)
                bestWinStreak = currentWinStreak;
        }
        else if( !wonLast && !won && gamesPlayed > 0)   //since wonLast starts false, we must make sure a first round lose isnt counted as streak
        {
            currentLoseStreak++;
            if (currentLoseStreak > bestLoseStreak)
                bestLoseStreak = currentLoseStreak;
        }

        if( ballance > maxBalance)
        {
            maxBalance = ballance;
            gameOfMaxBal = gamesPlayed+1; //games played counts from 0
        }

        if(won)
        {
            gamesWon++;
            wonLast = true;
            currentLoseStreak = 0;
        }
        else
        {
            currentWinStreak = 0;
            wonLast = false;
        }
    }


}