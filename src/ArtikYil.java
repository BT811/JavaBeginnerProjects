import java.util.Scanner;

public class ArtikYil {
    public ArtikYil() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Yılı girin");
        int yil = input.nextInt();
        if (yil % 4 != 0 || yil % 100 == 0 && yil % 400 != 0) {
            System.out.println("" + yil + " artık yıl değildir.");
        } else {
            System.out.println("" + yil + " artık yıldır.");
        }

    }
}
