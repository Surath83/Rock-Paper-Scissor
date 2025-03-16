import java.util.*;

public class Index{
    public static void finalResult(int result[]){
        int countU = 0;
        int countC = 0;
        int countT = 0;
        System.out.println();
        System.out.println("Final Results: ");  
        for(int i = 0; i < 3; i++){
            if(result[i] == 1){
                countU++;
                System.out.print(" O ");
            }else if(result[i] == 0){
                countC++;
                System.out.print(" X ");
            }else{
                countT++;
                System.out.print(" T ");
            }
        }
        System.out.println();
        if(countT == countU && countT == countC){
            System.out.println("The game is a tie!");
        }else if(countU > countC){
            System.out.println("You won the game!");
        }else if(countU < countC){
            System.out.println("You lost the game!");
        }else{
            System.out.println("The game is a tie!");
        }
        System.out.println();
    }
    public static void printResults(int computerChoice, int userChoice, int result){
        if(userChoice == 1){
            System.out.println("Your choice: Rock");
        }else if(userChoice == 2){
            System.out.println("Your choice: Paper");
        }else{
            System.out.println("Your choice: Scissors");
        }
        if(computerChoice == 1){
            System.out.println("Computer's choice: Rock");
        }else if(computerChoice == 2){
            System.out.println("Computer's choice: Paper");
        }else{
            System.out.println("Computer's choice: Scissors");
        }
        if(result == 1){
            System.out.println("You won this round.");
        }else if(result == 0){
            System.out.println("You lost this round.");
        }else{
            System.out.println("This round is a tie.");
        }
        System.out.println();
    }
    public static int roundResult(int userChoice, int computerChoice){
        if(userChoice == computerChoice){
            return 2;
        }else if(userChoice == 1 && computerChoice == 3){
            return 1;
        }else if(userChoice == 2 && computerChoice == 1){
            return 1;
        }else if(userChoice == 3 && computerChoice == 2){
            return 1;
        }else{
            return 0;
        }
    }
    public static void main (String Args []){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int times = 1;
        int result[] = new int[3];
        int userChoice, computerChoice;

        System.out.println("Welcome to the game of Rock, Paper, Scissors!");
        System.out.println("You have 3 chances to play the game.");
        System.out.println();

        while(times >= 1 && times <= 3){
            System.out.println("Enter 1 for Rock, 2 for Paper, 3 for Scissors.");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();
            if(userChoice >3 || userChoice < 1){
                System.out.println("Invalid choice. Please enter a valid choice.");
                continue;
            }
            computerChoice = rand.nextInt(3) + 1;
            result[times-1] = roundResult(userChoice, computerChoice);
            printResults(computerChoice, userChoice, result[times-1]);
            times++;
        }

        System.out.print("Calculating results");
        for (int j = 0; j < 3; j++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                System.out.println("Error in delay.");
            }
        }
        finalResult(result);
        System.out.println("wants to play again? Enter 1 for Yes, 2 for No.");
        int playAgain = sc.nextInt();
        if(playAgain == 1){
            main(Args);
        }else{
            System.out.println("Game Over!");
        }
        sc.close();

    }
}