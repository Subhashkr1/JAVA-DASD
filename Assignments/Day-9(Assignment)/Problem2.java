// Write a program to print triangle using star pattern programming logic


public class Problem2 {
    public static void main(String[] args) {
        int row =10;

        for(int i=0; i<= row; i++){
            for(int j=1;j<= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
}
