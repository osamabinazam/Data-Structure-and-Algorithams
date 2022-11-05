// Calculating n power of a number m  using Recursion 

import java.util.*;

public class Recursion_PowerOfNumber{
    public static void main (String [] args ){
        Scanner scan = new Scanner (System.in);
        System.out.println("Result : " + power(scan.nextDouble() , scan.nextDouble()));


    }
    public static double power(double base, double power){
        if (power == 0){
            return 1;
        }
        else {
            return base*power(base , power-1);
        }
    }
}