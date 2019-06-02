package com.bittech.oj;

/*
* 判断是否是另一个树的子树*/
public class TreeNode2 {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode2(int x) { val = x; }
}

 class Solution2{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        if(s.val == t.val){
            if(isSameTree(s,t)){
                return true;
            }
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if (p == null||q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}


