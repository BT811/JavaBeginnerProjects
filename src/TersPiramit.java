import java.util.Scanner;

public class TersPiramit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        
        System.out.println("Piramitin boyunu girin...");
        n = input.nextInt();

        int star = n;

        for (int i = 0 ; i < n ; i++){

            for (int j=0; j<i ; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < (2*star)-1 ; k++){
                System.out.print("*");
            }
            System.out.println();
            star--;
        }

    }
}
