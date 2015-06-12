package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-6-12
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * http://www.programcreek.com/2014/04/leetcode-surrounded-regions-java/
 */
public class SurroundedRegions {


    /**
     * deep first search
     *
     *
     * This solution causes java.lang.StackOverflowError, because for a large board, too many method calls are pushed to the stack and causes the overflow.
     *
     * @param board
     */
    public void solve(char[][] board) {
        if(board == null || board.length==0)
            return;

        int m = board.length;
        int n = board[0].length;

        //merge O's on left & right boarder
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                merge(board, i, 0);
            }

            if(board[i][n-1] == 'O'){
                merge(board, i,n-1);
            }
        }

        //merge O's on top & bottom boarder
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O'){
                merge(board, 0,j);
            }

            if(board[m-1][j] == 'O'){
                merge(board, m-1,j);
            }
        }

        //process the board
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void merge(char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;

        if(board[i][j] != 'O')
            return;

        board[i][j] = '#';

        merge(board, i-1, j);
        merge(board, i+1, j);
        merge(board, i, j-1);
        merge(board, i, j+1);
    }


    /**
     *
     *
     *
     *
     */

        // use a queue to do BFS
        private Queue<Integer> queue = new LinkedList<Integer>();

        public void solve2(char[][] board) {
            if (board == null || board.length == 0)
                return;

            int m = board.length;
            int n = board[0].length;

            // merge O's on left & right boarder
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    bfs(board, i, 0);
                }

                if (board[i][n - 1] == 'O') {
                    bfs(board, i, n - 1);
                }
            }

            // merge O's on top & bottom boarder
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') {
                    bfs(board, 0, j);
                }

                if (board[m - 1][j] == 'O') {
                    bfs(board, m - 1, j);
                }
            }

            // process the board
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void bfs(char[][] board, int i, int j) {
            int n = board[0].length;

            // fill current first and then its neighbors
            fillCell(board, i, j);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int x = cur / n;
                int y = cur % n;

                fillCell(board, x - 1, y);
                fillCell(board, x + 1, y);
                fillCell(board, x, y - 1);
                fillCell(board, x, y + 1);
            }
        }

        private void fillCell(char[][] board, int i, int j) {
            int m = board.length;
            int n = board[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
                return;

            // add current cell is queue & then process its neighbors in bfs
            queue.offer(i * n + j);
            board[i][j] = '#';
        }

}
