package web;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-8
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Arrays.sort(int[])使用的是快排，平均的时间复杂度是O( n lg(n))，在一般情况下已经足够好。那么有没有平均情况下O(n)复杂度的算法？
 * 这个还是有的，这道题目其实是选择算法的变形，选择一个数组中的第n 大元素，可以采用类似快排的方式划分数组，然后只要在一个子段做递归查找就可以，平均状况下可以做到O(n)的时间复杂度，对于这道题来说稍微变形下算法即可解决：
 *
 */
public class FindTopK {


    /**
     * 求数组的前n个元素
     *
     * @param anyOldOrderValues
     * @param n
     * @return
     */
    public static int[] findTopNValues(int[] anyOldOrderValues, int n) {
        int[] result = new int[n];
        findTopNValues(anyOldOrderValues, 0, anyOldOrderValues.length - 1, n,
                n, result);
        return result;
    }

    public static final void findTopNValues(int[] a, int p, int r, int i,
                                            int n, int[] result) {
        // 全部取到，直接返回
        if (i == 0) return;
        // 只剩一个元素，拷贝到目标数组
        if (p == r) {
            System.arraycopy(a, p, result, n - i, i);
            return;
        }
        int len = r - p + 1;
        if (i > len || i < 0)
            throw new IllegalArgumentException();
        // 划分
        int q = medPartition(a, p, r);
        // 计算右子段长度
        int k = r - q + 1;
        // 右子段长度恰好等于i
        if (i == k) {
        // 拷贝右子段到结果数组，返回
            System.arraycopy(a, q, result, n - i, i);
            return;
        } else if (k > i) {
            // 右子段比i长，递归到右子段求前i个元素
            findTopNValues(a, q + 1, r, i, n, result);
        } else {
            // 右子段比i短，拷贝右子段到结果数组，递归左子段求前i-k个元素
            System.arraycopy(a, q, result, n - i, k);
            findTopNValues(a, p, q - 1, i - k, n, result);
        }
    }

    public static int medPartition(int x[], int p, int r) {
        int len = r - p + 1;
        int m = p + (len >> 1);
        if (len > 7) {  //
            int l = p;
            int n = r;
            if (len > 40) { // Big arrays, pseudomedian of 9
                int s = len / 8;
                l = med3(x, l, l + s, l + 2 * s);
                m = med3(x, m - s, m, m + s);
                n = med3(x, n - 2 * s, n - s, n);
            }
            m = med3(x, l, m, n); // Mid-size, med of 3
        }
        if (m != r) {
            int temp = x[m];
            x[m] = x[r];
            x[r] = temp;
        }
        return partition(x, p, r);
    }

    private static int med3(int x[], int a, int b, int c) {
        return x[a] < x[b] ? (x[b] < x[c] ? b : x[a] < x[c] ? c : a)
                : x[b] > x[c] ? b : x[a] > x[c] ? c : a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int a[], int p, int r) {
        int x = a[r];
        int m = p - 1;
        int j = r;
        while (true) {
            do {
                j--;
            } while (j>=p&&a[j] > x);
            do {
                m++;
            } while (a[m] < x);

            if (j < m)
                break;
            swap(a, m, j);
        }
        swap(a, r, j + 1);
        return j + 1;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] result = findTopNValues(a, 3);
        for (Integer r : result) {
            System.out.println(r);
        }

    }
}
