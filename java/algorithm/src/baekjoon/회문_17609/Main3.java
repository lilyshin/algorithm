package baekjoon.회문_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        Main3 main = new Main3();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println(isPalindrome(br.readLine()));
        }

        br.close();
    }

    // 반례 :
    // 1
    // baaba
    // FIXME 시간초과
    public int isPalindrome(String word) {
        int head = 0;
        int tail = word.length() - 1;

        int result = 0;

        while (head <= tail) {
            if (word.charAt(head) == word.charAt(tail)) {
                head++;
                tail--;

            } else {
                while (head < tail - 1) {
                    if (word.charAt(head) == word.charAt(tail - 1)) {
                        head++;
                        tail--;
                    } else {

                        while (head + 1 < tail) {
                            if (word.charAt(head + 1) == word.charAt(tail)) {
                                head++;
                                tail--;
                            } else {
                                return 2;
                            }
                        }

                        return 1;
                    }
                }
            }
        }

        return result;
    }
}
