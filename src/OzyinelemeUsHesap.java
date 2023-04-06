import java.util.Scanner;
public class OzyinelemeUsHesap {

    static int us(int n1 , int n2){
        int result;
        if(n2==1){
            return n1;
        }
        if(n2==0){
            return 1;
        }else{
            return result = n1*(us(n1,n2-1));
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1,n2;

        System.out.println("Taban değerini girin: ");
        n1 = input.nextInt();
        System.out.println("Üs değerini girin: ");
        n2 = input.nextInt();
        System.out.println(us(n1,n2));





    }
}
