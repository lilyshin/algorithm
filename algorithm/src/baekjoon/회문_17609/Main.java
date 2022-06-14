package baekjoon.회문_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int result = isPalindrome(br.readLine());
            System.out.println(result);
        }

        br.close();
    }

    public int isPalindrome(String word) {
        int head = 0;
        int tail = word.length() - 1;

        int result = 0;

        while (head <= tail) {
            if (word.charAt(head) == word.charAt(tail)) {
                head++;
                tail--;

            } else {
                if (word.charAt(head + 1) == word.charAt(tail)) {
                    head++;

                } else if (word.charAt(tail - 1) == word.charAt(head)) {
                    tail--;

                } else {
                    return 2;
                }

                result = 1;
            }
        }

        return result;
    }
}
