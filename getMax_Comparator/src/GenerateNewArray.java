import java.util.Random;
public class GenerateNewArray {
    private int[] arr;
    private int maxSize;
    private int maxValue;

    GenerateNewArray(int maxSize, int maxValue){
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        arr = new int[maxSize];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue + 1);
        }
    }

    public int[] getArray(){
        return arr;
    }

}
