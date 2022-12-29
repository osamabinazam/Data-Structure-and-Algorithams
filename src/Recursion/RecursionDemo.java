package Recursion;

// Recursion is a way of solving a problem by having function calling itself again and again
// Performing the same operation multiple times with different inputs.
// In every we try smaller inputs to make the problem smaller.
// Base condition is needed to stop recursion other wise it will run infinitely
// The prominent usage of Recursion in data structures like Trees and Graphs

public class RecursionDemo{
    public static void main(String args[] ){
        System.out.println("Recursion Demo - Printing 1 to 10 natural numbers ");
        printNumbers(10);

    }
    public static void printNumbers(int number){
        if (number<1){
            System.out.print("Numbers are : ");
            return;
        }
        else{
            printNumbers(number-1);
            System.out.print(number + " ");

        }
    }
}