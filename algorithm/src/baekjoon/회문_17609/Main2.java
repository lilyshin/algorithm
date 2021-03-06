package baekjoon.회문_17609;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Main2 main = new Main2();
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
    // FIXME 메모리 초과
    public int isPalindrome(String word) {
        int head = 0;
        int tail = word.length() - 1;

        int result = 0;

        while (head < tail) {
            if (word.charAt(head) == word.charAt(tail)) {
                head++;
                tail--;

            } else {
                if (isPalindrome(word.substring(head, tail)) == 0) {
                    return 1;
                } else {
                    if ((head + 1) != tail && word.charAt(head + 1) == word.charAt(tail)) {
                        head++;

                    } else if (head != (tail - 1) && word.charAt(tail - 1) == word.charAt(head)) {
                        tail--;

                    } else {
                        return 2;
                    }

                    result = 1;
                }
            }
        }
        return result;
    }
}
