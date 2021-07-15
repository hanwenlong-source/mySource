package com.hanwenlong.code.bfs;

public class LeetCode_200 {

    public static void main(String[] args) {

        char [] [] a =
        {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','1'}
        };

        LeetCode_200 leetCode_200 = new LeetCode_200();

        System.out.println(leetCode_200.numIslands(a));

    }
    int x,y;
    public int numIslands(char[][] grid) {
        x=grid.length;
        y=grid[0].length;

        int result=0;
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                if (grid[i][j]=='1') {
                    result ++;
                    //开始扩散
                    bfs(grid,i,j);

                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int i, int j) {

        grid[i][j]='0';
        System.out.println("i="+i+"  j="+j);
        if (i>0 && grid[i-1][j]=='1') {
            bfs(grid,i-1,j);
        }

        if (i<x-1 && grid[i+1][j] =='1') {
            bfs(grid,i+1,j);
        }

        if (j>0 && grid[i][j-1]=='1') {
            bfs(grid,i,j-1);
        }

        if (j<y-1 && grid[i][j+1]=='1') {
            bfs(grid,i,j+1);
        }
    }
}
