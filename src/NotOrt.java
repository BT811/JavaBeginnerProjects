import java.util.Scanner;

public class NotOrt {
    public NotOrt() {
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Matematik notunu giriniz:");
        int mat = inp.nextInt();
        System.out.print("Fizik notunu giriniz:");
        int fiz = inp.nextInt();
        System.out.print("Tarih notunu giriniz:");
        int tarih = inp.nextInt();
        System.out.print("Müzik notunu giriniz:");
        int muzik = inp.nextInt();
        System.out.print("Türkçe notunu giriniz:");
        int turkce = inp.nextInt();
        double sonuc = (double)((mat + fiz + tarih + muzik + turkce) / 5);
        System.out.println("Ortalamanız:" + sonuc);
        System.out.println(sonuc < 55.0 ? "Sınıfta Kaldınız " : "Tebrikler Sınıfı Geçtiniz");
    }
}