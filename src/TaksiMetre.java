import java.util.Scanner;

public class TaksiMetre {
    public TaksiMetre() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double startprice = 10.0;
        double perKm = 2.2;
        System.out.println("Mesafeyi kilometre cinsinden giriniz...");
        int km = input.nextInt();
        double total = startprice + perKm * (double)km;
        total = total < 20.0 ? 20.0 : total;
        System.out.println("Ücret :" + total);
    }
}
