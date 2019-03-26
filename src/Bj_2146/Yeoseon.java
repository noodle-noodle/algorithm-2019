package Bj_2146;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yeoseon {

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] group = new int[n][n];
        int[][] d = new int[n][n];

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                a[x][y] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (a[x][y] == 1 && group[x][y] == 0) {
                    group[x][y] = ++cnt;
                    Queue<Point> q = new LinkedList<Point>();
                    q.add(new Point(x, y));
                    while (!q.isEmpty()) {
                        Point point = q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = point.x + dx[k];
                            int ny = point.y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                                    group[nx][ny] = cnt;
                                    q.add(new Point(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        for (int groupCnt = 1; groupCnt <= cnt; groupCnt++)
        {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (group[x][y] == cnt) {
                        d[x][y] = 0;
                        q.add(new Point(x, y));
                    } else if (group[x][y] == 0) {
                        d[x][y] = -1;
                    } else {
                        d[x][y] = -2;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Point point = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (d[nx][ny] == -2) {
                        ans = ans < d[point.x][point.y] ? ans : d[point.x][point.y];
                    } else if (d[nx][ny] == -1) {
                        q.add(new Point(nx, ny));
                        d[nx][ny] = d[point.x][point.y] + 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }

}