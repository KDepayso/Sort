import java.util.Arrays;

public class Sort {

    public static int numComparisons = 0, numSwaps = 0, numUpdates = 0;
    public static int[] arraySizes = {100,200,400,800,1600,3200,6400};
    public static int[] arraySizes2 = {10000,50000,100000};
    public static int[] arr = {9,2,7,1,10,3,6,4,5,8};
    public static int[] arrSorted = {1,2,3,4,5,6,7,8,9,10};
    public static int[] arrWorst = {10,9,8,7,6,5,4,3,2,1};
    public static long[] sortTimes = new long[arraySizes.length];
    public static long[] sortTimesRecursive = new long[arraySizes.length];
    public static void main(String[] args){
        long startTime, endTime;




//
//        for(int a = 0; a < arraySizes.length; a++){
//            startTime = System.currentTimeMillis();
//            for(int i = 0; i < 1000; i++){
//                arr = RandomArray.randomArray(arraySizes[a]);
//                ShellSort.shellSort(arr,2);
//            }
//            endTime = System.currentTimeMillis();
//            sortTimes[a] = endTime - startTime;
//        }
//
//        for(int a =0; a < arraySizes.length; a++){
//            System.out.println(arraySizes[a] + "\t" + sortTimes[a] + "\t");
//        }
//
//
//        System.out.println("QuickSort Times with Insertion");
//        for(int a = 0; a < arraySizes2.length; a++){
//            startTime = System.currentTimeMillis();
//            for(int i = 0; i < 1000; i++){
//                arr = randomArray(arraySizes2[a]);
//                quickSortInsertion(arr);
//            }
//            endTime = System.currentTimeMillis();
//            sortTimes[a] = endTime - startTime;
//        }
//
//
//        for(int a =0; a < arraySizes2.length; a++){
//            System.out.println(arraySizes2[a] + "\t" + sortTimes[a] + "\t");
//        }

//
//
//        System.out.println("Before: "+ Arrays.toString(arr));
//        InsertionSort.insertionSort(arr);
//        System.out.println("After: "+ Arrays.toString(arr));





        System.out.println("Array Size : 5000");
        System.out.println("Temporary array passed as paramater: " + timeSortParameter(5000));
        System.out.println("Temporary array generated in merge method: " + timeSortParameterSlow(5000));

        System.out.println("Array Size : 10000");
        System.out.println("Temporary array passed as paramater: " + timeSortParameter(10000));
        System.out.println("Temporary array generated in merge method: " + timeSortParameterSlow(10000));










    }



    public static long timeSortParameter(int n){
        long startTime, endTime,sortTime;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = RandomArray.randomArray(n);
            MergeSort.mergeSort(arr);
        }
        endTime = System.currentTimeMillis();
        sortTime = endTime - startTime;

        return sortTime;

    }

    public static long timeSortParameterSlow(int n){
        long startTime, endTime,sortTime;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = RandomArray.randomArray(n);
            MergeSort.mergeSortSlow(arr, 0, arr.length - 1);
        }
        endTime = System.currentTimeMillis();
        sortTime = endTime - startTime;

        return sortTime;


    }


    public static long timeTakenSelection(int n){
        long startTime, endTime;
        int[] arr = RandomArray.randomArray(n);
        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(arr);
        endTime = System.currentTimeMillis();
        return endTime - startTime;

    }
    public static long timeTakenSelectionRecursive(int n){
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        SelectionSort.selectionSortRecursive(RandomArray.randomArray(n), 0, n - 1);
        endTime = System.currentTimeMillis();
        return endTime - startTime;

    }

}
