import java.util.Scanner;
public class FindDouble {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.println("Enter the number...");
        num = input.nextInt();

        for(int i = 0 ; i <= num ; i++){
            if(i%2 == 0) System.out.println(i);
        }
    }
}
