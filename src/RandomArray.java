import java.util.Random;

public class RandomArray {
    public static int[] randomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;

    }
}