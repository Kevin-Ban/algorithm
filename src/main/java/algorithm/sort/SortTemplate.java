package algorithm.sort;

public abstract class SortTemplate {

    /**
     * 排序的模板方法
     *
     * @param a
     * @return
     */
    public abstract int[] sort(int[] a);

    public void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    public void sortAndPrint(int[] a) {
        int[] b = sort(a);
        print(b);
    }

    /**
     * a 小于 b 则为true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean lessThan(int a, int b) {
        return a < b;
    }

    /**
     * 交换元素位置
     *
     * @param a
     * @param firstIndex
     * @param secondIndex
     */
    public void swap(int[] a, int firstIndex, int secondIndex) {
        int tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }
}
