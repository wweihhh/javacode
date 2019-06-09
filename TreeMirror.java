package Day17;

public class TreeMirror {
    int val = 0;
    TreeMirror left = null;
    TreeMirror right = null;

    public TreeMirror(int val) {
        this.val = val;

    }

    public static void main(String[] args) {

    }

}
class Solution {
    public void Mirror(TreeMirror root) {
        if(root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }

        TreeMirror node = root.left;
        root.left = root.right;
        root.right = node;

        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }


}