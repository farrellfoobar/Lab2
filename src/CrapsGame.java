import java.util.Random;

class CrapsGame
{

    private CrapsMetricsMonitor gameMontor;
    private int balance;
    private Random rand;

    public CrapsGame( CrapsMetricsMonitor m)
    {
        gameMontor = m;
        rand = new Random();
    }

    public boolean playGame()
    {
        int roll = (rand.nextInt(6)+1 + rand.nextInt(6)+1);

        System.out.println("Rolled a " +  roll );
    }

}