package leet_code_problems.easy;
import leet_code_problems.TreeNode;
import java.util.ArrayList;
import java.util.List;
    public class Problem94 {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> lst = inorderTraversal(root.left);
            List<Integer> ans = new ArrayList<>(lst);
            ans.add(root.val);
            List<Integer> rst = inorderTraversal(root.right);
            ans.addAll(rst);
            return ans;
        }
    }
