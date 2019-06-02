package com.bittech.oj;
 /*
 * 判断以 p,q为根节点的两颗数我是否完全相同*/

public class TestIssameTree {
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if (p==null||q==null){
            return false;
        }
        if (p.val!=q.val){
           return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
