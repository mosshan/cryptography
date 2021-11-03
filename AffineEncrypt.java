import java.util.Scanner;
import java.io.InputStreamReader;

public class AffineEncrypt {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    System.out.println("Reading input from console using Scanner in Java ");
    System.out.println("Please enter your text to encrypt:");
    String input = scanner.nextLine();
    System.out.println("Please enter encryption key a:");
    int a = Integer.parseInt(scanner.nextLine());
    System.out.println("Please enter encryption key b:");
    int b = Integer.parseInt(scanner.nextLine());

    int len = input.length();
    char curr;
    for (int i = 0; i < len; i++) {

      curr = (char) ((a * (input.charAt(i) - 'a') + b) % 26 + 'a');
      System.out.print(curr);
    }
    System.out.println();
  }
}
