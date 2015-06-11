package LeetCode;


import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-3-15
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] > num[i - 1]) {

				int first = num[i];
				if (first > 0) break;
//				if (num [i+1] <= num[i]) continue; //?
				int k = i + 1;
				int j = num.length - 1;
				while (k < j) {
					if (num[k] + num[j] + first == 0) {
						List<Integer> result = new ArrayList<Integer>();
						result.add(first);
						result.add(num[k]);
						result.add(num[j]);
						results.add(result);
						k++;
						j--;
						while ( k < j && num[j] == num[j + 1]) {
							j--;
						}
						while (k < j && num[k] == num[k - 1]) {
							k++;
						}
					} else if (num[k] + num[j] + first > 0) {
						j--;
					} else if (num[k] + num[j] + first < 0) {
						k++;
					}
				}
			}
		}
		return results;
	}

	public List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length < 3) return result;
		// sort array
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			// //avoid duplicate solutions
			if (i == 0 || num[i] > num[i - 1]) {

				int negate = -num[i];

				int start = i + 1;
				int end = num.length - 1;

				while (start < end) {
					//case 1
					if (num[start] + num[end] == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[start]);
						temp.add(num[end]);

						result.add(temp);
						start++;
						end--;
						//avoid duplicate solutions
						while (start < end && num[end] == num[end + 1])
							end--;

						while (start < end && num[start] == num[start - 1])
							start++;
						//case 2
					} else if (num[start] + num[end] < negate) {
						start++;
						//case 3
					} else {
						end--;
					}
				}

			}
		}

		return result;
	}


	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] num = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> results = threeSum.threeSum(num);
		for (List<Integer> result : results) {
			for (Integer r : result) {
				System.out.print(r + " ");
			}
			System.out.println();
		}

	}

}
