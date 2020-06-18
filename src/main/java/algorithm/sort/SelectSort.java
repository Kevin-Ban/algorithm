package algorithm.sort;

/**
 * 选择排序
 * 算法：
 * 1.将第一个数组元素当成最小值min
 * 2.遍历剩下的数组，如果发现有比min还小的元素，则将进行替换
 */
public class SelectSort extends SortTemplate {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] a = new int[]{2, 5, 6, 9, 1, 5, 7, 3};
        selectSort.sortAndPrint(a);
    }

    @Override
    public int[] sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            //记录最小值，默认是数组中的第一个元素
            //i是当前循环最小值的位置
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                //在遍历剩余的数组时，发现有其他值比原先的值还小时，将下标值替换
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //因为i是当前最小值的位置，所以应该把找到的最小值放到这个位置上
            int tmp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = tmp;
        }
        return a;
    }
}
