//  Calculating Fibonaccci series using recursion
// 0 1 1 2 3 5 8 ...
// F(n)  = f(n-1)+f(n-2)
// Base Conditions: n==0 or n==1 , n<0

import java.util.*;
public class Recursion_Fibonacci{
    public static void main (String [] args){
        
        fibonacciSeries(6);
        
    }

    public static int fibonacciSeries(int n){
        //Base Conditions
        if (n<0)
            return -1;
        else if (n==0 || n==1){
            return n;
        }
        else {
             return fibonacciSeries(n-1)+fibonacciSeries(n-2);
        }

    }

}