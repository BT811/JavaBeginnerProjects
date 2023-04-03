import java.util.Scanner;
public class SumOfOddNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num,total = 0;

        System.out.println("Enter the number...");
        num = input.nextInt();

        for(int i = 0 ; i <= num ; i++) if (i % 2 == 1) total += i;

        System.out.println("Sum Of Odd Numbers : "+total);
    }
}
