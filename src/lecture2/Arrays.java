package lecture2;

import java.util.ArrayList;

public class Arrays {
  // TODO
  //  Sum of elements , (DONE)
  //  Max/min value ,
  //  Reversing an array , without using any extra arrays
  //  Copying an array

    //TODO 2D
    // Sum of all elements ,
    // Row-wise/column-wise printing ,
    // Diagonal traversal [3][3],
    // Searching for an element
    public static void  main (String [] args) {

        towDArray();

        //salarySum();



    }

    private static void salarySum() {
        double [] salaries = {2000 , 13000 , 26000 , 60000 , 75000};
        double salariesSum = 0.0 ;

        for ( double salary :  salaries)
            salariesSum+=salary;

        System.out.println(salariesSum);
    }

    private static void towDArray() {
        int [][] ages = new int [2][3];

        int [] oneD = new int[5];

        int [][] numbers = { {1,2,3,19,7} ,
                {4,5,6,43,8} ,
                {7,8,9,10,80} ,{5,8,6,12,45} };

        int [][] jaggedArray = new int[3][];
        jaggedArray [0] = new int[10];
        jaggedArray [1] = new int[7];
        jaggedArray [2] = new int[25];

        for (int i = 0 ; i< jaggedArray.length ; i++){
            for (int j = 0 ; j< jaggedArray[i].length ; j++)
                System.out.print(jaggedArray[i][j] +" ");
            System.out.println();
        }

    /*    System.out.println(numbers[1][1]);
        System.out.println(numbers[2][3]);
        numbers[1][1] = 25;
        numbers[2][3] = 100 ;
        System.out.println(numbers[1][1]);
        System.out.println(numbers[2][3]);*/
    }

    static void runArray (){

        int [] ages = new int[5];
        int x = 5 ;
        int [] numbers = {1,3,5,6,4,3,2};
        String [] names = {"aly" , "mahmoud"};

        System.out.println(ages[1]);
        int j  =3;
        for (int i =0  ; i < ages.length ; i++ ){
            ages[i] = j++ * 6;
            System.out.print(ages[i] +" , ");
        }
        System.out.println();

        for ( int age : ages) {
            System.out.print( age +" , ");
        }


    }


}
