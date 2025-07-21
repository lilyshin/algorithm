# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# Example 1:
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

# Example 2:
# Input: nums = [3,2,4], target = 6
# Output: [1,2]

# Example 3:
# Input: nums = [3,3], target = 6
# Output: [0,1]
 
# Constraints:
# 2 <= nums.length <= 104
# -109 <= nums[i] <= 109
# -109 <= target <= 109
# Only one valid answer exists.

def twoSum(nums, target):
    for i in range(len(nums)):
        result = target - nums[i]
        if result in nums[i+1:]:
            return [i, nums.index(result, i+1)]

def twoSum_ai(nums, target):
    # dictrionary
    num_map = {}
    # enumerate: 리스트(또는 반복 가능한 객체)를 반복할 때, 인덱스와 값을 동시에 얻을 수 있게 해주는 내장 함수
    # i=0, num=2
    # i=1, num=7
    # i=2, num=11
    for i, num in enumerate(nums):
        # 7 = 9 - 2
        # 2 = 9 - 7
        complement = target - num
        if complement in num_map:
            # 0, 1
            return [num_map[complement], i]
         # num_map = {2: 0}
        num_map[num] = i

# 시간복잡도: O(n²)
# nums[i+1:]로 슬라이싱 → O(n)
# nums.index(result, i+1)도 내부적으로 O(n)
# 전체적으로 이중 반복문과 비슷한 성능
# 입력이 커질수록(리스트가 길어질수록) 느려진다.

# 시간복잡도: O(n)
# 한 번의 반복문으로 해결
# 딕셔너리의 탐색/삽입은 평균적으로 O(1)
