public class BubbleSort {
    public static void bubbleSortSlow(int[] arr) {
        int lastPos = arr.length - 1;
        int innerLastPos = lastPos;
        int temp;

        for (int i = 0; i < lastPos; i++) {
            for (int j = 0; j < innerLastPos; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
            innerLastPos--;
        }
    }

    public static void bubbleSort(int[] arr){
        int firstPos = 0, lastPos = arr.length -1;
        int temp, lastSwapPos;

        while(firstPos < lastPos){
            lastSwapPos = firstPos;
            for(int j = 0; j < lastPos; j++){

                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    lastSwapPos = j;
                }
            }
            lastPos = lastSwapPos;

        }
    }

    public static long TimeBubbleSort(int numberOfElements){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(numberOfElements);

        startTime = System.nanoTime();
        bubbleSort(arr);
        endTime = System.nanoTime();

        return endTime - startTime;

    }
}