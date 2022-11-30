public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int firstPos = 0, lastPos = arr.length - 1;
        int temp, smallestPos;

        for (int i = firstPos; i < lastPos; i++) {
            smallestPos = i;

            for (int j = i + 1; j <= lastPos; j++) {
                if (arr[j] < arr[smallestPos]) {
                    smallestPos = j;
                }
            }
            temp = arr[smallestPos];
            arr[smallestPos] = arr[i];
            arr[i] = temp;

        }
    }

    public static void selectionSortRecursive(int[] arr, int firstPosition, int lastPosition) {
        int temp, smallestPos;


        if (firstPosition < lastPosition) {
            smallestPos = firstPosition;

            for (int j = firstPosition + 1; j <= lastPosition; j++) {

                if (arr[j] < arr[smallestPos]) {
                    smallestPos = j;
                }
            }
            temp = arr[smallestPos];
            arr[smallestPos] = arr[firstPosition];
            arr[firstPosition] = temp;


            selectionSortRecursive(arr, firstPosition + 1, lastPosition);


        }
    }

    public static long TimeSelectionSort(int numberOfElements){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(numberOfElements);

        startTime = System.nanoTime();
        selectionSort(arr);
        endTime = System.nanoTime();

        return endTime - startTime;

    }
}