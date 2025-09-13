package leetcode.DFS_Binary_Trees.MaximumDepthOfBinaryTree_104;

/*104. 이진 트리의 최대 깊이 (Maximum Depth of Binary Tree)
난이도: 쉬움 (Easy)
주제: 트리, DFS, leetcode.BFS

이진 트리의 루트(root)가 주어질 때, 그 트리의 최대 깊이(maximum depth) 를 반환하세요.
이진 트리의 최대 깊이란 루트 노드에서 가장 멀리 있는 리프(leaf) 노드까지의 가장 긴 경로에 포함된 노드의 수를 의미합니다.

예시 1:
입력: root = [3,9,20,null,null,15,7]
출력: 3

예시 2:
입력: root = [1,null,2]
출력: 2

제약 조건

트리의 노드 개수는 [0, 10^4] 범위에 속합니다.
-100 <= Node.val <= 100*/
public class Solution {
    public int maxDepth(TreeNode root) {        // 15, 7   // 9, 20    // 3
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);         // 0        // 0, 1    // 1
        int right = maxDepth(root.right);       // 0        // 0, 1    // 2

        return 1 + Math.max(left, right);       // 1        // 1, 2    // 3
    }
}

