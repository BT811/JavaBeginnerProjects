import java.util.Scanner;

public class UcakFiyatHesap {
    public UcakFiyatHesap() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double mucret = 0.1;
        System.out.println("Gideceğiniz mesafeyi kilometre cinsinden giriniz:");
        int km = input.nextInt();
        System.out.println("Yaşınızı giriniz:");
        int yas = input.nextInt();
        System.out.println("Yolculuk tipini giriniz: \n1-Gidiş Dönüş\n2-Tek Yön");
        int ytip = input.nextInt();
        double total = (double)km * mucret;
        if (km >= 0) {
            if (yas < 12) {
                total /= 2.0;
            }

            if (12 <= yas && yas < 24) {
                total *= 0.9;
            }

            if (65 < yas) {
                total *= 0.7;
            }

            if (ytip == 1) {
                total = total * 0.8 * 2.0;
            }

            System.out.println("Yolculuk ücretiniz:" + total);
        } else {
            System.out.println("Veriyi yanlış girdiniz.");
        }

    }
}