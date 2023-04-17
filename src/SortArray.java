import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,e;

        System.out.println("How many elements will you enter?");
        n = input.nextInt();
        int[] list = new int[n];

        System.out.println("Enter the elements: ");
        for(int i = 0 ; i < n ; i++){
            e = input.nextInt();
            list[i]=e;
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = i+1 ; j < n ; j++) if(list[i]>list[j]){
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        
        for(int i : list){
            System.out.println(i);
        }

    }
}
