package algorithm.sort;

/**
 * 冒泡排序
 * 算法：通过将相邻的元素进行比较，如果前面的大于后面的，则交换位置，每次循环完毕，都会将循环内的最大值移到最后面
 */
public class BubbleSort extends SortTemplate {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = new int[]{12, 5, 10, 9, 1, 5, 7, 3};
        bubbleSort.print(a);
        bubbleSort.sortAndPrint(a);
    }

    @Override
    public int[] sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                //将元素往后移动，第一次循环结束之后，最大的元素将会被放在最后面
                if (lessThan(a[j + 1], a[j])) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }
}
