import java.util.Scanner;

public class ExponentialNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int down,up,result = 1;

        System.out.println("Enter the number to be exponentiated...");
        down = input.nextInt();
        System.out.println("Enter the number to be the exponent...");
        up = input.nextInt();

        for (int i = 0 ; i < up ; i++) result *= down ;

        System.out.println("Result: "+result);


    }
}
