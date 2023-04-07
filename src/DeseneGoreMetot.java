import java.util.Scanner;



public class DeseneGoreMetot {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1=10;
        figure(7);






    }
    static void figure(int a) {
        System.out.print(a + " ");
        if (a <= 0) {
            return;
        }
        figure(a - 5);
        System.out.print(a + " ");
    }


}

