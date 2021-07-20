package leetcode;
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

class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        int rootVal = nums[middle];
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(nums, left, middle - 1);
        root.right = buildTree(nums, middle + 1, right);
        return root;
    }
}


public class SortedArrayToBST108 {
    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9};
        TreeNode root = new Solution108().sortedArrayToBST(nums);
        System.out.println(new Solution102().levelOrder(root));
    }
}