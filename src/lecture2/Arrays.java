package lecture2;

import java.util.ArrayList;

public class Arrays {
  // TODO
  //  Sum of elements , (DONE)
  //  Max/min value ,
  //  Reversing an array , without using any extra arrays
  //  Copying an array
    public static void  main (String [] args) {

        double [] salaries = {2000 , 13000 , 26000 , 60000 , 75000};


        double salariesSum = 0.0 ;

        for ( double salary :  salaries)
            salariesSum+=salary;

        System.out.println(salariesSum);


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
