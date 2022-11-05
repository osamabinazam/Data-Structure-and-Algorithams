import java.util.*;

public class Recursion_Factorial{
    public static void main(String [] args){
        System.out.println("Recursion - Calculating factorial...\n");
        System.out.print("Enter the value of n: ");
        Scanner scan= new Scanner(System.in);
        System.out.println("Factorial is : " + factorial(scan.nextInt()));

    }

    public static int factorial(int n){
        if ( n<=0 )
            return 1;
        else
            return n*factorial(n-1);
        
    }
}