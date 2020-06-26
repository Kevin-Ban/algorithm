package algorithm.sort;

public class QuickSort extends SortTemplate {

    public static void main(String[] args) {
        int[] a = new int[]{2, 6, 4, 7, 8, 2, 1, 4, 5, 2, 9, 6};
        SortTemplate sortTemplate = new QuickSort();
        sortTemplate.sortAndPrint(a);
    }

    @Override
    public int[] sort(int[] a) {
        return quickSort(a, 0, a.length - 1);
    }

    private int[] quickSort(int[] a, int start, int end) {
        int mid = a[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[i] < mid) {
                i++;
            }
            while (i < j && a[j] > mid) {
                j--;
            }
            if (i < j && a[i] == a[j]) {
                i++;
            } else {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        //这里为什么是 i - 1 > start ?
        if (i - 1 > start) {
            quickSort(a, start, i - 1);
        }
        if (j + 1 < end) {
            quickSort(a, j + 1, end);
        }
        return a;
    }
}
