import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The length of random array: ");
        int n = scanner.nextInt();
        Random random = new Random();
        System.out.println("The minimum value of the random array: ");
        int min = scanner.nextInt();
        System.out.println("The maximum value of the random array: ");
        int max = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ",array[i]);
        }
        System.out.println();

        process(array, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ",array[i]);
        }
    }
    public static void process(int[] array, int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R-L)>>1);
        process(array, L, mid);
        process(array, mid+1, R);
        merge(array, L, mid, R);
    }
    public static void merge(int[] array, int L, int mid, int R){
        int[] temp = new int[R-L+1];
        int i = 0; //index of temp
        int p = L; //the first unsorted element in left half
        int q = mid + 1; //the first unsorted element in right half

        while (p <= mid && q <= R){
            if (array[p] <= array[q]){
                temp[i++] = array[p++];
            } else {
                temp[i++] = array[q++];
            }
        }
        while (p <= mid){
            temp[i++] = array[p++];
        }
        while (q <= R){
            temp[i++] = array[q++];
        }
        for (i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
    }

}