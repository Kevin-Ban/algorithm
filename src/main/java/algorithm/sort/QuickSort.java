package algorithm.sort;

import java.util.HashSet;
import java.util.Set;

public class QuickSort extends SortTemplate {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        String s = "abcabcbb";
        sort.character(s);
    }

    public int character(String s) {
        int lastResult = 0;
        int result = 0;
        Set<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if (set.add(s.charAt(i))) {
                result++;
            } else {
                set.clear();
                set.add(s.charAt(i));
                lastResult = Math.max(lastResult, result);
                result = 1;
            }
        }
        return result;
    }

    @Override
    public int[] sort(int[] a) {
        return quickSort(a, 0, a.length - 1);
    }

    private int[] quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[j] > pivot) {
                j--;
            }
            while (i < j && arr[i] < pivot) {
                i++;
            }
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j + 1, end);
        }
        return arr;
    }

    private static void qSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        qSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        qSort(arr, right + 1, rightIndex);
    }
}
