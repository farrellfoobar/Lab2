import java.util.Scanner;

class CrapsSimulation
{

    private CrapsGame game;
    private CrapsMetricsMonitor mon;
    private String playerName;
    //It would seem more appropriate to make balance and bet doubles, but since the
    //minumum bet is $1 and the game ends at $0 you wouldnt want someone suck at say $0.5
    private int balance;
    private int bet;
    private int winStreak;
    private int loseStreak;

    public CrapsSimulation()
    {
        mon = new CrapsMetricsMonitor();
        game = new CrapsGame( mon );
        playerName = "";
    }

    public void start()
    {
        System.out.println("Welcome to SimCraps! Enter your user name: ");
        Scanner in = new Scanner( System.in );
        playerName = in.nextLine();


        System.out.println("Enter the amount of money you will bring to the table: ");
        balance = Integer.parseInt( in.nextLine() );

        while( balance < 1  )
        {
            System.out.println("You must bring at lease $1 to the table: ");
            balance = Integer.parseInt( in.nextLine() );
        }

        System.out.println("Enter the bet amount between $1 and $" + balance +": ");
        bet = Integer.parseInt( in.nextLine() );

        while( balance > 0)
        {
            System.out.println( playerName + " 's balance: " + balance + "Playing a new game..." );

            getNewBet( in );

            if( CrapsGame.playGame() )
            {
                balance += bet;
            }
            else
            {
                balance -= bet;
            }
        }

    }

    private void getNewBet( Scanner in)
    {
        System.out.println("Enter the bet amount between $1 and $" + balance +": ");
        bet = Integer.parseInt( in.nextLine() )

        while( bet < 1 || bet > balance )
        {
            System.out.print( "Invalid bet! " );
            System.out.println("Enter the bet amount between $1 and $" + balance +": ");
            bet = Integer.parseInt( in.nextLine() )
        }
    }

}