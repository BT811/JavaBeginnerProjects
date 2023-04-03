import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numb,tempnumb,numberDigits=0,placeVal,result=0,baspow;



        System.out.println("Enter The Number...");
        numb = input.nextInt();
        tempnumb=numb;

        while (tempnumb != 0 ){
            tempnumb/=10;
            numberDigits++;
        }

        tempnumb=numb;

        while ( tempnumb != 0 ){
            placeVal=tempnumb%10;
            baspow = 1;
             for(int i = 0 ; i < numberDigits ; i++){
                baspow *= placeVal;
             }
            result += baspow;

            tempnumb/=10;

        }

        System.out.println(result);

        if ( result == numb ){
            System.out.println(numb+" is Armstrong number.");
        }else{
            System.out.println(numb+" is not Armstrong number.");
        }



    }
}
