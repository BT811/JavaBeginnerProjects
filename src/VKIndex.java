import java.util.Scanner;

public class VKIndex {
    public VKIndex() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Kilonuzu giriniz:");
        double kilo = input.nextDouble();
        System.out.println("Boyunuzu meter cinsinden giriniz:  ");
        double boy = input.nextDouble();
        double vkındex = kilo / (boy * boy);
        System.out.println("Vücut kitle endeksiniz :" + vkındex);
    }
}