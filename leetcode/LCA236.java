package leetcode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // step 1: ask for a value from my left and right, respective
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        // step 2 + 3: what should we do in the current level
        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode == null ? rightNode : leftNode;
        
        // if (leftNode == null) {
        //     return rightNode;
        // } else {
        //     return leftNode;
        // }

        // if (leftNode == null && rightNode == null) {
        //     return null;
        // }
        // if (leftNode == null) {
        //     return rightNode;
        // }
        // if (rightNode == null) {
        //     return leftNode;
        // }

        

    }
}

public class LCA236 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(null, null, 9);
        TreeNode left1 = new TreeNode(null, null, 15);
        TreeNode right1 = new TreeNode(null, null, 7);
        TreeNode right = new TreeNode(left1, right1, 20);
        TreeNode root = new TreeNode(left, right, 3);
        TreeNode solu = new Solution236().lowestCommonAncestor(root, left1, right1);
        System.out.println("20: " + solu.val);

        /*
        Follow up: what if either a or b might NOT be in the tree
        if (solu == null) {
            return null;
        } else if (solu != a && solu != b) {
            return solu; // return c, a&b不是隶属关系
        } else {
            // a和b直接隶属，在a的下面找b
            if (solu == a) {
                return lowestCommon(a, b, b) == null ? null : a;
            }
            return lowestCommon(b, a, a) == null ? null : b;
        }
        */

    }
}