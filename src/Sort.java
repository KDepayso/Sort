import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static int numComparisons = 0, numSwaps = 0, numUpdates = 0;
    public static int[] arraySizes = {100,200,400,800,1600,3200,6400};
    public static int[] arr = {9,2,7,1,10,3,6,4,5,8};
    public static int[] arrSorted = {1,2,3,4,5,6,7,8,9,10};
    public static int[] arrWorst = {10,9,8,7,6,5,4,3,2,1};
    public static long[] sortTimes = new long[arraySizes.length];
    public static long[] sortTimesRecursive = new long[arraySizes.length];
    public static void main(String[] args){
        long startTime, endTime;






        for(int a = 0; a < arraySizes.length; a++){
            startTime = System.currentTimeMillis();
            for(int i = 0; i < 1000; i++){
                arr = randomArray(arraySizes[a]);
                shellSort(arr, 2);
            }
            endTime = System.currentTimeMillis();
            sortTimes[a] = endTime - startTime;
        }


        for(int a =0; a < arraySizes.length; a++){
            System.out.println(arraySizes[a] + "\t" + sortTimes[a] + "\t");
        }



        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = randomArray(10000);
            shellSort(arr, 2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Gap list of [5000, 2500, 1250, 625, 312, 156, 78, 39, 19, 9, 4, 2, 1]");
        System.out.println("Execution time is: " + (endTime - startTime));




        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = randomArray(10000);
            shellSort(arr, 3);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Gap list of [3333, 1111, 370, 123, 31, 13, 4, 1]");
        System.out.println("Execution time is: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = randomArray(10000);
            shellSort(arr, 4);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Gap list of [2500, 625, 156, 39, 9, 2, 1]");
        System.out.println("Execution time is: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = randomArray(10000);
            shellSort(arr, 2.23);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Gap list of [3875, 1695, 749, 326, 138, 57, 78, 23, 9, 4, 1]");
        System.out.println("Execution time is: " + (endTime - startTime));








    }

    public static void shellSort(int[] arr, double n){
        int temp, index;

        for(int gap = arr.length / 2; gap > 0; gap /= n){
            for(int i = gap; i < arr.length; i++){
                temp = arr[i];
                for(index = i; index >= gap && arr[index - gap] > temp; index -=gap){
                    arr[index] = arr[index - gap];
                }
                arr[index] = temp;
            }
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
            arr[i] = rand.nextInt();
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
    public static void selectionSort(int[] arr){
        int firstPos = 0, lastPos = arr.length - 1;
        int temp, smallestPos;

        for(int i = firstPos; i <lastPos; i++){
            smallestPos = i;

            for(int j = i+1; j <=lastPos;j++){
                if(arr[j] < arr[smallestPos]){
                    smallestPos = j;
                }
            }
            temp = arr[smallestPos];
            arr[smallestPos] = arr[i];
            arr[i] = temp;

        }
    }
    public static void selectionSortRecursive(int[] arr, int firstPosition, int lastPosition){
        int temp, smallestPos;


        if(firstPosition < lastPosition) {
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

    public static void insertionSort(int[] arr){
        int nextToInsert, index;

        for(int i =1; i <arr.length; i++){
            nextToInsert = arr[i];

            index = i - 1;
            while(index >= 0 && arr[index] > nextToInsert){
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

    public static long timeTakenSelection(int n){
        long startTime, endTime;
        int[] arr = randomArray(n);
        startTime = System.currentTimeMillis();
        selectionSort(arr);
        endTime = System.currentTimeMillis();
        return endTime - startTime;

    }
    public static long timeTakenSelectionRecursive(int n){
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        selectionSortRecursive(randomArray(n),0,n - 1);
        endTime = System.currentTimeMillis();
        return endTime - startTime;

    }

}
