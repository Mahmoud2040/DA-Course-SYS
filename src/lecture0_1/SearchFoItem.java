package lecture0_1;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class SearchFoItem {
    static int[] numbers;
    static Scanner scanner;

    public static void thread1(){
        for (int i = 0 ;i<=100000 ; i++){
            Thread thread = new Thread(() -> {
                System.out.println("Running in platform thread");
                thread2();
            });
            thread.start();
    }

    }
    public static void thread2(){
        for (int i = 0 ;i<=100000 ; i++){
            Thread thread = new Thread(() -> {
                System.out.println("Running in platform thread");
            });
            thread.start();
        }

    }
    public static void main(String[] args) {

thread1();



   /*     initArrayValues();
        searchForNumber();*/
    }
    public static void printMainDiagonal(int[][] matrix) {
        System.out.println("Main Diagonal:");
        int n = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }


    private static void searchForNumber() {
        int input = getInputFromUser();
//binarySearch
        LocalTime beforeSearchB = LocalTime.now();
        boolean isFoundB = isFoundBinarySearch(input);
        LocalTime afterSearchB = LocalTime.now();

        System.out.println(input + " isFoundBinarySearch = " + isFoundB + " Time taken : " + Duration.between(beforeSearchB,afterSearchB));


//Simple search
        LocalTime beforeSearch = LocalTime.now();
        boolean isFound = isFoundSimpleSearch(input);
        LocalTime afterSearch = LocalTime.now();

        System.out.println(input + " isFoundSimpleSearch = " + isFound + " Time taken : " + Duration.between(beforeSearch,afterSearch));


    }

    private static int getInputFromUser() {
        scanner = new Scanner(System.in);
        System.out.println("please enter number between 1 and " +numbers.length );
        return scanner.nextInt();
    }

    private static void initArrayValues() {   
        numbers =  new int[10];
        System.out.println("insertion start ... ");
        for (int i = 0; i < numbers.length; i++) 
         numbers[i] = i + 1;
        System.out.println("insertion Ended");
    }
    public static boolean isFoundSimpleSearch(int number) {

        for (int i = 0 ; i < numbers.length ; i++)
        {
            if (numbers[i] == number)
            {
                System.out.println("found at : " + i );
                return true;
            }
        }

        return false;
    }

    public static boolean isFoundBinarySearch (int number){

        int low = 0 ;
        int high = numbers.length-1;
        int mid;

        while (low<=high){
        mid =  low+ (high-low) /2;
        if (number > numbers[mid])
            low = mid+1 ;
        else if (number < numbers[mid])
            high = mid-1;
        else {
            System.out.println("found at : " + mid );
            return true;
        }
        }

        return false;
    }
}
