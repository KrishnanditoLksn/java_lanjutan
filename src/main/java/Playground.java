import java.util.*;

public class Playground {
    public static void main(String[] args) {
        int[] arrs = {2, 7, 11, 15};
        int[] c = {1, 2, 3, 1, 2, 3};
        int k = 2;
//        System.out.println(containsNearbyDuplicate(c, k));
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

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        // TODO May the force be with you
        int total = 0;
        for (Boolean arrayOfSheep : arrayOfSheeps) {
            if (arrayOfSheep != null && arrayOfSheep) {
                total += 1;
            }
        }
        return total;
    }

    public static int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int total = 0;
        //start from 0 indexed
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    total += 1;
                }
            }
        }

        return total;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //store the complement of the current number
            int complement = target - nums[i];
            //check if the complement is in the hashmap
            if (hashMap.containsKey(complement)) {
                //return array of a result if found
                return new int[]{hashMap.get(complement), i};
            }
            //put the current number and its index in the hashmap
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = n;
        for (int i = 0; i < n; i++) {
            result[l] = nums[i];
            result[l + 1] = nums[r];
            l += 2;
            r++;
        }
        return result;
    }

    public static boolean findDuplicate(int[] nums) {
        Set<Integer> ints = new HashSet<>();
        for (int num : nums) {
            ints.add(num);
        }
        return nums.length != ints.size();
    }

//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> integerSet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                integerSet.add(nums[j]);
//                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}