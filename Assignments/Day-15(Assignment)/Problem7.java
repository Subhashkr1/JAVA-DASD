//Q-7. Write a program to delete all consonants from a string "Hello, have a good day."

public class Problem7 {
    public static void main(String[] args) {
        String str = "Hello, have a good day.";
        String newStr = str.replaceAll("[^aeiouAEIOU]", "");
        System.out.println(newStr);
    }
    
}
