import java.util.Scanner;

public class EBOBEKOK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1,n2,ebob=1,ekok=1;

        System.out.println("İlk sayıyı girin:");
        n1 = input.nextInt();
        System.out.println("İkinci sayıyı girin:");
        n2 = input.nextInt();

        if(n1>n2){
            for(int i = n2 ; i >= 1; i--){
                if (n2%i==0 && n1%i==0) {ebob=i; break;}
            }
        }else{
            for(int i = n1 ; i >= 1 ; i--){
                if (n2%i==0 && n1%i==0){ebob=i; break;}
            }
        }
        ekok = (n1*n2)/ebob;

        System.out.println("Ebob: "+ebob);
        System.out.println("Ekok: "+ekok);



    }
}
