package leetcode.Stack.ValidParentheses_20;

import java.util.*;

/*20. 유효한 괄호 (Valid Parentheses)

난이도: 쉬움 (Easy)
주제: 스택, 문자열

문자열 s가 주어지며, 이 문자열은 '(', ')', '{', '}', '[', ']' 문자만 포함합니다.
입력된 문자열이 유효한 괄호 문자열인지 판단하세요.
문자열이 유효하려면 다음 조건을 만족해야 합니다:
열린 괄호는 같은 종류의 괄호로 닫혀야 한다.
열린 괄호는 올바른 순서로 닫혀야 한다.
닫는 괄호는 항상 대응되는 여는 괄호가 있어야 한다.

예시 1:
입력: s = "()"
출력: true

예시 2:
입력: s = "()[]{}"
출력: true

예시 3:
입력: s = "(]"
출력: false

예시 4:
입력: s = "([])"
출력: true

예시 5:
입력: s = "([)]"
출력: false

제약 조건

1 <= s.length <= 10^4

s는 '()[]{}' 괄호 문자만으로 이루어져 있다.*/
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && c == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}