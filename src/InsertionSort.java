public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int nextToInsert, index;

        for (int i = 1; i < arr.length; i++) {
            nextToInsert = arr[i];

            index = i - 1;
            while (index >= 0 && arr[index] > nextToInsert) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = nextToInsert;
        }
    }

    public static void insertionSortRecursive(int[] arr, int firstPos, int lastPos){
        int nextToInsert, index;


        if(firstPos < lastPos){
            insertionSortRecursive(arr, firstPos, lastPos - 1);
            nextToInsert = arr[lastPos];

            index = lastPos - 1;

            while(index >= 0 && arr[index] > nextToInsert){
                arr[index + 1] = arr[index];

                index--;

            }
            arr[index + 1] = nextToInsert;

        }
    }

    public static long TimeInsertionSort(int numberOfElements){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(numberOfElements);

        startTime = System.nanoTime();
        insertionSort(arr);
        endTime = System.nanoTime();

        return endTime - startTime;

    }
}