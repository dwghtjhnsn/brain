import static java.lang.Math.pow;
import static validio.ValidIO.getInt;
import static validio.ValidIO.isYes;

/**
 * The type Brain.
 */
public class Brain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    System.out.println("I am going to guess your number.\n");
    int questions = getInt("How many questions can I ask you? ");

    int choices = (int) pow(2, questions);
    System.out.println("Pick a number between 0 and " + (choices - 1) + ".");
    String binString = "";
    if (questions == 0) {
      System.out.println("Your number is 0");
    } else {
      int guess = choices / 2 - 1;
      int delta = choices / 4;

      boolean odd = isYes("Is your number odd? ");

      while (delta > 0) {
        if (isYes("Is your number greater than " + guess + "? ")) {
          guess += delta;
          binString += "y";
        } else {
          guess -= delta;
          binString += "n";
        }
        delta /= 2;
      }
      if (odd) {
        guess++;
        binString += "Y";
      } else {
        binString += "N";
      }

      System.out.println("Your number is " + guess);
      System.out.println("Question answers represent the binary code (odd is last): "+guess+ " = "+ binString);
    }
  }
}