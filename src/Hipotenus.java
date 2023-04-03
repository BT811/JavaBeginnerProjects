import java.util.Scanner;

public class Hipotenus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. kenarı giriniz...");
        int a = input.nextInt();
        System.out.println("2. kenarı giriniz...");
        int b = input.nextInt();
        double c = Math.sqrt((double)(a * a + b * b));
        System.out.println("Hipotenüs :" + c);
    }
}
