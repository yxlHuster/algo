package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-11
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */

/**
 * 1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
 2) If m1 and m2 both are equal then we are done, and return m1 (or m2)
 3) If m1 is greater than m2, then median is present in one of the below two subarrays.
 a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
 b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
 4) If m2 is greater than m1, then median is present in one of the below two subarrays.
 a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
 b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
 5) Repeat the above process until size of both the subarrays becomes 2.
 6) If size of the two arrays is 2 then use below formula to get the median.
 Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
 */
public class TwoMedia {

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) / 2;
		}
	}

	private int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		if (aLen == 0) return B[bStart + k];
		if (bLen == 0) return A[aStart + k];
		if (k == 0) return Math.min(A[aStart], B[bStart]);

		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	public static void main(String[] args) {
		TwoMedia twoMedia = new TwoMedia();
		int[] A = {};
		int[] B = {2,3};
		System.out.println(twoMedia.findMedianSortedArrays(A, B));
	}
}


