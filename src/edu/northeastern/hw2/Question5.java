package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.List;

public class Question5 {

    public static void main(String[] args) {
        Question5 question5 = new Question5();

        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> ans = question5.spiralMatrix(nums);
        ans.forEach(i -> System.out.print(i + " "));
    }

    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    private int dir = 0;

    public List<Integer> spiralMatrix(int[][] nums) {
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        int m = nums[0].length;

        int numSteps = n * m;
        int step = 0;

        int curX = 0;
        int curY = 0;

        boolean[][] visited = new boolean[n][m];

        while (step < numSteps) {
            ans.add(nums[curX][curY]);
            visited[curX][curY] = true;
            int[] next = getNextCoordinate(curX, curY, visited);
            curX = next[0];
            curY = next[1];
            step++;
        }

        return ans;
    }

    private int[] getNextCoordinate(int x, int y, boolean[][] visited) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (!isValid(nx, ny, visited) || visited[nx][ny]) {
            dir = (dir + 1) % 4;
            return new int[]{x + dx[dir], y + dy[dir]};
        } else {
            return new int[]{nx, ny};
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        return 0 <= x && x < visited.length && 0 <= y && y < visited[0].length;
    }
}
