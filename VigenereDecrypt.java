import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;

public class VigenereDecrypt {
  public static void main(String[] args) throws FileNotFoundException {
    // Read in encrypted text from cmd line
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    System.out.println("Reading input from console using Scanner in Java ");
    System.out.println("Please enter your input: ");
    String input = scanner.nextLine();

    int len = input.length();
    System.out.println();

    // Read in 1000 words into an array
    ArrayList<String> keys = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("keys.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        // process the line.
        keys.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder str = new StringBuilder();
    // Try each of 1000 words as a key
    for (String key : keys) {
      int kLen = key.length();
      // Run through input, adding key to

      for (int i = 0; i < len; i++) {
        int temp = ((input.charAt(i) - key.charAt(i % kLen)) % 26);
        if (temp < 0) {
          temp += 26;
        }
        char curr = (char) (temp + 'a');
        str.append(curr);
      }

      // If 'last' exists in decrypted text, print option out to the cmd line
      // This can be changed to look for any desired word
      String string = str.toString();
      if (string.contains("last")) {
        System.out.println(string);
        System.out.println();
      }

      str.setLength(0);

    }
  }
}
