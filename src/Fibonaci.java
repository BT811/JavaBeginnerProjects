import java.util.Scanner;

public class Fibonaci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("Fibonaccinin kaç absamağını görmek istiyorsun");
        n = input.nextInt();
        int n1=0;
        int n2=1;

        for (int i = 0 ; i<n ; i++){
            int fib;
            fib=n1+n2;
            System.out.println(fib);
            n1=n2;
            n2=fib;
        }

    }
}
