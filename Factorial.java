import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, total = 1;

        System.out.println("Enter the number...");
        num = input.nextInt();

        for (int i = 1 ; i <= num ; i++) total *= i ;

        System.out.println(total);


    }
}
