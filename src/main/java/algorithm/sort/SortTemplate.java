package algorithm.sort;

public abstract class SortTemplate {

    abstract int[] sort(int[] a);

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
}
