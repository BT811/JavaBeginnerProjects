import java.util.Scanner;
public class FindMultiplesOfTwo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num,total = 0;

        System.out.println("Enter the number...");
        num = input.nextInt();

        for (int i = 1 ; i <= num ; i*=2) System.out.println(i);

    }
}