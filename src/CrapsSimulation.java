/*
Patrick Farrell
51043027

This class handles the user input, the placing of bets, and the ending of the game.
This class uses the CrapsGame class to actually simulate a game.

 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

class CrapsSimulation
{
    NumberFormat formatter = new DecimalFormat("#0.00");
    private CrapsGame game;
    private CrapsMetricsMonitor monitor;
    private String playerName;
    //It would seem more appropriate to make balance and bet doubles, but since the
    //minumum bet is $1 and the game ends at $0 you wouldnt want someone suck at say $0.5
    private double balance;
    private double bet;

    //basic constructor
    public CrapsSimulation()
    {
        monitor = new CrapsMetricsMonitor();
        game = new CrapsGame( monitor );
        playerName = "";
    }

    //handles the getting of the user's name and placing of bets
    public void start()
    {
        System.out.println("Welcome to SimCraps! Enter your user name: ");
        Scanner in = new Scanner( System.in );
        playerName = in.nextLine();

        System.out.println("Enter the amount of money you will bring to the table: ");
        balance = Double.parseDouble( in.nextLine() );

        while( balance < 1  )
        {
            System.out.println("You must bring at lease $1 to the table: ");
            balance = Double.parseDouble( in.nextLine() );
        }

        while( balance >= 1) //I think this is how the game wants a balance < 1 to be handled
        {
            System.out.println( playerName + " 's balance: " + formatter.format(balance) + " Playing a new game..." );

            getNewBet( in );

            if( game.playGame(balance) )
            {
                balance += bet;
            }
            else
            {
                balance -= bet;
            }
        }

        System.out.println( playerName + " 's balance: " + formatter.format(balance) );
        //game is over
        monitor.printStatistics();

    }

    //simply a convenience method to make start() somewhat more concise
    private void getNewBet( Scanner in)
    {
        System.out.println("Enter the bet amount between $1 and $" + formatter.format(balance) +": ");
        try {
            bet = Double.parseDouble(in.nextLine());
        }catch (java.lang.NumberFormatException e)
        {
            bet = balance+1; // bet = 0 would need to be changed to allow $0 bets
        };

        while( bet < 1 || bet > balance )
        {
            System.out.print( "Invalid bet! " );
            System.out.println("Enter the bet amount between $1 and $" + formatter.format(balance) +": ");
            bet = Double.parseDouble( in.nextLine() );
        }
    }

}