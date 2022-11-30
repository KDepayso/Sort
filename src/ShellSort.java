public class ShellSort {
    public static void shellSort(int[] arr, double n) {
        int temp, index;

        for (int gap = arr.length / 2; gap > 0; gap /= n) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for (index = i; index >= gap && arr[index - gap] > temp; index -= gap) {
                    arr[index] = arr[index - gap];
                }
                arr[index] = temp;
            }
        }
    }

    public static long TimeShellSort(int numberOfElements){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(numberOfElements);

        startTime = System.nanoTime();
        shellSort(arr,2);
        endTime = System.nanoTime();

        return endTime - startTime;

    }
}