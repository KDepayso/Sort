import java.util.Arrays;
import java.util.Random;

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




        for(int a = 0; a < arraySizes.length; a++){
            startTime = System.currentTimeMillis();
            for(int i = 0; i < 1000; i++){
                arr = randomArray(arraySizes[a]);
                quickSort(arr);
            }
            endTime = System.currentTimeMillis();
            sortTimes[a] = endTime - startTime;
        }



        for(int a =0; a < arraySizes.length; a++){
            System.out.println(arraySizes[a] + "\t" + sortTimes[a] + "\t");
        }
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

//        System.out.println("Before: "+ Arrays.toString(arr));
//        quickSort(arr);
//        System.out.println("After: "+ Arrays.toString(arr));
//




//        System.out.println("Array Size : 5000");
//        System.out.println("Temporary array passed as paramater: " + timeSortParameter(5000));
//        System.out.println("Temporary array generated in merge method: " + timeSortParameterSlow(5000));
//
//        System.out.println("Array Size : 10000");
//        System.out.println("Temporary array passed as paramater: " + timeSortParameter(10000));
//        System.out.println("Temporary array generated in merge method: " + timeSortParameterSlow(10000));










    }


    public static long timeSortParameter(int n){
        long startTime, endTime,sortTime;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = randomArray(n);
            mergeSort(arr);
        }
        endTime = System.currentTimeMillis();
        sortTime = endTime - startTime;

        return sortTime;

    }

    public static long timeSortParameterSlow(int n){
        long startTime, endTime,sortTime;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            arr = randomArray(n);
            mergeSortSlow(arr,0,arr.length -1);
        }
        endTime = System.currentTimeMillis();
        sortTime = endTime - startTime;

        return sortTime;


    }

    private static void mergeSortRecursive(int[] arr, int temp[], int first , int last){

        if(first < last){
            int mid = (first + last) / 2;
            mergeSortRecursive(arr,temp, first,mid);
            mergeSortRecursive(arr,temp, mid + 1, last);
            merge(arr,temp, first,mid,last);
        }
    }

    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr,temp,0,arr.length -1);
    }

    public static void merge(int[] arr,int[] temp, int first, int mid, int last){
        int pos1 = first, pos2 = mid + 1, index = first;


        while(pos1 <= mid && pos2 <= last){
            if(arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
            else temp[index++] = arr[pos2++];
        }

        while(pos1 <= mid) temp[index++] = arr[pos1++];
        while(pos2 <= last) temp[index++] = arr[pos2++];

        for(int i = first; i <= last; i++) arr[i] = temp[i];

    }


    public static void mergeSortSlow(int[] arr, int first, int last){
        if(first < last){
            int mid = (first + last) / 2;
            mergeSortSlow(arr,first,mid);
            mergeSortSlow(arr,mid + 1,last);
            mergeSlow(arr,first,mid,last);
        }
    }

    public static void mergeSlow(int[] arr, int first, int mid, int last){
        int pos1 = first, pos2 = mid + 1, index = first;
        int[] temp = new int[arr.length];

        while(pos1 <= mid && pos2 <= last){
            if(arr[pos1] <= arr[pos2]) temp[index++] = arr[pos1++];
            else temp[index++] = arr[pos2++];
        }

        while(pos1 <= mid) temp[index++] = arr[pos1++];
        while(pos2 <= last) temp[index++] = arr[pos2++];

        for(int i = first; i <= last; i++) arr[i] = temp[i];

    }

    public static void quickSort(int[] arr){
        quickSortRecursive(arr,0,arr.length-1);
    }

    public static void quickSortInsertion(int[] arr){
        quickSortRecursiveInsertion(arr,0,arr.length-1);
    }


    public static void quickSortRecursive(int[] arr, int first, int last){
        int middle = (first + last)/2;
        orderThree(arr,first,middle,last);
        swap(arr,middle,last);
        int pivot = arr[last];
        int indexFromLeft = first, indexFromRight = last;

        while(indexFromLeft <= indexFromRight){
            while(arr[indexFromLeft] < pivot) indexFromLeft++;
            while(arr[indexFromRight] > pivot) indexFromRight--;
            if(indexFromLeft <= indexFromRight) swap(arr,indexFromLeft++ ,indexFromRight--);
        }

        if(first < indexFromRight) quickSortRecursive(arr, first, indexFromRight);
        if(indexFromLeft < last) quickSortRecursive(arr, indexFromLeft, last);

    }

    public static void quickSortRecursiveInsertion(int[] arr, int first, int last){
        int middle = (first + last)/2;
        orderThree(arr,first,middle,last);
        swap(arr,middle,last);
        int pivot = arr[last];
        int indexFromLeft = first, indexFromRight = last;

        while(indexFromLeft <= indexFromRight){
            while(arr[indexFromLeft] < pivot) indexFromLeft++;
            while(arr[indexFromRight] > pivot) indexFromRight--;
            if(indexFromLeft <= indexFromRight) swap(arr,indexFromLeft++ ,indexFromRight--);
        }

        if(arr.length <= 100) insertionSort(arr);
        else if(first < indexFromRight) quickSortRecursive(arr, first, indexFromRight);
        else if(indexFromLeft < last) quickSortRecursive(arr, indexFromLeft, last);

    }



    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void orderThree(int[] arr, int first, int second, int third){
        if(arr[first] > arr[second]) swap(arr,first,second);
        if(arr[first] > arr[third]) swap(arr,first,second);
        if(arr[second] > arr[third]) swap(arr,second,third);
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
