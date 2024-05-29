import java.util.Scanner;
import java.util.Random;

public class StonePaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"stone", "paper", "scissors"};
        
        int playerWins = 0;
        int computerWins = 0;
        
        while (playerWins < 2 && computerWins < 2 && (playerWins + computerWins) < 3) {
            System.out.println("Enter your choice (stone, paper, or scissors): ");
            String playerChoice = scanner.nextLine().toLowerCase();
            
            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice. Please enter stone, paper, or scissors.");
                continue;
            }
            
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);
            
            int result = determineWinner(playerChoice, computerChoice);
            
            if (result == 1) {
                playerWins++;
                System.out.println("You win this round!");
            } else if (result == 2) {
                computerWins++;
                System.out.println("Computer wins this round!");
            } else {
                System.out.println("This round is a tie!");
            }
            
            System.out.println("Current Score -> You: " + playerWins + " Computer: " + computerWins);
        }
        
        if (playerWins == 2) {
            System.out.println("Congratulations! You win the game!");
        } else if (computerWins == 2) {
            System.out.println("Computer wins the game! Better luck next time.");
        } else {
            System.out.println("The game is a tie!");
        }
        
        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("stone") || choice.equals("paper") || choice.equals("scissors");
    }

    private static int determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return 0; // tie
        } else if ((playerChoice.equals("stone") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("stone")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return 1; // player wins
        } else {
            return 2; // computer wins
        }
    }
}
