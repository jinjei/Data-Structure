public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,1,2,1,0,2,2,1,0,0,2,1,1,2,2,0,0,1,2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int left = -1;
        int right = arr.length;
        int num = 1;
        int i = 0;
        while (i < right){
            if (arr[i] < num){
                swap(arr, i, left + 1);
                left++;
                i++;
            } else if (arr[i] == num) {
                i++;
            } else {
                swap(arr, i, right - 1);
                right--;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}