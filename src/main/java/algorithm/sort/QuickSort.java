package algorithm.sort;

import java.util.HashSet;
import java.util.Set;

public class QuickSort extends SortTemplate {

    public static void main(String[] args) {
        SortTemplate sort = new QuickSort();
        int[] a = new int[]{1, 9, 4, 5, 7, 3, 1, 6, 2};
//        sort.sortAndPrint(a);
        ((QuickSort) sort).s(a, 0, a.length - 1);
        sort.print(a);
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
        //定义初始值
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            //在后半段找到比目标值小的数据
            while (i < j && arr[j] > pivot) {
                j--;
            }
            //在前半段找到比目标值小的数据
            while (i < j && arr[i] < pivot) {
                i++;
            }
            // 发现两个数相同时，不进行交换操作
            if (i < j && arr[i] == arr[j]) {
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

    private int[] s(int[] a, int start, int end) {
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
        if (i - 1 > start) {
            a = s(a, start, i - 1);
        }
        if (j + 1 < end) {
            a = s(a, j + 1, end);
        }
        return a;
    }
}
