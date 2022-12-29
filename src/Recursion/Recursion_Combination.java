package Recursion;

//  Calculating Combination using Recursion n-> Total Items r -> Ways
import java.util.*;
public class Recursion_Combination{
    public static void main (String [] args){
        try{
        Scanner scan = new Scanner(System.in);
        System.out.print("n -> : ");
        int n = scan.nextInt();
        System.out.print("\nr -> : ");
        int r = scan.nextInt();
        System.out.println("\nCombination is : " + Combination(n, r));
        }catch(Exception e ){
            System.out.println("\nWrong inputs!, Try again.");
        }
    }
    // Calculate Permutation
    public static int Combination(int n , int r){
        if (n >=0 && r >=0 ){
            //Calculating n!
            int nFactorial=factorial(n);
            int rFactorial= factorial(r);
            int n_rFactorial = factorial(n-r);
            return nFactorial/(rFactorial*n_rFactorial);
        }
        else {
            return 0;
        }

    }
    //Calculate Factorial
    public static int factorial(int n){
        if ( n<0 )
            return -1;
        else if (n==0)
            return 1;
        else
            return n*factorial(n-1);
        
    }



}