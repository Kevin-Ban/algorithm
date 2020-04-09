package other.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 6, 9, 4, 8};
        array = bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] bubbleSort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
