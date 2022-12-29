package Recursion;

//  Calculating Permutation using Recursion n-> Total Items r -> Items to be select
import java.util.*;
public class Recursion_Permutation{
    public static void main (String [] args){
        try{
        Scanner scan = new Scanner(System.in);
        System.out.print("n -> : ");
        int n = scan.nextInt();
        System.out.print("\nr -> : ");
        int r = scan.nextInt();
        System.out.println("\nPermutation is : " + Permutation(n, r));
        }catch(Exception e ){
            System.out.println("\nWrong inputs!, Try again.");
        }
    }
    // Calculate Permutation
    public static int Permutation(int n , int r){
        if (n >=0 && r >=0 ){
            //Calculating n!
            int numirator=factorial(n);
            int  denumirator= factorial(r);
            return numirator/denumirator;
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