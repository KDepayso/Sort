import java.util.Arrays;

public class Sort {

    public static int numComparisons = 0, numSwaps = 0;

    public static void main(String[] args){
        int[] arr = {9 ,2 ,7 ,1 ,10 ,3 ,6 ,4 ,5 ,8};
        System.out.println("Before: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("There were " + numComparisons + " comparisons and " + numSwaps + " swaps");
    }




    public static void bubbleSort(int[] arr){
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
            System.out.println("Pass " + (i+1) + ":" +  Arrays.toString(arr));
        }
    }

}
