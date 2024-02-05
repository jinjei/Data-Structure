
public class GenerateRandomArray {
    private int[] arr;
    private int maxSize, maxValue;
    GenerateRandomArray(int maxSize, int maxValue){
        this.maxSize = maxSize;
        this.maxValue = maxSize;
        arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue* Math.random());
        }
    }
    public int[] getArray(){
        return arr;
    }
}
