public class MaxMinArrayElement {
    public static void main(String[] args) {
        int[] list = {2,4,7,9,6,3,143,768,54};
        int max = list[0];
        int min = list[0];

        for(int i : list){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }


        }
        System.out.println("Max : "+max);
        System.out.println("Min : "+min);

    }
}
