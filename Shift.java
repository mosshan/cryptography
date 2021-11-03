import java.util.Scanner;
import java.io.InputStreamReader;

public class Shift {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    System.out.println("Reading input from console using Scanner in Java ");
    System.out.println("Please enter your input: ");
    String input = scanner.nextLine();

    int len = input.length();
    for (int j = 1; j < 27; j++) {
      for (int i = 0; i < len; i++) {
        char ch = input.charAt(i);
        ch = (char) (ch - j);
        if (ch < 'a') {
          ch = (char) (ch + 'z' - 'a' + 1);
        }
        System.out.print(ch);
      }
      System.out.println();
    }

  }
}