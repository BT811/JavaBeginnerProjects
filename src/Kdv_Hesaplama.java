import java.util.Scanner;

public class Kdv_Hesaplama {
    public Kdv_Hesaplama() {
    }

    public static void main(String[] args) {
        double kdvoran = 0.18;
        Scanner input = new Scanner(System.in);
        System.out.println("Ücret tutarını giriniz...");
        double tutar = input.nextDouble();
        double kdvtutar = tutar * kdvoran;
        System.out.println(kdvtutar);
        double toplamtutar = tutar + kdvtutar;
        System.out.println(toplamtutar);
    }
}
