package com.hanwenlong.code.dfs;

import com.hanwenlong.code.bfs.TreeNode;

public class leetCode_104 {

    public int maxDepth(TreeNode root) {

        if ( null == root ) {
            return 0;
        }

        if ( null == root.left && null == root.right ) {
            return 1;
        }
        int deep = 0;
        if (null != root.left) {
            deep = Math.max(maxDepth(root.left),deep);
        }

        if (null != root.right) {
            deep = Math.max(maxDepth(root.right),deep);
        }

        return deep+1;
    }


}
