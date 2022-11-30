public class QuickSort {
    public static void quickSortInsertion(int[] arr) {
        quickSortRecursiveInsertion(arr, 0, arr.length - 1);
    }

    public static void quickSortRecursive(int[] arr, int first, int last) {
        int middle = (first + last) / 2;
        orderThree(arr, first, middle, last);
        swap(arr, middle, last);
        int pivot = arr[last];
        int indexFromLeft = first, indexFromRight = last;

        while (indexFromLeft <= indexFromRight) {
            while (arr[indexFromLeft] < pivot) indexFromLeft++;
            while (arr[indexFromRight] > pivot) indexFromRight--;
            if (indexFromLeft <= indexFromRight) swap(arr, indexFromLeft++, indexFromRight--);
        }

        if (first < indexFromRight) quickSortRecursive(arr, first, indexFromRight);
        if (indexFromLeft < last) quickSortRecursive(arr, indexFromLeft, last);

    }

    public static void quickSortRecursiveInsertion(int[] arr, int first, int last) {
        int middle = (first + last) / 2;
        orderThree(arr, first, middle, last);
        swap(arr, middle, last);
        int pivot = arr[last];
        int indexFromLeft = first, indexFromRight = last;

        while (indexFromLeft <= indexFromRight) {
            while (arr[indexFromLeft] < pivot) indexFromLeft++;
            while (arr[indexFromRight] > pivot) indexFromRight--;
            if (indexFromLeft <= indexFromRight) swap(arr, indexFromLeft++, indexFromRight--);
        }

        if (arr.length <= 100) InsertionSort.insertionSort(arr);
        else if (first < indexFromRight) quickSortRecursiveInsertion(arr, first, indexFromRight);
        else if (indexFromLeft < last) quickSortRecursiveInsertion(arr, indexFromLeft, last);

    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void orderThree(int[] arr, int first, int second, int third) {
        if (arr[first] > arr[second]) swap(arr, first, second);
        if (arr[first] > arr[third]) swap(arr, first, second);
        if (arr[second] > arr[third]) swap(arr, second, third);
    }

    public static long TimeQuickSort(int numberOfElements){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(numberOfElements);

        startTime = System.nanoTime();
        quickSortInsertion(arr);
        endTime = System.nanoTime();

        return endTime - startTime;

    }
}