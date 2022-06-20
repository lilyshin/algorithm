package baekjoon.회문_17609;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int result = 0;

            int head = 0;
            int tail = word.length() - 1;

            while (head < tail) {
                if (word.charAt(head) == word.charAt(tail)) {
                    head++;
                    tail--;

                } else if (isPalindrome(word.substring(head, tail))) {
                    result = 1;
                    break;

                } else if (isPalindrome(word.substring(head + 1, tail + 1))) {
                    result = 1;
                    break;

                } else {
                    result = 2;
                    break;
                }
            }
            System.out.println(result);
        }

        br.close();
    }

    public boolean isPalindrome(String word) {
        int head = 0;
        int tail = word.length() - 1;

        while (head < tail) {
            if (word.charAt(head) == word.charAt(tail)) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }

}
