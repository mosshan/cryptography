import java.util.Scanner;
import java.io.InputStreamReader;

public class AffineDecrypt {
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    System.out.println("Reading input from console using Scanner in Java ");
    System.out.println("Please enter your input: ");
    String input = scanner.nextLine();

    int len = input.length();

    int[] aVals = new int[] {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};

    int flag;
    int a;
    int aInv = 0;

    for(int i = 0; i < 12; i++)
    {
      a = aVals[i];

      for(int j = 0; j < 26; j++)
      {
         flag = (a * j) % 26;

         if(flag == 1)
         {
            aInv = j;
            break;
         }
      }

      // find inverse of a value
      for(int b = 0; b < 26; b++)
      {
         for(int m = 0; m < len; m++)
         {
            char curr = (char)(((aInv * (input.charAt(m) - 'a' - b + 26)) % 26) + 'a');
            System.out.print(curr);
         }

         System.out.println();
      }
    }
  }
}
