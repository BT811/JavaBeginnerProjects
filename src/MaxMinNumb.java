import java.util.Scanner;

public class MaxMinNumb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int loop,sayi,max,min;
        System.out.println("Kaç sayı gireceksiniz ?");
        loop = input.nextInt();
        System.out.println("1. sayıyı girin: ");
         sayi = input.nextInt();
         max=sayi;
         min=sayi;
         int i = 1;

        while ( i < loop){
            System.out.println((i+1)+". sayıyı girin.");
            sayi = input.nextInt();

            if(sayi<min){
                min=sayi;
            } else if (sayi>max) {
                max=sayi;
            }
            i++;
        }

        System.out.println("En küçük sayı: "+min);
        System.out.println("En büyük sayı: "+max);
    }
}
