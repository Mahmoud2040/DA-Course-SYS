package lecture0;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class SearchFoItem {
    static int[] numbers;
    static Scanner scanner;

    public static void main(String[] args) {
        
        initArrayValues();
        searchForNumber();
    }

    private static void searchForNumber() {
        int input = getInputFromUser();
        boolean isFound = isFound(input);
        System.out.println(input + " isFound = " + isFound);
    }

    private static int getInputFromUser() {
        scanner = new Scanner(System.in);
        System.out.println("please enter number between 1 and 1000");
        return scanner.nextInt();
    }

    private static void initArrayValues() {   
        numbers =  new int[2_100_000_000];
        for (int i = 0; i < numbers.length; i++) 
         numbers[i] = i + 1;
    }
    public static boolean isFound(int number) {
              for (int i = 0 ; i<= numbers.length ; i++)
                  if(numbers[i]==number){
                      System.out.println("found at " + i );
                      return true;
                  }
        // TODO-lec0 write your algorithm here
        System.out.println("not found");
        return false;
    }
}
