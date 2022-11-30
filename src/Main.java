import java.util.Scanner;

public class Main {

    public static int[] arraySizes = new int[]{10,100,1000,10000,100000,1000000};
    public static long[] sortTimes = new long[arraySizes.length];
    public static double[] rateOfIncrease = new double[arraySizes.length];
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.println("Sort Performance Analyser" +
                "\nMeasuring the execution time when sorting arrays" +
                "\nof 10, 100, 1K, 10K, 100K, and 1 million elements" +
                "\n-------------------------------------------------" +
                "\n\n" +
                "\nChoose a sort algorithm" +
                "\n-----------------------" +
                "\n1. Bubble Sort" +
                "\n2. Selection Sort" +
                "\n3. Insertion Sort" +
                "\n4. Shell Sort" +
                "\n5. Merge Sort" +
                "\n6. Quick Sort" +
                "\n-----------------------");


        input = scanner.nextInt();

        while(input != 9){

            switch(input){
                case 1: bubbleSortArray();
                    printResults("Bubble Sort");
                    break;
                case 2: selectionSortArray();
                    printResults("Selection Sort");
                    break;
                case 3: insertionSortArray();
                    printResults("Insertion Sort");
                    break;
                case 4: shellSortArray();
                    printResults("Shell Sort");
                    break;
                case 5: mergeSortArray();
                    printResults("Merge Sort");
                    break;
                case 6: quickSortArray();
                    printResults("Quick Sort");
                    break;
            }
            input = scanner.nextInt();
        }




    }

    public static void printResults(String sortType){
        final Object[][] table = new String[7][];

        System.out.println("\n\n" + sortType);

        table[0] = new String[] { "Array Size", "Sort Time(ns)", "Rate of Increase" };
        for(int i = 1; i < arraySizes.length + 1; i++){
            table[i] = new String[] {
                    String.valueOf(arraySizes[i - 1]),
                    String.valueOf(sortTimes[i - 1]),
                    String.format("%.2f",rateOfIncrease[i - 1])};
        }

        for (final Object[] row : table) {
            System.out.format("%10s%30s%30s%n", row);
        }

    }

    public static void calculateRateOfIncrease(){

        rateOfIncrease[0] = 0;
        for(int i = 1; i < sortTimes.length ; i++){
            rateOfIncrease[i] = (double) sortTimes[i] / (double) sortTimes[i - 1];
        }
    }

    public static void bubbleSortArray(){
        for(int i =0; i < arraySizes.length; i++){
            sortTimes[i] =  BubbleSort.TimeBubbleSort(arraySizes[i]);
        }
        calculateRateOfIncrease();
    }

    public static void selectionSortArray(){
        for(int i =0; i < arraySizes.length; i++){
            sortTimes[i] =  SelectionSort.TimeSelectionSort(arraySizes[i]);
        }
        calculateRateOfIncrease();
    }

    public static void insertionSortArray(){
        for(int i =0; i < arraySizes.length; i++){
            sortTimes[i] =  InsertionSort.TimeInsertionSort(arraySizes[i]);
        }
        calculateRateOfIncrease();
    }

    public static void shellSortArray(){
        for(int i =0; i < arraySizes.length; i++){
            sortTimes[i] =  ShellSort.TimeShellSort(arraySizes[i]);
        }
        calculateRateOfIncrease();
    }

    public static void mergeSortArray(){
        for(int i =0; i < arraySizes.length; i++){
            sortTimes[i] =  MergeSort.TimeMergeSort(arraySizes[i]);
        }
        calculateRateOfIncrease();
    }

    public static void quickSortArray(){
        for(int i =0; i < arraySizes.length; i++){
            sortTimes[i] =  QuickSort.TimeQuickSort(arraySizes[i]);
        }
        calculateRateOfIncrease();
    }




}