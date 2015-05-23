package web;

/**
 * Created by allen on 5/21/15.
 */
public class QuickSort {

    public void qsort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;
        if (low >= high) return;

        int mid = low + (high - low)/2;
        int povit = arr[mid];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < povit) i++;
            while (arr[j] > povit) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            qsort(arr, low, j);
        }
        if (high > i) {
            qsort(arr, i, high);
        }

    }


    public static void main(String[] args) {
        int[] array = {9,2,4,7,3,7,10};
        int low = 0;
        int high = array.length - 1;
        QuickSort quickSort = new QuickSort();
        quickSort.qsort(array, low, high);

        for (int i = 0; i < high; i++) {
            System.out.println(array[i]);
        }
    }
}
