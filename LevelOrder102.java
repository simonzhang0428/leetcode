import java.util.ArrayList;
import java.util.List;

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res  = new ArrayList<>();
        if(root != null){
            dfs(res, root, 0);
        }
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode node, int level){
        if(res.size() - 1 < level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if(node.left!=null){
            dfs(res, node.left, level + 1);
        }
        if(node.right!=null){
            dfs(res, node.right, level + 1);
        }
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
public class LevelOrder102 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(null, null, 9);
        TreeNode left1 = new TreeNode(null, null, 15);
        TreeNode right1 = new TreeNode(null, null, 7);        
        TreeNode right = new TreeNode(left1, right1, 20);
        TreeNode root = new TreeNode(left, right, 3);
        System.out.println(new Solution102().levelOrder(root));
    }
}