package randomNumberGameconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class randomNumbergui extends JFrame {
    private JTextField textField;
    private JLabel infoLabel;
    private JLabel attemptLabel;
    private int random;
    private int attemptsLeft;

    public randomNumbergui() {
        setTitle("Random Number Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        random = (int) (Math.random() * 100) + 1;
        attemptsLeft = 10;

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        panel.setBackground(new Color(230, 240, 250));

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);

        infoLabel = new JLabel("Guess the Number between 1 and 100");
        infoLabel.setFont(labelFont);
        panel.add(infoLabel);

        textField = new JTextField();
        panel.add(textField);

        JButton guessButton = new JButton("Guess");
        guessButton.setFont(buttonFont);
        guessButton.setBackground(new Color(70, 130, 180));
        guessButton.setForeground(Color.WHITE);
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        panel.add(guessButton);

        // Create and style the attempt label
        attemptLabel = new JLabel("Attempts left: " + attemptsLeft);
        attemptLabel.setFont(labelFont);
        panel.add(attemptLabel);

        add(panel);
    }

    private void checkGuess() {
        if (attemptsLeft > 0) {
            try {
                int guess = Integer.parseInt(textField.getText());
                if (guess == random) {
                    JOptionPane.showMessageDialog(this, "Congratulations! You guessed correctly! The number was " + random);
                    resetGame();
                } else {
                    attemptsLeft--;
                    attemptLabel.setText("Attempts left: " + attemptsLeft);
                    if (guess > random) {
                        JOptionPane.showMessageDialog(this, "The number you guessed is too High");
                    } else {
                        JOptionPane.showMessageDialog(this, "The number you guessed is too Low");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, your attempts are finished. The correct answer was " + random);
            resetGame();
        }
    }

    private void resetGame() {
        random = (int) (Math.random() * 100) + 1;
        attemptsLeft = 5;
        textField.setText("");
        infoLabel.setText("Guess the Number between 1 and 100");
        attemptLabel.setText("Attempts left: " + attemptsLeft);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new randomNumbergui().setVisible(true);
            }
        });
    }
}
