// Reversing Given String
//E.g HelloWorld  ->  dlroWolleH


import java.util.*;
public class Recursion_ReverseString{
    public static void main (String [] args ){

        String str = new Scanner(System.in).nextLine();
        System.out.println("Original String : " + str);
        System.out.println("Reverse String : " + reverseString(str));
        
    }
    public static String reverseString(String source){
        if (source.isEmpty() || source == "")
            return source;
        else
            return reverseString(source.substring(1)) + source.charAt(0);
    }


}