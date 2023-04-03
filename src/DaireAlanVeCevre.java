import java.util.Scanner;

public class DaireAlanVeCevre {
    public DaireAlanVeCevre() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Dairelin yarı çapını giriniz...");
        int r = input.nextInt();
        double pi = 3.14;
        double alan = pi * (double)r * (double)r;
        double cevre = 2.0 * pi * (double)r;
        System.out.println("Daire alanı :" + alan);
        System.out.println("Daire çevresi :" + cevre);
    }
}