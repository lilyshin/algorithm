package leetcode.DFS_Binary_Trees.PathSum_112;

/*112. 경로 합 (Path Sum)

난이도: 쉬움 (Easy)
주제: 트리, DFS, leetcode.BFS

이진 트리의 루트(root)와 정수 targetSum이 주어집니다.
루트에서 리프(leaf)까지 가는 경로 중에서, 경로 위의 모든 노드 값의 합이 targetSum과 같은 경로가 존재하면 true 를 반환하세요.
리프(leaf)는 자식이 없는 노드를 의미합니다.

예시 1:
입력: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
출력: true
설명: 루트에서 리프까지 합이 22가 되는 경로가 존재합니다.

예시 2:
입력: root = [1,2,3], targetSum = 5
출력: false
설명:

경로 (1 → 2)의 합 = 3
경로 (1 → 3)의 합 = 4
합이 5인 경로는 존재하지 않습니다.

예시 3:
입력: root = [], targetSum = 0
출력: false
설명: 트리가 비어 있으므로 루트에서 리프까지의 경로가 없습니다.

제약 조건
트리의 노드 개수는 [0, 5000] 범위에 속합니다.
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000*/
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 리프 노드에 도달했을 때 합이 targetSum과 같으면 true
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // 왼쪽 서브트리나 오른쪽 서브트리 중 하나라도 조건 만족하면 true
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}


