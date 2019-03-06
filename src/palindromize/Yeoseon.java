package palindromize;


import java.util.Scanner;

public class Yeoseon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCase; i++) {
            String str = sc.nextLine().trim();
            int len = str.length();

            ///palindrome dp array
            boolean[][] d = new boolean[len][len];

            for (int x = 0; x < len; x++) {
                d[x][x] = true;
            }
            for (int x = 0; x < len - 1; x++) {
                if (str.charAt(x) == str.charAt(x + 1)) {
                    d[x][x + 1] = true;
                }
            }
            for (int y = 2; y < len; y++) {
                for (int x = 0; x < y - 1; x++) {
                    if (d[x + 1][y - 1] && str.charAt(x) == str.charAt(y)) {
                        d[x][y] = true;
                    }
                }
            }

            //find longest palindrome index
            int idx = len;
            for (int x = len - 1; x >= 0; x--) {
                if (d[x][len - 1]) {
                    idx = x;
                }
            }
            System.out.println(len + idx);
        }

    }
}