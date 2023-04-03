import java.util.Scanner;

public class Sort {
    public Sort() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 Sayı");
        int a = input.nextInt();
        System.out.println("2 Sayı");
        int b = input.nextInt();
        System.out.println("3 Sayı");
        int c = input.nextInt();
        if (a > b && a > c) {
            if (b > c) {
                System.out.println("Sayıların sıralanmış hali:" + a + "-" + b + "-" + c);
            }

            if (c > b) {
                System.out.println("Sayıların sıralanmış hali:" + a + "-" + c + "-" + b);
            }
        } else if (b > a && b > c) {
            if (a > c) {
                System.out.println("Sayıların sıralanmış hali:" + b + "-" + a + "-" + c);
            }

            if (a > c) {
                System.out.println("Sayıların sıralanmış hali:" + b + "-" + c + "-" + a);
            }
        } else if (c > a && c > b) {
            if (a > b) {
                System.out.println("Sayıların sıralanmış hali:" + c + "-" + a + "-" + b);
            }

            if (b > a) {
                System.out.println("Sayıların sıralanmış hali:" + c + "-" + b + "-" + a);
            }
        }

    }
}