import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class OzYinelemeAsalSayi {
    static boolean isPrime(int n, int i)
    {

        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)

            return true;

        return isPrime(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1;

        System.out.println("Asal olup olmadığını bilmek istediğiniz sayıyı girin :");
        n1 = input.nextInt();
        System.out.println(isPrime(n1,2));




    }
}
