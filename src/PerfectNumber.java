import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numb,i,total = 0 ;

        System.out.println("Enter the number: ");
        numb = input.nextInt();

        for ( i = 1 ; i < numb ; i++){
            if(numb % i == 0){
                total+=i;
            }
        }

        if(numb == total){
            System.out.println(numb+" is Perfect Number.");
        }else{
            System.out.println(numb+" is not Perfect Number.");
        }

    }
}
