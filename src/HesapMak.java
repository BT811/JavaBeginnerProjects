import java.util.Scanner;

public class HesapMak {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("ilk sayıyı giriniz:");
        int n1 = input.nextInt();
        System.out.println("İkinci sayıyı giriniz:");
        int n2 = input.nextInt();
        System.out.println("1-Toplama\n2-Çıkarma\n3-Çarpma\n4-Bölme");
        System.out.print("Seçiminiz:");
        int select = input.nextInt();
        switch (select) {
            case 1:
                System.out.println("Sayıların toplamı: " + (n1 + n2));
                break;
            case 2:
                System.out.println("Sayıların farkı: " + (n1 - n2));
                break;
            case 3:
                System.out.println("Sayıların çarpımı: " + n1 * n2);
                break;
            case 4:
                if (n2 == 0) {
                    System.out.println("Bir sayı 0'a bölünemez.");
                } else {
                    System.out.println("Sayıların bölümü: " + n1 / n2);
                }
                break;
            default:
                System.out.println("Geçersiz işlem !!!");
        }

    }
}
