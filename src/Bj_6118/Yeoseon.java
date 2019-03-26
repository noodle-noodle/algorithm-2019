package Bj_6118;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yeoseon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] graph = new boolean[N][N];
        int[] d = new int[N];

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from][to] = true;
            graph[to][from] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < N; i++) {
                if (graph[poll][i] && d[poll] == 0) {
                    d[poll] += 1;
                    q.add(i);
                }
            }
        }

        int num = 0;
        int dist = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (d[i] > dist) {
                dist = d[i];
                cnt++;
                num = i;
            } else if (d[i] == dist && d[i] != 0) {
                cnt++;
            }
        }
        System.out.println(num + ' ' + dist + ' ' + cnt);
    }

}