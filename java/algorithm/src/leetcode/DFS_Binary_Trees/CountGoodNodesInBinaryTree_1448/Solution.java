package leetcode.DFS_Binary_Trees.CountGoodNodesInBinaryTree_1448;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val); // 시작은 루트 값
    }

    // TODO ...............모르겠음
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        // 현재 노드가 good 인지 체크
        int good = (node.val >= maxSoFar) ? 1 : 0;

        // 지금까지 최댓값 갱신
        int newMax = Math.max(maxSoFar, node.val);

        // 왼쪽 + 오른쪽 + 현재
        return good + dfs(node.left, newMax) + dfs(node.right, newMax);
    }
}
