package algorithm;

public class SortArrayByParity {

    /**
     * https://leetcode.com/problems/sort-array-by-parity-ii/
     * @param args
     */
    public static void main(String[] args){
        int[] a = new int[]{ 1,1,1,2,2,2 };
        int[] b = sortArrayByParity(a);
        for (int i : b) {
            System.out.println(b[i]);
        }
    }

    public static int[] sortArrayByParity(int[] A){
        if(A == null || A.length == 0){
            return A;
        }
        int[] result = new int[A.length];
        int oddIndex = 1;
        int evenIndex = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                result[evenIndex] = A[i];
                evenIndex = evenIndex + 2;
            }
            else{
                result[oddIndex] = A[i];
                oddIndex = oddIndex + 2;
            }
        }
        return result;
    }
}


