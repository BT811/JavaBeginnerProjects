public class CalculateAverageArray {
    public static void main(String[] args) {
        int[] list = {12,34,65,1,87,5};

        double sum = 0;

        for(int i = 0 ; i <= list.length ; i++){
            sum += list[i];
        }

        double avarage = sum / list.length;

        System.out.println("Avarage: "+avarage);
    }
}
