//Write a Program to print Alphabets A, B, C, D, E, F, G, H, using pattern programming logic


public class Problem1 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 7 || j == 0 || j == 7) {
                    System.out.print((char) (65 + i) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
    }
    
}
