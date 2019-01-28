package algorithm;

public class PlusOne {
	/**
	 * Plus One
	 * https://leetcode.com/problems/plus-one/
	 * @param args
	 */
	public static void main(String[] args){
		int[] tmp = new int[]{9,8,7,6,5,4,3,2,1,0};
		algorithm(tmp);
	}

	public static int[] algorithm(int[] digits){
		StringBuilder sb = new StringBuilder();
		for(int i : digits){
			sb.append(i);
		}
		Integer result = Integer.parseInt(sb.toString());
		result++;
		String[] tmp = (result + "").split("");
		int[] re = new int[tmp.length];
		for(int i = 0; i < tmp.length; i++){
			re[i] = Integer.parseInt(tmp[i]);
		}
		return re;
	}
}
