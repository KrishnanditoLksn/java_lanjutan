import java.util.ArrayList;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
//        System.out.println(scoreOfString("zaz"));
//        int[][] matriks = {{1, 2, 3}, {1, 2, 3}};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println(reverseArray(list));
//        System.out.println(sumMatrix(matriks));
//        System.out.println(isPalindrome("0P"));
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int scoreOfString(String s) {
        int sum = 0; //O(1)
        for (int i = 0; i < s.length() - 1; i++) { //n
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1)); //O(1)
        }
        return sum;
    }

    public static int sumMatrix(int[][] matriks) {
        int sum = 0;
        for (int[] matrik : matriks) {
            for (int i : matrik) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isPalindrome(String s) {
        //Instantiate String builder class
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); //O(1)
        StringBuilder rev = new StringBuilder();//O(1)
        //iterating back from length of string - 1, decrement i
        for (int i = s.length() - 1; i >= 0; i--) { //O(N)
            //break words into char
            //and then append it to string builder
            rev.append(s.charAt(i));
        }
        //comparing the original string with reversed word
        return rev.toString().equalsIgnoreCase(s);
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        List<Integer> reversed = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            reversed.add(a.get(i));
        }
        return reversed;
    }
}