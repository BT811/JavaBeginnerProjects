public class RepeatingElement {
    static boolean isFind(int[] arr,int value){
        for (int i : arr){
            if(value == i){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] list = {1,3,5,3,1,6,8,4,5,9,9};
        int[] dublicate = new int[list.length];
        int startIndex = 0;


        for(int i = 0 ; i < list.length ; i++){
            for (int j = i+1 ; j < list.length ; j++){
                if(list[i]==list[j] && !isFind(dublicate,list[i])) dublicate[startIndex++] = list[i];
            }
        }

        for (int i : dublicate){
            if(i != 0){
                System.out.println(i);
            }
        }



    }
}
