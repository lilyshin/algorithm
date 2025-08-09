package leetcode.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/*
Problem:
    Given a string s, return true if s is a good string, otherwise return false.

    Definition:
    A string s is considered good if all characters that appear in s have the same number of occurrences (same frequency).

    Example 1:
        Input:  s = "abacbc"
        Output: true
        Explanation:
            Characters: 'a', 'b', 'c'
            Each occurs exactly 2 times → all equal → return true.

    Example 2:
        Input:  s = "aaabb"
        Output: false
        Explanation:
            'a' occurs 3 times, 'b' occurs 2 times → not equal → return false.

    Constraints:
        1 <= s.length <= 1000
        s consists of lowercase English letters.


문제:
    문자열 s가 주어질 때, s가 "좋은 문자열"인지 여부를 반환하세요.

    정의:
    문자열 s가 좋은 문자열이 되려면, 등장하는 모든 문자의 출현 횟수가 동일해야 합니다.

    예시 1:
        입력:  s = "abacbc"
        출력: true
        설명:
            문자 'a', 'b', 'c' 각각 2번씩 등장 → 동일하므로 true.

    예시 2:
        입력:  s = "aaabb"
        출력: false
        설명:
            'a'는 3번, 'b'는 2번 등장 → 다르므로 false.

    제약:
        1 <= s.length <= 1000
        s는 소문자 영어 알파벳으로만 구성됩니다.
*/

public class CheckifAllCharactersHaveEqualNumberofOccurrences_941 {
    public static void main(String[] args) {
        CheckifAllCharactersHaveEqualNumberofOccurrences_941 sol = new CheckifAllCharactersHaveEqualNumberofOccurrences_941();
        String s = "abacbc";
        boolean result = sol.areOccurrencesEqual(s);
        System.out.println("Result: " + result);
    }

    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int compareNum = map.values().iterator().next();
        for (int num : map.values()) {
            if (compareNum != num) {
                return false;
            }
        }
        return true;
    }
}
