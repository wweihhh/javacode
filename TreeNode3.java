package bin_tree.bin_search_tree.leetcodeoj;

import java.util.ArrayList;
import java.util.List;
/*中序遍历*/
public class TreeNode3 {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode3(int x) { val = x; }
  }


class Solution3 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;

    }
}
