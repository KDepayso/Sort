import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static int numComparisons = 0, numSwaps = 0;

    public static void main(String[] args){

        long startTime, endTime;
        int[] arr;
        int[] arraySizes = {100,200,400,800,1600,3200,6400};

        for(int arraySize: arraySizes){
            startTime = System.currentTimeMillis();
            for(int i =0; i < 1000; i++){
                arr = randomArray(arraySize);
                bubbleSort(arr);
            }
            endTime = System.currentTimeMillis();

            System.out.println(arraySize + "\t" + (endTime - startTime));
        }




    }



    public static void bubbleSortSlow(int[] arr){
        int lastPos = arr.length -1;
        int innerLastPos = lastPos;
        int temp;

        for(int i = 0; i < lastPos; i++){
            for(int j = 0; j < innerLastPos; j++){
                numComparisons++;
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    numSwaps++;
                }
            }
            innerLastPos--;
            //System.out.println("Pass " + (i+1) + ":" +  Arrays.toString(arr));
        }
    }

    public static int[] randomArray(int n){
        Random rand = new Random();
        int[] arr = new int[n];

        for(int i =0; i< n; i++){
            arr[i] = rand.nextInt(100);
        }
        return arr;

    }

    public static void bubbleSort(int[] arr){
        int firstPos = 0, lastPos = arr.length -1;
        int temp, lastSwapPos;

        while(firstPos < lastPos){
            lastSwapPos = firstPos;
            for(int j = 0; j < lastPos; j++){
                numComparisons++;
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    numSwaps++;
                    lastSwapPos = j;
                }
            }
            lastPos = lastSwapPos;
            //System.out.println("Pass:" +  Arrays.toString(arr));
        }
    }

}
