package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DuplicatesArray {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 * Remove Duplicates from Sorted Array
	 * @param args
	 */

	public static void main(String[] args){
		int[] nums = new int[]{1,2,1,3,4,5,4};
		int result = algorithm(nums);

		System.out.println(result);
	}

	public static int algorithm(int[] nums){
		Set<String> tmp = new HashSet(nums.length);
		for (int item : nums) {
			tmp.add(item + "");
		}
		nums = new int[tmp.size()];
		int i = 0;
		for(String s : tmp){
			nums[i] = Integer.parseInt(s);
			i++;
		}
		System.out.print("[");
		String s = String.join(",", tmp);
		System.out.print(s);
		System.out.print("]");
		return tmp.size();
	}
}
