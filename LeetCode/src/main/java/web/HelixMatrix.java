package web;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-4-29
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */

/**
 * 螺旋矩阵
 */
public class HelixMatrix {

    /**
     *
     * @param matrix
     * @param x 起始点坐标偏移量x
     * @param y 起始点坐标偏移量y
     * @param start 起始点值
     * @param n 矩阵大小
     */
    public void setMatrixByRecur(int[][] matrix, int x, int y, int start, int n) {
        if (n <= 0) return;
        if (n == 1) {
            matrix[x][y] = start;
            return;
        }
        int i,j;
        //upper left to right
        for (i = x; i < x + n - 1; i++) {
            matrix[y][i] = start++;
        }
        //right high to low
        for (j = y; j < y + n -1; j++) {
            matrix[j][x + n - 1] = start++;
        }
        //down right to left
        for (i = x + n - 1; i > x; i--) {
            matrix[y + n - 1][i] = start++;
        }
        //left low to high
        for (j = y + n - 1; j > y; j--) {
            matrix[j][x] = start++;
        }
        setMatrixByRecur(matrix, x + 1, y + 1, start, n - 2);
    }

    public void SpiralArrayInner(int n, int[][] matrix) {
        int a = n/2 * 2 + 1; //保证边长为奇数
        int y = a/2, x = a/2; //从中心点开始
        for (int i = 1; i <= n*n; i++) {         //(int i=size*size;i>=1;i--)
            if (x<=a-y-1&&x>=y) {
                matrix[y][x] = i;
                x++;
            } else if (x>a-y-1&&x>y) {
                matrix[y][x] = i;
                y++;
            } else if (x>a-y-1&&x<=y) {
                matrix[y][x]=i;
                x--;
            } else if (x<=a-y-1&&x<y) {
                matrix[y][x]=i;
                y--;
            }
        }
    }

    public void SpiralArrayOuter(int n, int[][] matrix) {
        int a = n;
        int y=a/2,x=a/2;//从中心点开始
        for (int i=n*n;i>=1;i--)//(int i=1;i<=size*size;i++)
        {
            if (x<=a-y-1&&x>=y)
            {
                matrix[y][a-x-1]=i;
                x++;
            }
            else if (x>a-y-1&&x>y)
            {
                matrix[y][a-x-1]=i;
                y++;
            }
            else if (x>a-y-1&&x<=y)
            {
                matrix[y][a-x-1]=i;
                x--;
            }
            else if (x<=a-y-1&&x<y)
            {
                matrix[y][a-x-1]=i;
                y--;
            }
        }
    }


    public static void main(String[] args) {
        int dim = 20;
        int[][] a = new int[dim][dim];
        HelixMatrix helixMatrix = new HelixMatrix();
        helixMatrix.setMatrixByRecur(a, 0, 0, 1, dim);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        helixMatrix.SpiralArrayInner(dim, a);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        helixMatrix.SpiralArrayOuter(dim, a);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


    }
}
