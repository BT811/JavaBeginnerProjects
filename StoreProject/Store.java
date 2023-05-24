package StoreProject;

import java.util.Scanner;

public class Store {
    public static void main(String[] args) {


        StoreAction store = new StoreAction();
        store.createList();




        boolean exit = true;
        while(exit){
            System.out.println("Store Product Management Panel");
            System.out.println(
                    "1 - Notebook Transactions\n" +
                    "2 - Mobile Phone Transactions\n" +
                    "3 - List Brand\n" +
                    "0 - Sign Out");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            switch (select){
                case 1:
                    System.out.println("| ID | Product Name     | Price   | Brand   | Storage  | Screen | ");
                    store.sortNotebook();
                    break;
                case 2:
                    System.out.println("| ID | Product Name     | Price   | Brand   | Storage  | Screen | ");
                    store.sortPhone();
                    break;
                case 3:
                    System.out.println("----------------");
                    System.out.println("Brands");
                    store.sortBrand();
                    break;
                case 0:
                    exit = false;
                    break;
            }

        }



    }
}
