import java.util.Scanner;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class HillCipherDecrypt {
  public static void main(String[] args) {
    // Read in encrypted text from cmd line
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    System.out.println("Reading input from console using Scanner in Java ");
    System.out.println("Please enter your input: ");
    String input = scanner.nextLine();

    int len = input.length();
    System.out.println();

    /*
     * 2 * 2 matrix try all keys to decrypt finding every matrix that adheres
     * gcd(26, (ad-bc)+26)=1
     *
     * split input into 2s invertible (meaning an inverse M^-1 exists) and the
     * determinant(M) must be relatively prime with 26
     */
    int[] key = new int[4];
    int[] keyInverse = new int[4];
    int determinant;

    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        for (int k = 0; k < 26; k++) {
          for (int l = 0; l < 26; l++) {
            key[0] = i;
            key[1] = j;
            key[2] = k;
            key[3] = l;
            determinant = (i * l) - (j * k);
            if (gcd(determinant, 26) == 1) {
              // keyInverse = calculateInverse(key, determinant);
              tryMatrix(key, input, len, determinant);
            }
          }
        }
      }
    }

  }

  public static void tryMatrix(int[] key, String input, int len, int determinant) {
    char char1;
    char char2;
    char a;
    char b;
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < len - 1; i = i + 2) {
      a = (char) (input.charAt(i) - 'a');
      b = (char) (input.charAt(i + 1) - 'a');
      char1 = (char) ((((a * key[0]) + (b * key[1])) % 26) + 'a');
      char2 = (char) ((((a * key[2]) + (b * key[3])) % 26) + 'a');
      str.append(char1);
      str.append(char2);
    }

    if (str.toString().contains("assignment")) {
      System.out.println(str.toString());
      System.out.println();
      for (int i = 0; i < 4; i++) {
        System.out.print(key[i] + " ");
      }
      System.out.println();
    }
  }

  public static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static int[] calculateInverse(int[] key, int determinant) {
    int a = key[0];
    int b = key[1];
    int c = key[2];
    int d = key[3];
    key[0] = (d * determinant) % 26;
    key[1] = (-b * determinant) % 26;
    key[2] = (-c * determinant) % 26;
    key[3] = (a * determinant) % 26;
    for (int i = 0; i < 4; i++) {
      if (key[i] < 0) {
        key[i] = -key[i];
      }
    }

    return key;
  }
}
