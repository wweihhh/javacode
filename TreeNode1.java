package bin_tree.bin_search_tree.leetcodeoj;

public class TreeNode1 {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode1(int x) { val = x; }
  }
 
class Solution1 {
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        tree2Str(t,res);
        return res.toString();
    }

    private void tree2Str(TreeNode node,StringBuilder res){
        if(node == null){
            return ;
        }
        res.append(node.val);
        if(node.left !=null){
            res.append("(");
            tree2Str(node.left,res);
            res.append(")");
        }else {
            if(node.right != null){
                res.append("()");
            }
        }if(node.right != null){
            res.append("(");
            tree2Str(node.right,res);
            res.append(")");
        }
    }
}
