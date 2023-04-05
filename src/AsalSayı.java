import java.util.Scanner;

public class AsalSayı {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("Kaça kadar asal sayıları görmek istiyorsun");
        n = input.nextInt();
        
        for (int i = 1 ; i < n ; i++){

            int sayac = 0;

            for (int k = 1 ; k <= i ; k++){

                if(i%k==0)sayac++;
            }

            if(sayac==2) System.out.println(i);
        }



    }
}

