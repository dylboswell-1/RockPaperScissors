package RockPaperScissorsApp;

import javax.swing.*;

public class App{

    public static void main(String[] args) {

        // Allows our GUI to be created and updated in a thread-safe manner.
        // Helps the GUI run better.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                // Try and catch statement to change buttons colors, from chat GPT
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                SwingUtilities.invokeLater(() -> {
                    new RockPaperScissorsGUI().setVisible(true);
                });
                // Instantiating a RockPaperScissorGUI object.
            }
            
        });
    }

}