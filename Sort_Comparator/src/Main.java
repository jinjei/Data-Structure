import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;


        for (int i = 0; i < testTime; i++) {
            GenerateRandomArray generator = new GenerateRandomArray(maxSize,maxValue);

            int[] arr1 = generator.getArray();

            int[] arr2 = copyArr(arr1);

            selectionSort(arr1);

            insertSort(arr2);

            if (!isEqual(arr1, arr2)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Damn");

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] copyArr(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        int[] copiedArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copiedArray[i] = arr[i];
        }
        return copiedArray;
    }
    public static boolean isEqual(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }


    //选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++){ //i ~ N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){ //i ~ N-1 最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }


    //插入排序
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j+1] < arr[j]; j--){
                swap(arr, j, j + 1);
            }
        }
    }
}