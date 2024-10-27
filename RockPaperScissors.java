package RockPaperScissorsApp;

import java.util.Random;

public class RockPaperScissors {

    // Computer choices as list of strings.
    private static final String[] computerChoices = { "Rock", "Paper", "Scissors" };

    // Computer choice.
    private String computerChoice;

    // Used to initialize computerChoice from the list of strings.
    private Random random;

    // Computer's total number of rounds won this game.
    private int computerScore;

    // Player's total number of rounds won this game.
    private int playerScore;

    // Stores the winner of the round as a string.
    private String roundWinner;

    // Constructor
    public RockPaperScissors() {
        random = new Random();
    }

    // Returns the winner message of the round
    public String playRound(String playerChoice) {

        // Will store the winner of the game.
        String winnerMessage = "";

        // If computer wins.
        String computerWonMessage = "Computer Has Won...";

        // If Player Wins.
        String playerWonMessage = "Player Has Won!";

        // Generating computers choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        // Computer chooses rock
        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                roundWinner = "Player";
                winnerMessage = playerWonMessage;
                playerScore++;
            } else if (playerChoice.equals("Scissors")) {
                roundWinner = "Computer";
                winnerMessage = computerWonMessage;
                computerScore++;
            } else {
                winnerMessage = "Draw";
                roundWinner = "";
            }
        }
        // Computer chooses paper
        if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissors")) {
                roundWinner = "Player";
                winnerMessage = playerWonMessage;
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                roundWinner = "Computer";
                winnerMessage = computerWonMessage;
                computerScore++;
            } else {
                winnerMessage = "Draw";
                roundWinner = "";
            }
        }
        // Computer chooses Scissors
        if (computerChoice.equals("Scissors")) {
            if (playerChoice.equals("Rock")) {
                roundWinner = "Player";
                winnerMessage = playerWonMessage;
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                roundWinner = "Computer";
                winnerMessage = computerWonMessage;
                computerScore++;
            } else {
                roundWinner = "Draw";
                winnerMessage = "Draw";
            }
        }

        return winnerMessage;
    }

    // Getters and Setters
    public String getComputerChoice() {
        return computerChoice;
    }

    public String getRoundWinner() {
        return roundWinner;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void resetComputerScore() {
        computerScore = 0;
    }

    public void resetPlayerScore() {
        playerScore = 0;
    }

}
