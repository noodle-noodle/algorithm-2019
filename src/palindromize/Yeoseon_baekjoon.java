package palindromize;

import java.util.Scanner;

public class Yeoseon_baekjoon {

    //백준  팰린드롬
    //https://www.acmicpc.net/submit/10942
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        boolean[][] d = new boolean[len][len];

        for (int x = 0; x < len; x++) {
            d[x][x] = true;
        }
        for (int x = 0; x < len - 1; x++) {
            if (a[x] == a[x + 1]) {
                d[x][x + 1] = true;
            }
        }
        for (int y = 2; y < len; y++) {
            for (int x = 0; x < y - 1; x++) {
                if (d[x + 1][y - 1] && a[x] == a[y]) {
                    d[x][y] = true;
                }
            }
        }
        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (d[x - 1][y - 1]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}
