import java.util.Scanner;

public class Manav {
    public Manav() {
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Kaç kilo armut aldığınızı girniz:");
        int arm = inp.nextInt();
        System.out.print("Kaç kilo elma aldığınızı girniz:");
        int elma = inp.nextInt();
        System.out.print("Kaç kilo domates aldığınızı girniz:");
        int domates = inp.nextInt();
        System.out.print("Kaç kilo muz aldığınızı girniz:");
        int muz = inp.nextInt();
        System.out.print("Kaç kilo patlıcan aldığınızı girniz:");
        int patıcan = inp.nextInt();
        double total = (double)arm * 2.14 + (double)elma * 3.67 + (double)domates * 1.11 + (double)muz * 0.95 + (double)(patıcan * 5);
        System.out.println("Toplam borcunuz:" + total);
    }
}