import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] list_angka = angka(1000000,0,999);
        int target = 31;

        System.out.println(Arrays.toString(list_angka));

        // SEQUENTIAL SEARCH =================================================
        double startTime = System.nanoTime();
        if (sequentialSearch(list_angka, target) == -1) {
            System.out.println("tidak ketemu");
        } else {
            System.out.println("angka " + target + " ditemukan di indeks " + sequentialSearch(list_angka, target));
        }
        double endTime = System.nanoTime();
        double elapsed = (endTime - startTime) / 1000000;
        System.out.println("sequential search : " + (elapsed) + " nano seccond ");
        //  =======================================================================================================================

        // BINARY SEARCH =================================================
        Arrays.sort(list_angka);
        startTime = System.nanoTime();
        if (binarySearch(list_angka, target) == null) {
            System.out.println("tidak ketemu");
        } else {
            System.out.println("angka " + target + " ditemukan di indeks " + binarySearch(list_angka, target));
        }
        endTime = System.nanoTime();
        elapsed = (endTime - startTime) / 1000000;
        System.out.println("binary search : " + (elapsed) + " nano seccond ");
    }

    //  =======================================================================================================================

    public static int sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) /*  n  */ {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    //versi iteratif
    public static String binarySearch(int[] arr, int key) {
        int high = arr.length - 1; // O(1)
        int low = 0; //O(1)
        while (low <= high) { //O(1)
            int mid = (low + high) / 2; //O(1)
            if (arr[mid] > key) { //O(1)
                high = mid - 1;//O(1)
            } else if (arr[mid] < key) {// O(1)
                low = mid + 1;// O(1)
            } else {
                return "Ketemu " + mid;  //  O(1)
            }
        }
        return null; //

        /* KOMPLEKSITAS BINARY SEARCH ITERATIF best

            O(1) + O(1) + O(1) + O(1)  + O(1) + MAX( 0(1) + 0(1) + O(1)  + O(1) , O(1) ) + O(1)
            O(1) + O(1) + MAX( 0(1) , O(1) ) + O(1)
            O(1) + O(1) + O(1) + O(1)
            O(1) + O(1)
            O(1)



            worst
         */
    }

    public static int[] angka(int size,int min,int max) {
        int[] numbers = new int[size];
        for (int i = 1; i < size + 1; i++) {
           numbers[i - 1] = (int) (Math.random() * (max - min) + min);
        }
        return numbers;
    }

//    public static void mergeSort(int[] arr, int n) {
//        if (n < 2) {
//            return;
//        }
//
//        int mid = n / 2;
//        int[] l = new int[mid];
//        int[] r = new int[n - mid];
//
//        // copy through a left array
//        System.arraycopy(arr, 0, l, 0, l.length);
//
//        //copy through a right array
//        if (n - mid >= 0) System.arraycopy(arr, mid, r, 0, n - mid);
//
//        mergeSort(l, mid);
//        mergeSort(r, n - mid);
//
//        merge(arr, l, r, mid, n - mid);
//
//    }
//
//    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
//        int i = 0, j = 0, k = 0;
//
//        while (i < left && j < right) {
//            if (l[i] <= r[j]) {
//                a[k++] = l[i++];
//            } else {
//                a[k++] = r[j++];
//            }
//        }
//
//        while (i < left) {
//            a[k++] = l[i++];
//        }
//
//        while (j < right) {
//            a[k++] = r[j++];
//        }
//    }
}
