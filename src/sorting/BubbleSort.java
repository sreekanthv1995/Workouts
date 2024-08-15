package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,3,2,4,5};
        int[] res = bubbleSort(array);
        String[] strArray = {"b","a","d","c","f","e"};
        String[] result = bubbleSort(strArray);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(res));
    }

    public static int[] bubbleSort(int[] array){

        for (int i = 0; i < array.length; i++){
            int flag = 0;
            for (int j = 0; j < array.length-1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) break;
        }
        return array;
    }

    public static String[] bubbleSort(String[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j].compareTo(array[j+1])>0){
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
