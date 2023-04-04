import java.util.Scanner;

public class Piramit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,i=1;

        System.out.println("Piramitin uzunluğunu giriniz...");
        n = input.nextInt();

        while (i<=n){
           for (int tempn = 0 ; tempn < (n-i) ; tempn++) System.out.print(" ");

           for(int j = 0 ; j<(2*i)-1 ; j++) System.out.print("*");

           System.out.println();
           i++;
        }

    }
}
