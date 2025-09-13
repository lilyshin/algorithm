package leetcode.Sliding_Window.longest_ones_after_one_flip;

/*
Problem:
    You are given a binary string s (a string containing only "0" and "1").
    You may choose up to one "0" and flip it to a "1".
    What is the length of the longest substring achievable that contains only "1"?

    이진 문자열 s가 주어집니다. (문자열은 오직 '0'과 '1'로만 이루어져 있습니다)
    당신은 최대 한 개의 '0'을 '1'로 바꿀 수 있습니다.
    이때, 오직 '1'로만 이루어진 가장 긴 연속 부분 문자열의 길이를 구하세요.

    입력: s = "1101101"
    출력: 5
    설명: 세 번째 '0'을 '1'로 바꾸면 "1111101"이 되고, 가장 긴 '1'의 연속 부분 문자열은 "11111"로 길이는 5입니다.
*/
public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("1101101");
    }

    public int solution(String input) {
        int start, end, sum = 0;
        return 0;
    }
}
