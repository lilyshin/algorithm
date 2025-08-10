package leetcode.Hashing;

import java.util.HashSet;

/*
    Problem:
    You are given an array nums containing n distinct integers taken from the range [0, n].
    Return the single number in the range that is missing from nums.

    Example 1:
        Input:  nums = [3, 0, 1]
        Output: 2
        Explanation:
            n = 3 (length of nums), so numbers should be in [0, 3].
            2 does not appear in nums, so it is the missing number.

    Example 2:
        Input:  nums = [0, 1]
        Output: 2
        Explanation:
            n = 2 → range [0, 2]. The missing number is 2.

    Example 3:
        Input:  nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
        Output: 8
        Explanation:
            n = 9 → range [0, 9]. 8 is missing.

    Constraints:
        n == nums.length
        1 <= n <= 10^4 (typical constraints)
        0 <= nums[i] <= n
        All values in nums are distinct.
    문제:
    정수 배열 nums가 주어집니다. 길이가 n이며, 원소들은 [0, n] 범위의 서로 다른 정수입니다.
    이 범위 안에서 배열에 없는 단 하나의 숫자를 반환하세요.

    예시 1:
        입력:  nums = [3, 0, 1]
        출력: 2
        설명:  n = 3 → 범위 [0, 3]. 2가 배열에 없으므로 정답.

    예시 2:
        입력:  nums = [0, 1]
        출력: 2
        설명:  n = 2 → 범위 [0, 2]. 빠진 숫자는 2.

    예시 3:
        입력:  nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
        출력: 8
        설명:  n = 9 → 범위 [0, 9]. 8이 누락.

    제약:
        n == nums.length
        1 <= n <= 10^4 (일반적인 범위)
        0 <= nums[i] <= n
        nums의 값들은 모두 서로 다름.
*/
public class MissingNumber_268 {
    public static void main(String[] args) {
        MissingNumber_268 sol = new MissingNumber_268();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = sol.missingNumber(nums);
        System.out.println("Result: " + result);
    }


    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result = i;
            }
        }
        return result;
    }
}
