package leetcode.Sliding_Window.longest_subarray_sum_le_k;

/*
Problem:
    Given an array of positive integers nums and an integer k,
    find the length of the longest subarray whose sum is less than or equal to k.

    입력: nums = [1, 2, 3, 4, 5], k = 9
    출력: 3
    설명: [2, 3, 4]의 합은 9이고, 길이는 3으로 가장 깁니다.
*/
public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        int result = sol.longestSubarray(nums, k);
        System.out.println(result);
    }

    public int longestSubarray(int[] nums, int k) {
        int start = 0, end, result = 0;
        int sum = 0;

        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            System.out.println("start = " + start + ", end = " + end + ", sum = " + sum);

            while (sum > k) {
                sum -= nums[start];
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        System.out.println("result = " + result);
        return result;
    }

    // before
    /*public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            start = nums[i];      // 0
            for (int j = i + 1; j < n; j++) {
                end = nums[j];    // 1
                int sum = start + end;
                if (sum >= k) {
                    result = sum;
                    break;
                }
            }
        }
        return result;
    }*/
}