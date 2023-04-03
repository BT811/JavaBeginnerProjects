import java.util.Scanner;

public class Burc {
    public Burc() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Doğduğunuz ay:");
        int month = input.nextInt();
        System.out.println("Doğduğunuz gün:");
        int day = input.nextInt();
        switch (month) {
            case 1:
                if (day >= 1 && day <= 31) {
                    if (day < 22) {
                        System.out.println("Oğlak");
                    } else {
                        System.out.println("Kova");
                    }
                } else {
                    System.out.println("Girdiğiniz gün geçersiz.");
                }
                break;
            case 2:
                if (day >= 1 && day <= 28) {
                    if (day < 20) {
                        System.out.println("Kova");
                    } else {
                        System.out.println("Balık");
                    }
                } else {
                    System.out.println("Girdiğiniz gün geçersiz.");
                }
        }

    }
}