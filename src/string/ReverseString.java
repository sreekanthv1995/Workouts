package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("hello sreekanth"));
    }

    public static String reverse(String str){
        char[] charArray = str.toCharArray();
        int i = 0;
        int j = str.length()-1;

        while (i < j){
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return new String(charArray);
    }
}

class ReverseStringWithOutChangePosition {
    public static void main(String[] args) {
        System.out.println(reverseStringWithOutChangePosition("Hello World"));
    }

    public static String reverseStringWithOutChangePosition(String str){
        String[] strArray = str.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String word: strArray){
            String reverse = new StringBuilder(word).reverse().toString();
            System.out.println(reverse);
            sb.append(reverse).append(" ");
        }
        return sb.toString().trim();
    }
}
class ReverseStringUsingRecursion {

    public static void main(String[] args) {
        System.out.println(reverse("vishnu mani"));
    }

    public static String reverse(String str){
        if (str.isEmpty()){
            return str;
        }
        int spaceIndex = str.indexOf(' ');
        if (spaceIndex == -1){
           return reverseStringUsingRecursion(str);
        }

        String word1 = str.substring(0,spaceIndex);
        String word2 = str.substring(spaceIndex+1);
        return reverseStringUsingRecursion(word1)+" "+reverse(word2);
    }
    public static String reverseStringUsingRecursion(String word){
        if (word.isEmpty()){
            return word;
        }
        return reverse(word.substring(1))+word.charAt(0);
    }
}

class RemoveAllDuplicate {

    public static void main(String[] args) {

        System.out.println(removeDuplicate("sreekanth"));
    }

    public static String removeDuplicate(String str){
        char[] charArray = new char[256];
        for (int i = 0; i < str.length(); i++){
            charArray[str.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (charArray[str.charAt(i)] == 1){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
class RemoveDuplicate {

    public static void main(String[] args) {
        System.out.println(removeDuplicate("hello"));
        String word = "Hello World";
        long count = Arrays.stream(word.split("\\s")).count();
        System.out.println(count);
    }

    public static String removeDuplicate(String str){

        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c,1);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
class removeElementFromArray {
    public static void main(String[] args) {
        String[] array = {"a","b","c","d","e","f"};
        String[] rArray = removeElement(array,"a");
        System.out.println(Arrays.toString(rArray));
    }
    public static String[] removeElement(String[] arr, String element) {
        int n = arr.length;
        int i = 0;
        // Find the index of the element to be removed
        while (i < n && !arr[i].equals(element)) {
            i++;
        }
        // If the element was not found, return the original array
        if (i == n) {
            return arr;
        }
        // Create a new array with a reduced size
        String[] newArr = new String[n - 1];
        // Copy elements before the found index
        for (int j = 0; j < i; j++) {
            newArr[j] = arr[j];
        }
        // Copy elements after the found index
        for (int j = i; j < n - 1; j++) {
            newArr[j] = arr[j + 1];
        }
        return newArr;
    }
}

class Vowels {
    public static void main(String[] args) {
        System.out.println(transformString("saree"));
    }

    public static String transformString(String word){
        char[] chars = {'a','e','i','o','u'};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if (isVowel(c,chars)){
                res.append(Character.toUpperCase(c));
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private static boolean isVowel(char c,char[] chars){
        for (char ch: chars){
            if (ch == c)
                return true;
        }
        return false;
    }
}
