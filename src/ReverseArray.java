import java.lang.reflect.Array;
import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        int[] res = reverseArray(array);
        System.out.println(Arrays.toString(res));
    }
    public static int[] reverseArray(int [] array){
        int j = array.length-1;
        int n = array.length;

       for (int i = 0; i < n/2; i++){
           int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--;
        }
        return array;
    }
}

class RemoveDuplicate {
    public static void main(String[] args) {
        int[] array = {1,2,2,3,4,4,4,4,5,2};
//        int[] res = removeDuplicate(array);
//        System.out.println(Arrays.toString(res));
//        removeDuplicateUsingSet(array);
        findDup1(array);
    }
    public static int[] removeDuplicate(int[] array){

        int [] temp = new int[array.length];
        int uniqueCount = 0;
        for (int i: array){
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++){
                if (i == temp[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate){
                temp[uniqueCount++] = i;
            }
        }
        int[] uniqueArray = new int[uniqueCount];
        System.arraycopy(temp,0,uniqueArray,0,uniqueCount);
        return uniqueArray;
    }

    public static void removeDuplicateUsingSet(int[] array){
        Set<Integer>uniqueSet = new HashSet<>();
        for (int i : array){
            uniqueSet.add(i);
        }
        System.out.println(uniqueSet);
    }
    public static void findDup(int [] array){
        Set<Integer> uniqueSet = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        for(int numbers: array){
            if(!uniqueSet.add(numbers)){
                duplicate.add(numbers);
            }
        }
        System.out.println(duplicate);
        System.out.println(uniqueSet);
    }

    public static void findDup1(int[] array){
        Map<Integer,Integer> map = new HashMap<>();

        for (int k : array){
            if (!map.containsKey(k)){
                map.put(k,1);
            }else {
                map.put(k,map.get(k)+1);
            }
        }
        System.out.println(map.keySet());
    }
}
