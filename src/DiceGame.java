import java.util.Scanner;
import java.util.Random;
/*
* Dice Game -  week 1 challenge of Java Bootcamp
* Kim Levin
* 4/23/2020
***************************************************************************
* PSEUDOCODE
*
* Initialize game_total = 0
* Initialize dice_sum = 0
* Initialize dice1 = 0
* Initialize dice2 = 0
* boolean play = true
*
* REPEAT
*    Randomly generate a number from 1-6
*    Set dice1 value to randomly generated number
*    Randomly generate another number from 1-6
*    Set dice2 value to randomly generated number
*    
*    dice_sum = dice1 + dice2
*    IF dice_sum = 2
*    THEN
*        dice_sum = 25
*    ELSE
*        IF dice1 OR dice2 = 1
*        THEN
*            dice_sum = 0
*            Display a message to player that they lost a turn
*        ENDIF
*    ENDIF
*   
*    game_total = game_total + dice_sum
*    IF game_total >= 100
*    THEN
*        play = false
*        Display a message to the player that they scored at least 100
*    ELSE
*        Display value of dice1 and the value of dice2
*        Prompt player to play again(Y/N)
*        IF player repsonds with 'N'
*        THEN
*            play = false
*        ENDIF
*    ENDIF
* UNTIL(NOT(play))
* Display Summary message
***************************************************************************
*/
public class DiceGame {
   public static void main(String[] args) {
      int gameTotal = 0;
      int diceSum = 0;
      int dice1 = 0;
      int dice2 = 0;
      boolean play = true;
      Random rand = new Random();
      Scanner keyboard = new Scanner(System.in);
      String response;

      System.out.println("Welcome! Let's Play Roll Dice!");
      do {
         //Generate random numbers to mimic rolling dice
         dice1 = 1 + rand.nextInt(6);
         dice2 = 1 + rand.nextInt(6);
         diceSum = dice1 + dice2;
         if (diceSum == 2){
            diceSum = 25;
         } else if ( dice1 == 1 || dice2 == 1) {
            diceSum = 0;
            System.out.printf("Oh no, you rolled a 1! ");
            System.out.println("Sorry you lose a turn.");
         }
         gameTotal += diceSum;
         if (gameTotal >= 100) {
            play = false;
            System.out.printf("Score: %d\n",gameTotal);
            System.out.printf("Congratulations! You scored %d\n",gameTotal);
            System.out.println("A score of at least 100 is a win!!");
         } else {
            System.out.printf("Your rolls %d  %d\n",dice1,dice2);
            System.out.printf("Score: %d\n",gameTotal);
            System.out.print("Roll again? ");
            response = keyboard.nextLine();
            if (Character.toLowerCase(response.charAt(0)) == 'n') {
               play = false;
            }
         }
      } while (play);
      System.out.println("Thank you for playing!");
   }
}
