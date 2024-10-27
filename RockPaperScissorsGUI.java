package RockPaperScissorsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RockPaperScissorsGUI extends JFrame implements ActionListener {

    // Computer buttons
    JButton computerRockButton, computerPaperButton, computerScissorsButton;

    // Player buttons
    JButton playerRockButton, playerPaperButton, playerScissorsButton;

    // Computer Labels
    JLabel computerChoiceLabel, playerChoiceLabel;

    // Player Labels
    JLabel computerScoreLabel, playerScoreLabel;

    // Result Details
    JPanel resultPanel;
    JLabel resultMessageLabel;
    JButton resetButton;

    // Finishline Panel
    JPanel finishLine;

    // Decorative background panel
    JPanel backgroundPanel;

    // Decorative borders
    JPanel backgroundBorderOuter;
    JPanel backgroundBorderInner;

    // Backend object.
    RockPaperScissors rockPaperScissors;

    // Frame constructor.
    public RockPaperScissorsGUI() {
        super("Rock Paper Scissors!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        rockPaperScissors = new RockPaperScissors();
        addStarterScreen();
        addGameComponents();
    }

    public void addStarterScreen() {
        // Creating the intro panel.
        JPanel introPanel = new JPanel();
        introPanel.setBounds(0, 0, getWidth(), getHeight());
        introPanel.setBackground(new Color(0, 0, 0, 150)); // Making background semi-transparent
        introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.Y_AXIS)); // Makes the layout vertically organized

        // "Play-game?" label
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        introPanel.add(welcomeLabel);

        // Adding padding to the panel
        introPanel.add(Box.createRigidArea(new Dimension(0, 110)));

        // Using html to center the intsructions correctly.
        JLabel instructionsLabel = new JLabel("<html><div style='width: 300px; text-align: center;'>" +
                "<b>Instructions:</b><br>" +
                "1. Choose Rock, Paper, or Scissors.<br>" +
                "2. Computer will make its choice.<br>" +
                "3. The winner will have their button <br>moved towards the finish line.<br>" +
                "4. First player to the <br>finish line wins the game!" +
                "<br><br>Finish line color <br>will reflect round winners." +
                "</div></html>");
        instructionsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        instructionsLabel.setForeground(Color.WHITE);
        instructionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.add(instructionsLabel);

        // Adding space between instructions and color guide.
        introPanel.add(Box.createRigidArea(new Dimension(0, 60)));

        // Color Guide
        JLabel colorGuideHeading = new JLabel("Finish Line Color Guide:");
        colorGuideHeading.setFont(new Font("Comic Sans", Font.ITALIC, 13));
        colorGuideHeading.setForeground(new Color(180, 180, 180));
        colorGuideHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.add(colorGuideHeading);

        JLabel computerWinsColorLabel = new JLabel("COMPUTER WINS ROUND!");
        computerWinsColorLabel.setFont(new Font("Comic Sans", Font.BOLD, 14));
        computerWinsColorLabel.setForeground(new Color(255, 0, 0));
        computerWinsColorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.add(computerWinsColorLabel);

        JLabel playerWinsLabel = new JLabel("PLAYER WINS ROUND!");
        playerWinsLabel.setFont(new Font("Comic Sans", Font.BOLD, 14));
        playerWinsLabel.setForeground(new Color(0, 0, 255));
        playerWinsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.add(playerWinsLabel);

        JLabel playersDrawLabel = new JLabel("DRAW!");
        playersDrawLabel.setFont(new Font("Comic Sans", Font.BOLD, 14));
        playersDrawLabel.setForeground(new Color(150, 150, 150));
        playersDrawLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.add(playersDrawLabel);

        // Adding space between color guide and click-to-start message.
        introPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Click-to-start message
        JLabel clickToStartLabel = new JLabel("Click to start!");
        clickToStartLabel.setFont(new Font("Dialog", Font.ITALIC, 14));
        clickToStartLabel.setForeground(Color.WHITE);
        clickToStartLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.add(clickToStartLabel);

        // Adding MouseListener to remove the panel when clicked
        introPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Removing panel
                getContentPane().remove(introPanel);

                // Correcting reset button once player starts the game.
                resetButton.setText("RESET GAME");
                resetButton.setBackground(new Color(255, 100, 100));

                revalidate();
                repaint();
            }
        });
        add(introPanel);
    }

    // Adding GUI
    public void addGameComponents() {

        // Computer's Choice Label
        computerChoiceLabel = new JLabel("CPU");
        computerChoiceLabel.setBounds(40, 50, 110, 50);
        computerChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoiceLabel.setFont(new Font("Dialog", Font.BOLD, 23));
        computerChoiceLabel.setForeground(new Color(0, 0, 0));
        computerChoiceLabel.setBorder(new EmptyBorder(1, 1, 1, 1));
        add(computerChoiceLabel);

        // Computer's Score Label
        computerScoreLabel = new JLabel("Rounds Won: 0");
        computerScoreLabel.setBounds(165, 50, 200, 50);
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 23));
        computerScoreLabel.setForeground(new Color(255, 0, 0));
        computerChoiceLabel.setBorder(new EmptyBorder(1, 1, 1, 1));
        computerScoreLabel.setVisible(true);
        add(computerScoreLabel);

        // Players's Choice Label
        playerChoiceLabel = new JLabel("Player");
        playerChoiceLabel.setBounds(40, 490, 110, 50);
        playerChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerChoiceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
        playerChoiceLabel.setForeground(new Color(150, 255, 150));
        playerChoiceLabel.setBorder(new EmptyBorder(1, 1, 1, 1));
        add(playerChoiceLabel);

        // Player's Score Label
        playerScoreLabel = new JLabel("Rounds Won: 0");
        playerScoreLabel.setBounds(165, 490, 200, 50);
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerScoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
        playerScoreLabel.setForeground(new Color(0, 0, 255));
        playerChoiceLabel.setBorder(new EmptyBorder(1, 1, 1, 1));
        playerScoreLabel.setVisible(true);
        add(playerScoreLabel);

        // Computer buttons - Rock Paper Scissors
        computerRockButton = new JButton("CPU Rock"); // <-- Rock
        computerRockButton.setForeground(Color.BLACK);
        computerRockButton.setBounds(25, 120, 105, 80);
        computerRockButton.setFont(new Font("Dialog", Font.BOLD, 14));
        computerRockButton.setBackground(new Color(255, 120, 120));
        computerRockButton.setBorder(new EmptyBorder(1, 1, 1, 1));
        add(computerRockButton);
        computerPaperButton = new JButton("CPU Paper"); // <-- Paper
        computerPaperButton.setForeground(Color.BLACK);
        computerPaperButton.setBounds(147, 120, 105, 80);
        computerPaperButton.setFont(new Font("Dialog", Font.BOLD, 14));
        computerPaperButton.setBackground(new Color(255, 120, 120));
        computerPaperButton.setBorder(new EmptyBorder(1, 1, 1, 1));
        add(computerPaperButton);
        computerScissorsButton = new JButton("CPU Scissors"); // <-- Scissors
        computerScissorsButton.setForeground(Color.BLACK);
        computerScissorsButton.setBounds(270, 120, 105, 80);
        computerScissorsButton.setFont(new Font("Dialog", Font.BOLD, 14));
        computerScissorsButton.setBackground(new Color(255, 120, 120));
        computerScissorsButton.setBorder(new EmptyBorder(1, 1, 1, 1));
        add(computerScissorsButton);

        // Player buttons - Rock Paper Scissors
        playerRockButton = new JButton("Rock"); // <-- Rock
        playerRockButton.setForeground(Color.WHITE);
        playerRockButton.setBounds(25, 400, 105, 80);
        playerRockButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        playerRockButton.addActionListener(this);
        playerRockButton.setForeground(new Color(150, 255, 150));
        playerRockButton.setBackground(new Color(120, 120, 255));
        add(playerRockButton);
        playerPaperButton = new JButton("Paper"); // <-- Paper
        playerPaperButton.setForeground(Color.WHITE);
        playerPaperButton.setBounds(147, 400, 105, 80);
        playerPaperButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        playerPaperButton.addActionListener(this);
        playerPaperButton.setForeground(new Color(150, 255, 150));
        playerPaperButton.setBackground(new Color(120, 120, 255));
        add(playerPaperButton);
        playerScissorsButton = new JButton("Scissors"); // <-- Scissors
        playerScissorsButton.setForeground(Color.WHITE);
        playerScissorsButton.setBounds(270, 400, 105, 80);
        playerScissorsButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        playerScissorsButton.addActionListener(this);
        playerScissorsButton.setForeground(new Color(150, 255, 150));
        playerScissorsButton.setBackground(new Color(120, 120, 255));
        add(playerScissorsButton);

        // Reset button
        resetButton = new JButton("START GAME");
        resetButton.setMargin(new Insets(1, 1, 1, 1));
        resetButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        resetButton.setBackground(new Color(100, 100, 255));
        resetButton.setForeground(new Color(255, 255, 255));
        resetButton.setBounds(0, 0, getWidth(), 40);
        resetButton.setBorder(new EmptyBorder(1, 1, 1, 1));
        resetButton.setVisible(true);
        resetButton.addActionListener(new ActionListener() {
            @Override // Method resets the game
            public void actionPerformed(ActionEvent e) {
                ResetGame();
            }
        });
        add(resetButton);

        // Creating Finishline
        finishLine = new JPanel();
        finishLine.setBounds(20, 300, 360, 10);
        finishLine.setBackground(new Color(150, 255, 150));
        add(finishLine);

        // Creating decorative background - Game's Table-top.
        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(199, 150, 236));
        backgroundPanel.setBounds(15, 35, getWidth() - 30, getHeight() - 80);
        backgroundPanel.isVisible();
        add(backgroundPanel);

        // Creating the inner border
        backgroundBorderInner = new JPanel();
        backgroundBorderInner.setBounds(10, 25, 380, 535);
        backgroundBorderInner.setBackground(new Color(255, 110, 110));
        backgroundBorderInner.setVisible(true);
        add(backgroundBorderInner);

        // Creating the outer border
        backgroundBorderOuter = new JPanel();
        backgroundBorderOuter.setBounds(0, 25, 400, 600);
        backgroundBorderOuter.setBackground(new Color(255, 90, 90));
        backgroundBorderOuter.setVisible(true);
        add(backgroundBorderOuter);

    }

    // Moves the winning button towards the finish line.
    public void MoveButton(String winner, Object playerSelectedButton, String computerSelectedButton) {
        JButton button = (JButton) playerSelectedButton;

        // If statement determines course of action base on who won.
        if (winner.equals("Player")) {
            // Moves player button that won up by 20 px.
            button.setBounds(button.getX(), button.getY() - 20, button.getWidth(), button.getHeight());

            // Checking to see if the game has been won.
            checkGameWinner(button);
        } else if (winner.equals("Computer")) { // Moves computer button that won. More work because
                                                // computerSelectedButton is a string not a JButton object.
            if (computerSelectedButton.equals("Rock")) {
                computerRockButton.setBounds(computerRockButton.getX(), computerRockButton.getY() + 20,
                        computerRockButton.getWidth(), computerRockButton.getHeight());
                checkGameWinner(computerRockButton); // Checking to see if the game has been won.
            } else if (computerSelectedButton.equals("Paper")) {
                computerPaperButton.setBounds(computerPaperButton.getX(), computerPaperButton.getY() + 20,
                        computerPaperButton.getWidth(), computerPaperButton.getHeight());
                checkGameWinner(computerPaperButton); // Checking to see if the game has been won.
            } else {
                computerScissorsButton.setBounds(computerScissorsButton.getX(), computerScissorsButton.getY() + 20,
                        computerScissorsButton.getWidth(), computerScissorsButton.getHeight());
                checkGameWinner(computerScissorsButton); // Checking to see if the game has been won.
            }
        }
    }

    // Resets game objects, labels, and scores.
    public void ResetGame() {

        // Resetting computer and player scores.
        rockPaperScissors.resetComputerScore();
        rockPaperScissors.resetPlayerScore();
        playerScoreLabel.setText("Rounds Won: 0");
        computerScoreLabel.setText("Rounds Won: 0");

        // Resetting computer and player labels.
        computerChoiceLabel.setText("CPU");
        playerChoiceLabel.setText("Player");

        // Computer buttons positioned above the center line
        computerRockButton.setBounds(25, 120, 105, 80);
        computerPaperButton.setBounds(147, 120, 105, 80);
        computerScissorsButton.setBounds(270, 120, 105, 80);

        // Player buttons positioned below the center line
        playerRockButton.setBounds(25, 400, 105, 80);
        playerPaperButton.setBounds(147, 400, 105, 80);
        playerScissorsButton.setBounds(270, 400, 105, 80);

        // Resetting finishline
        finishLine.setBackground(new Color(150, 255, 150));
    }

    // Method to check if the button that was just played is now on the finish line.
    public boolean isGameOver(JButton movedButton) {
        // First condition checks all player button, and second condition checks
        // computer buttons
        if (movedButton.getText().equals("Rock") || movedButton.getText().equals("Paper")
                || movedButton.getText().equals("Scissors")) {
            if (movedButton.getY() <= 300) {
                return true; // If button is on the finishline.
            }
        } else if (movedButton.getY() >= 220) {
            return true; // If button is on the finishline.
        }

        return false; // If button is NOT on the finsihline.
    }

    // Method to make JDialog to show game winner.
    public void checkGameWinner(JButton movedButton) {

        // If a player has won and the game is over, display dialog.
        if (isGameOver(movedButton)) {
            // Creating dialog.
            JDialog dialog = new JDialog(this, "Game Over!", true);

            // Setting the size of the dialog.
            dialog.setSize(200, 150);

            // Setting the location of the dialog so that its relative to the frame.
            dialog.setLocationRelativeTo(this);

            // Setting the background of the dialog to be blue.
            dialog.getContentPane().setBackground(Color.BLACK);

            // Creating a label to go on the dialog and display the game winner.
            JLabel displayGameWinnerLabel = new JLabel(rockPaperScissors.getRoundWinner() + " Has Won!");

            // Centering the label on the dialog.
            displayGameWinnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Setting the text color to gold.
            displayGameWinnerLabel.setForeground(new Color(255, 215, 0));

            // Setting the border of the label to reduce the margins and allow for the text
            // to take up more space within the label.
            displayGameWinnerLabel.setBorder(new EmptyBorder(1, 1, 1, 1));

            // Setting the font of the label.
            displayGameWinnerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

            // Adding the label to the dialog.
            dialog.add(displayGameWinnerLabel);

            // Creating a button to close the dialog.
            JButton closeButton = new JButton("Play Again!");

            // Adding an ActionListener to the closeButton so that it knows when its being
            // pressed.
            closeButton.addActionListener(e -> {
                ResetGame(); // The ActionEvent e calles ResetGame();
                dialog.dispose(); // Close the dialog
            });

            // Adding the close button to the bottom part of the dialog.
            dialog.getContentPane().add(closeButton, "South");

            // Making the dialog visible
            dialog.setVisible(true);

        }

    }

    // Method to match finish line to the winner of round.
    public void setFinishLineColor(String roundWinner) {
        // If Player won, set the finish line color to blue.
        if (roundWinner.equals("Computer")) {
            finishLine.setBackground(new Color(255, 0, 0));
            revalidate();
            repaint();
        } // If the Computer won, set the finish line to red.
        else if (roundWinner.equals("Player")) {
            finishLine.setBackground(new Color(0, 0, 255));
            revalidate();
            repaint();
        } // If its a draw reset the finish line color to its original value.
        else {
            finishLine.setBackground(new Color(150, 150, 150));
        }

    }

    // ActionListener Interface required method.
    @Override // Called when a button is clicked.
    public void actionPerformed(ActionEvent e) {
        // Setting player choice to the string that identifies the clicked button.
        // ("Rock", "Paper", "Scissors")
        String playerChoice = e.getActionCommand();

        // Playing the game and storing the winner of the round as a string.
        String roundWinnerMessage = rockPaperScissors.playRound(playerChoice);

        // Getting whatever the computer chose during the game.
        String computerChoice = rockPaperScissors.getComputerChoice();

        // Setting background color to match winner.
        setFinishLineColor(rockPaperScissors.getRoundWinner());

        // Moving the winning button.
        MoveButton(rockPaperScissors.getRoundWinner(), e.getSource(), rockPaperScissors.getComputerChoice());

        // Displaying Computer Choice
        computerChoiceLabel.setText(computerChoice);

        // Displaying Player Choice
        playerChoiceLabel.setText(playerChoice);

        // Updating Computer's Score Label
        computerScoreLabel.setText(" Rounds Won: " + rockPaperScissors.getComputerScore());

        // Updating Player's Score Label
        playerScoreLabel.setText("Rounds Won: " + rockPaperScissors.getPlayerScore());

        revalidate();
        repaint();
    }
}
