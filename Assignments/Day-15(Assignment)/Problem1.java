//Write a simple String program to input from user.

import java.util.Scanner;


public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        System.out.println("You entered: " + str);
        sc.close();
    }
    
}
