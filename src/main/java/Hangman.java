import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      char diffLevel;
      String secretWord;
      String userGuess;
      String userSpaces;
      String userSolve;
      int spaces;
      String userGuessedWord;
      int guessesAllowed;
      int[] userPositions;
      boolean isGuess = false;

while (true) {
      while(true) {
        System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
        diffLevel = sc.next().charAt(0);
        if (diffLevel == 'e') {
          secretWord = "";
          spaces = 4;
          guessesAllowed = 15;
          break;
        } else if (diffLevel == 'i') {
          secretWord = "";
          spaces = 3;
          guessesAllowed = 12;
          break;
        } else if (diffLevel == 'h') {
          secretWord = "";
          spaces = 2;
          guessesAllowed = 10;
          break;
        } else {
          System.out.println("Invalid difficulty. Try again...");
        }
      }


      secretWord = "secret";
      char[] hiddenWord = new char[secretWord.length()];
      for (int index = 0; index < secretWord.length(); index++) {
        hiddenWord[index] = '-';
      }
      System.out.print("The word is ");
      for (int j = 0; j < hiddenWord.length; j++) {
          System.out.print(hiddenWord[j]);
      }
      while(guessesAllowed > 0) {
      while (true) {
        try {
          System.out.print("\nPlease enter the letter you want to guess: ");
          Scanner scan2 = new Scanner(System.in);
          userGuess = scan2.nextLine();
          System.out.println(userGuess);
          if (userGuess.toLowerCase().equals("solve")) {
            System.out.print("\nPlease solve the word: ");
            userSolve = sc.next();
            if (userSolve.toLowerCase().equals(secretWord)) {
              System.out.println("You win!");
              System.out.println("You have guessed the word! Congratulations!");
              System.out.print("\nWould you like to play again? Yes(y) or No(n)");
              String continuePlay;
              continuePlay = sc.next();
              if (continuePlay.toLowerCase().charAt(0) == 'y') {
                  guessesAllowed = 0;
                break;
              }
             else if (continuePlay.toLowerCase().charAt(0) == 'n') {
              System.exit(0);
            } else {
              System.out.println("\nInvalid Input.");
              break;
            }
            } else {
                System.out.println("That is not the secret word.");
                guessesAllowed -= 1;
                break;
            }
          }
          if (!Character.isLetter(userGuess.charAt(0))) {
            System.out.println("\nInvalid input. Try againn");
            break;
          }
          System.out.print("\nPlease enter the spaces you want to check (seperated by spaces): ");
          Scanner scan = new Scanner(System.in);
          userSpaces = scan.nextLine();
        } catch (Exception e) {
          System.out.println("Error - Please enter a valid input");
          break;
        }
        if (!validPosition(userSpaces, spaces)) {
          System.out.println("Your input is not valid. Try again");
          break;
        }
        userPositions = getPosition(userSpaces, spaces);
        for (int i = 0; i < secretWord.length(); i++) {
          for (int j = 0; j < userPositions.length; j++) {
            if (userGuess.toLowerCase().charAt(0) == secretWord.charAt(userPositions[j])) {
              hiddenWord[userPositions[j]] = secretWord.charAt(userPositions[j]);
              isGuess = true;
            }
          }
        }
        if (isGuess) {
          System.out.println("Your guess is in the word!");
          isGuess = false;
          System.out.println(hiddenWord);
          System.out.println(secretWord);
          if (secretWord.equals(new String(hiddenWord))) {
              System.out.println("You win!!!!!");
              System.exit(0);
          }
          System.out.println("The updated word is: " + hiddenWord);
        } else {
          System.out.println("Your letter was not found in the space you provided.");
          guessesAllowed -= 1;
          break;
        }


      }
      if (guessesAllowed != 0) {
        System.out.println("Guesses Remaining: " + guessesAllowed);
      }
}
}




    }


    public static boolean isInt(String str) {
        try {
          int result = Integer.parseInt(str);
          return true;
        } catch (NumberFormatException e) {
          return false;
        }
    }


    public static boolean validPosition(String positionStr, int spaceAllowed) {
      String[] arr = new String[spaceAllowed];
      arr = positionStr.split("\\s+");
      System.out.println(Arrays.toString(arr));
      System.out.println(arr.length + " " + spaceAllowed);
      if (arr.length != spaceAllowed) {
        return false;
      }
      for (int j = 0; j < arr.length; j++) {
        if (!isInt(arr[j])) {
          return false;
        }
      }
      return true;
    }

    public static int[] getPosition(String positionStr, int spaceAllowed) {
        String[] arr = positionStr.split("\\s+");
        int[] intArr = new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
          intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }


}
