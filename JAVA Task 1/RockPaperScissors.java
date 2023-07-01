import javax.swing.JButton;
import javax.swing. JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors implements ActionListener {

    private JFrame frame;
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;

    public RockPaperScissors() {
        //create Frame
        frame = new JFrame("Rock Paper Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        //Create Button
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        //Create Label
        resultLabel = new JLabel();

        //Set Layout
        frame.setLayout(null);

        //Set button Bounds
        rockButton.setBounds(50, 30, 80, 30);
        paperButton.setBounds(150, 30, 80, 30);
        scissorsButton.setBounds(250, 30, 100, 30);

        //Set Label Bounds
        resultLabel.setBounds(50, 80, 600, 30);

        //Add event listeners to buttons
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        // Add Components to frame
        frame.add(rockButton);
        frame.add(paperButton);
        frame.add(scissorsButton);
        frame.add(resultLabel);

        // Display the frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicButton = (JButton) e.getSource();

        String playerChoice = clicButton.getText();
        String computerChoice =  generateComputerChoice();

        String resultText = determineWinner(playerChoice, computerChoice);

        resultLabel.setText("You chose: " + playerChoice + ", Computer choice: " + computerChoice + ". " + resultText);
    }

    private String generateComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if 
        ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) || 
        (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
        (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        new RockPaperScissors();
    }
}





