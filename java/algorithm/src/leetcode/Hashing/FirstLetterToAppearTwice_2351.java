package leetcode.Hashing;

import java.util.HashSet;

/*
    Problem:
    You are given a string s consisting of lowercase English letters.
    Return the first letter that appears twice.

    Definition:
    A letter a appears twice before another letter b if
    the index of the second occurrence of a is smaller than
    the index of the second occurrence of b.

    It is guaranteed that s contains at least one letter that appears twice.

    Example 1:
        Input:  s = "abccbaacz"
        Output: "c"
        Explanation:
            'a' → indices 0, 5, 6
            'b' → indices 1, 4
            'c' → indices 2, 3, 7
            'z' → index 8
            The second index of 'c' (3) is the smallest among all letters' second indices.

    Example 2:
        Input:  s = "abcdd"
        Output: "d"
        Explanation:
            The only letter that appears twice is 'd'.

    Constraints:
        2 <= s.length <= 100
        s consists of lowercase English letters.
        s has at least one repeated letter.
    문제:
    소문자 영어 알파벳으로만 이루어진 문자열 s가 주어집니다.
    가장 먼저 두 번 등장하는 문자(두 번째 등장 위치가 가장 작은 문자)를 반환하세요.

    정의:
    문자 a가 문자 b보다 먼저 두 번 등장한다는 뜻은
    a의 두 번째 등장 인덱스가 b의 두 번째 등장 인덱스보다 작다는 의미입니다.

    예시 1:
        입력:  s = "abccbaacz"
        출력: "c"
        설명:
            'a' → 인덱스 0, 5, 6
            'b' → 인덱스 1, 4
            'c' → 인덱스 2, 3, 7
            'z' → 인덱스 8
            'c'의 두 번째 인덱스(3)가 가장 작으므로 'c'가 정답입니다.

    예시 2:
        입력:  s = "abcdd"
        출력: "d"
        설명:
            두 번 등장하는 문자는 'd' 하나뿐입니다.

    제약:
        2 <= s.length <= 100
        s는 소문자 영어 알파벳으로만 구성됩니다.
        적어도 하나의 문자가 두 번 이상 등장합니다.
*/
public class FirstLetterToAppearTwice_2351 {

    public static void main(String[] args) {
        FirstLetterToAppearTwice_2351 sol = new FirstLetterToAppearTwice_2351();
        char result = sol.repeatedCharacter("abccbaacz");
        System.out.println("Result: " + result);
    }

    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        int index = 0;
        while (index < s.length()) {
            if (set.contains(s.charAt(index))) {
                break;
            } else {
                set.add(s.charAt(index));
                index++;
            }
        }
        return s.charAt(index);
    }
}
