package leetcode.BFS_Binary_Trees.BinaryTreeRightSideView_199;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(root.val);

        return bfs(root, deque);
    }

    private List<Integer> bfs(TreeNode root, Deque<Integer> deque) {
        deque.push(root.right.val);
        deque.push(root.left.val);

        if (root.right != null) {
            deque.pop();
            bfs(root.right, deque);
        } else if (root.left != null) {
            bfs(root.left, deque);
        }
        return new ArrayList<>(deque);
    }
}