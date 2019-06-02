package com.bittech.oj;

/* 树的最大深度*/
public class TreeNode4 {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode4(int x) { val = x; }
}
class Solution4 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxDepth=Math.max(maxDepth(root.left),maxDepth(root.right));
        return maxDepth+1;
    }
}
