import java.util.Scanner;

public class PalindromeNumber {
    static boolean isPalindrome(int number){
        int temp = number,reverseNumb = 0,lastNumb;

        while (temp != 0){
            lastNumb = temp%10;
            reverseNumb = (reverseNumb*10)+lastNumb;
            temp /= 10;
        }

        if(number == reverseNumb){
            System.out.println("Your number is Palindrome.");
            return  true;
        }else{
            System.out.println("Your number is not Palindrome.");
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n ;

        System.out.println("***Check If Your Number Is a Palindrome Number***");
        System.out.println("Enter number: ");
        n = input.nextInt();

        isPalindrome(n);
    }
}
