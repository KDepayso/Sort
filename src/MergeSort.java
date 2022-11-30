public class MergeSort {
    static void mergeSortRecursive(int[] arr, int temp[], int first, int last) {

        if (first < last) {
            int mid = (first + last) / 2;
            mergeSortRecursive(arr, temp, first, mid);
            mergeSortRecursive(arr, temp, mid + 1, last);
            merge(arr, temp, first, mid, last);
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int[] temp, int first, int mid, int last) {
        int pos1 = first, pos2 = mid + 1, index = first;


        while (pos1 <= mid && pos2 <= last) {
            if (arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
            else temp[index++] = arr[pos2++];
        }

        while (pos1 <= mid) temp[index++] = arr[pos1++];
        while (pos2 <= last) temp[index++] = arr[pos2++];

        for (int i = first; i <= last; i++) arr[i] = temp[i];

    }

    public static void mergeSortSlow(int[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSortSlow(arr, first, mid);
            mergeSortSlow(arr, mid + 1, last);
            mergeSlow(arr, first, mid, last);
        }
    }

    public static void mergeSlow(int[] arr, int first, int mid, int last) {
        int pos1 = first, pos2 = mid + 1, index = first;
        int[] temp = new int[arr.length];

        while (pos1 <= mid && pos2 <= last) {
            if (arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
            else temp[index++] = arr[pos2++];
        }

        while (pos1 <= mid) temp[index++] = arr[pos1++];
        while (pos2 <= last) temp[index++] = arr[pos2++];

        for (int i = first; i <= last; i++) arr[i] = temp[i];

    }

    public static long TimeMergeSort(int numberOfElements){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(numberOfElements);

        startTime = System.nanoTime();
        mergeSort(arr);
        endTime = System.nanoTime();

        return endTime - startTime;

    }
}