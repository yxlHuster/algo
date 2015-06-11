package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-3-15
 * Time: 下午7:42
 * To change this template use File | Settings | File Templates.
 */
public class ContainerMost {

	public int maxArea(int[] height) {
		int result = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
	   		result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
			if (height[i] > height[j]) {
				int k = j;
				while (k > i && height[k] <= height[j]) {
					k--;
				}
				j = k;
			}  else {
				int k = i;
				while ( k < j && height[k] <= height[i]) {
					k++;
				}
				i = k;
			}
		}
		return result;
	}

	public int maxArea2(int[] height) {
		int result = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		ContainerMost containerMost = new ContainerMost();
		int[] heighs = {1, 2, 3, 4, 5};
		System.out.println(containerMost.maxArea(heighs));
		System.out.println(containerMost.maxArea2(heighs));
	}
}
