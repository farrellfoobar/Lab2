class CrapsMetricsMonitor
{

    private int gamesPlayed;
    private int gamesWon;
    private int maxRolls;
    private int natCount;
    private int crapsCount;
    private int winStreak;
    private int loseStreak;
    private double maxBalance;
    private int gameOfMaxBal;

    public CrapsMetricsMonitor()
    {

    }

    public void printStatistics()
    {
        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Games won: " + gamesWon);
        System.out.println("Games lost: " + (gamesPlayed - gamesWon) );
        System.out.println("Maximum Rolls in a single game: " + maxRolls);
        System.out.println("Natural count: " + natCount);
        System.out.println("Craps count: " + crapsCount);
        System.out.println("Maximum Winning streak: " + winStreak);
        System.out.println("Maximum Loosing streak: " + loseStreak);
        System.out.println("Maximum balance: " + maxBalance + " durring game: " + gameOfMaxBal);
    }

    public void reset()
    {
        gamesPlayed = 0;
        gamesWon = 0;
        maxRolls = 0;
        natCount = 0;
        crapsCount = 0;
        winStreak = 0;
        loseStreak = 0;
        maxBalance = 0;
        gameOfMaxBal = 0;
    }



}