public class Main {
    public static void main(String[] args) {

        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        //method test
        for (int i = 0; i < testTime; i++) {
            GenerateNewArray generator = new GenerateNewArray(maxSize, maxValue);
            int[] randomArr = generator.getArray();

            int max1 = process(randomArr, 0, randomArr.length - 1);
            int max2 = getMax(randomArr);

            if (max1 != max2){
                succeed = false;
            }
        }

        //result
        if (succeed)
            System.out.println("Nice");
        else
            System.out.println("Damn");

    }

    //method need to be tested
    public static int process(int[] arr, int left, int right){
        if (left == right){
            return arr[left];
        }
        int mid = left + ((right - left)>>1);
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

}