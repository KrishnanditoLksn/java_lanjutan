import java.util.*;

import static org.example.latihan_toki.Nilai_Kalimat_Matematika_2.solusi2;

public class Playground {
    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4};
//        int[] c = {2, 0, 2, 1, 1, 0};
//        int k = 1;
//        sortColors(c);
//        System.out.println(Arrays.toString(c));

//        solusi2(-100, '<', -50);
        System.out.println(Arrays.toString(runningSum(arrs)));
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
        Map<Integer, Integer> ints = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ints.put(nums[i], i);
        }
        return nums.length != ints.size();
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> integerSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerSet.containsKey(nums[i]) && Math.abs(i - integerSet.get(nums[i])) <= k) {
                return true;
            }
            System.out.println("Array Element:" + nums[i]);
            System.out.println("Index at : " + i);
            integerSet.put(nums[i], i);
            System.out.println(integerSet.keySet());
        }
        return false;
    }

    public static boolean containsBruteForceNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int majorityElement(int[] nums) {
        int mayo = nums.length / 2;
        for (int i : nums) {
            int count = 0;
            for (int j : nums) {
                if (i == j) {
                    count += 1;
                }
            }
            if (count > mayo) {
                return i;
            }
        }
        return -1;
    }

    /*
    Algo by favtutor

        1. Initialize low = 0, mid = 0, and high = n-1, where n is the size of the array.
        2. While mid <= high, repeat steps 3-5.
        3. If the element at index mid is 0, swap it with the element at index low, increment low and mid by 1.
        4. If the element at index mid is 1, leave it in place, and increment mid by 1.
        5. If the element at index mid is 2, swap it with the element at index high, decrement high by 1.
        6. Repeat steps 2-5 until mid exceeds high.
     */
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp;
        while (mid <= high) {
            if (nums[mid] == 0) {
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftsum = 0;

        //fill a total sum of all elements
        for (int num : nums) {
            totalSum += num;
        }
        //loop through elements
        for (int i = 0; i < nums.length; i++) {
            //check if all sum equals to a left sum if not
            if (totalSum - leftsum - nums[i] == leftsum) {
                return i;
            }
            //fill a left sum with nums element
            leftsum += nums[i];
        }
        return -1;
    }
}