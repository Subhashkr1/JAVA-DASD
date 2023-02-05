//Q-4. How do you compare two strings in Java?
//Ans: We can compare two strings in Java using equals() method. For example:

public class Problem4 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        boolean isEqual = str1.equals(str2);
        System.out.println("Is str1 and str2 equal? " + isEqual);
    }
}
