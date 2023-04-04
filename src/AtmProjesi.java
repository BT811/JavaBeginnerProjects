import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class AtmProjesi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName,password;
        int right = 3;
        int balance = 1500;
        int select;


        while (right > 0){

            System.out.println("Kullanıcı adınız: ");
            userName = input.nextLine();
            System.out.println("Parolanız: ");
            password = input.nextLine();

            if(userName.equals("bt") && password.equals("1234")){
                System.out.println("Merhaba , Bankamıza Hoşgeldiniz.");
                System.out.println("İstediğiniz işlemi seçiniz.");
                do {
                    System.out.println("1-Para yatırma\n2-Para çekme\n3-Bakiye sorgula\n4-Çıkış yap");
                    select = input.nextInt();


                    switch (select){
                        case 1:
                            System.out.println("Yatırmak istediğiniz miktarı girin...");
                            int price = input.nextInt();
                            balance+=price;
                            break;
                        case 2:
                            System.out.println("Çekmek istediğinz miktarı girin...");
                            price = input.nextInt();
                            balance-=price;
                            break;
                        case 3:
                            System.out.println("Bakiyeniz: "+balance);
                            break;
                    }
                }while (select != 4);
                System.out.println("Çıkış yaptınız.");
                break;
            }else{
                right--;
                if(right!=0){
                    System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyin.");
                    System.out.println("Kalan hakkınız "+right+"\n");
                }else{
                    System.out.println("Hesabınız bloke edilmitir.");
                }
            }
        }
    }
}
