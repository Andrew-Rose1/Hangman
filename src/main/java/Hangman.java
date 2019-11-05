import java.util.*;





/* Methods are all done.
  Just need to finish the logic in main method

  1) Fix the hidden word output in main method
  2) Check if user guess is at any of array locations in secret Word
  3) Guessremaining

*/




// main class
public class Hangman {
    // private static final boolean testingMode = true;

    // you will take care of user interaction under main method
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      char diffLevel;
      String secretWord;
      String userGuessedWord;
      int secretLength;
      int guessesAllowed;


      while(true) {
        System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
        diffLevel = sc.next().charAt(0);
        if (diffLevel == 'e') {
          secretWord = "";
          whiteSpaces = 4;
          guessesAllowed = 15;
          break;
        } else if (diffLevel == 'i') {
          secretWord = "";
          whiteSpaces = 3;
          guessesAllowed = 12;
          break;
        } else if (diffLevel == 'h') {
          secretWord = "";
          whiteSpaces = 2;
          guessesAllowed = 10;
          break;
        } else {
          System.out.println("Invalid difficulty. Try again...");
        }
      }
      while (true) {
        secretWord = "Secret";
        for (int j = 0; j > secretWord.length(); j++) {
          secretLength =+ "-";
        }
        System.out.println(secretLength);
        System.out.println("Please enter the letter you want to guess: ")
        if (!Character.isLetter(userGuess.charAt(0))) {
          System.out.println("Invalid input. Try again")
        } else {
          break;
        }
      }




    }




    // this method validate if a string can be parsed to an integer
    // this method takes 1 parameter and returns a boolean:
    //      str - a string
    // when str can be parsed to an integer without any needs of modification
    // return true; otherwise false
    public static boolean isInt(String str) {
        try {
          int result = Integer.parseInt(str);
          return true;
        } catch (NumberFormatException e) {
          System.out.println("Error");
          return false;
        }
    }


    // this method validates the positions given by users as a string
    // this method takes 2 parameters and returns a boolean:
    //      positionStr - a string given by a user
    //                      representing "spaces the user want to check";
    //      spaceAllowed - an integer representing the allowed spaces at the current
    //                      difficulty level
    // when the given positionStr can be split and parsed to exactly the number of
    // spaceAllowed integers, return true; otherwise false
    // NOTE: The only allowed delimiter for positionStr is white space
    // e.g.1, positionStr: "0 1 5 7"
    //        spaceAllowed: 3
    //        return: false
    // e.g.2, positionStr: "0 1 5 a "
    //        spaceAllowed: 4
    //        return: false
    // e.g.3, positionStr: "0 100 4 21 "
    //        spaceAllowed: 4
    //        return: true
    // e.g.4, positionStr: "0, 100, 4, 21 "
    //        spaceAllowed: 4
    //        return: false
    public static boolean validPosition(String positionStr, int spaceAllowed) {
      String[] arr = new String[spaceAllowed];
      arr = positionStr.split("\\s+");
      if (arr.length > spaceAllowed) {
        return false;
      }
      for (int j = 0; j < arr.length; j++) {
        if (!isInt(arr[j])) {
          return false;
        }
      }
      return true;
      //System.out.println(Arrays.toString(arr));
      //int firstOne = Integer.parseInt(arr[0]);
      //System.out.println(firstOne);
    }


    // this method converts the validated positions from a string to an int array
    // this method takes 2 parameters and returns an int array
    //      positionStr - a string representing validated positions provided by a user
    //      spaceAllowed - an integer representing the allowed spaces at the current
    //                      difficulty level
    // NOTE 1: You should assume the validity of positionStr -
    //      only composed of integers and white spaces
    //      the numbers of integers are the same as spaceAllowed
    // NOTE 2: White spaces serve as delimiters
    // e.g.1, positionStr: "0 100 4 21 "
    //        spaceAllowed: 4
    //        return: {0, 100, 4, 21}
    // e.g.2, positionStr: "0 1          3      4    "
    //        spaceAllowed: 4
    //        return: {0, 1, 3, 4}
    public static int[] getPosition(String positionStr, int spaceAllowed) {
        String[] arr = positionStr.split("\\s+");
        int[] intArr = new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
          intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }

    // you are welcome to add more methods if you want
}
