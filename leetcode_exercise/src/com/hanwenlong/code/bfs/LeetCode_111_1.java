package com.hanwenlong.code.bfs;

import java.util.*;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 */
public class LeetCode_111_1 {

    static Integer [] a = {2,null,3,null,4,null,5,null,6};
    //Integer [] a = {3,9,20,null,null,15,7};
//    static Queue<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {

        //TreeNode treeNode = new TreeNode(a[0]);
        //treeNode.left = new TreeNode(a[1]);
        //treeNode.right = new TreeNode(a[2]);
        //treeNode.left.left = new TreeNode(a[3]);
        //treeNode.left.right = new TreeNode(a[4]);
        //treeNode.right.left = new TreeNode(a[5]);
        //treeNode.right.right = new TreeNode(a[4]);
        //treeNode.right.right.right = new TreeNode(a[6]);
        //treeNode.right.right.right.right = new TreeNode(a[8]);
        System.out.println(new LeetCode_111_1().minDepth(null));





    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>(); // 核心数据结构

        //起点树尖加入到队列
        q.offer(root);
        int step = 1;

        while (!q.isEmpty()) {

            int sz = q.size();

            for (int i = 0; i < sz; i++) {

                TreeNode cur = q.poll();
                //System.out.println(cur);
                if (null == cur.left && null == cur.right) {
                    return step;
                }
                if ( null != cur.left) {
                    q.offer(cur.left);
                }
                if ( null != cur.right) {
                    q.offer(cur.right);
                }

            }
            step++;
        }
        return 0;
    }

    //        for (Integer aa : a) {
//            linkedList.offer(aa);
//        }
//        TreeNode treeNode = null;
//        treeNode = new LeetCode_111().getTreeNode(treeNode);
//
//        while (!linkedList.isEmpty()) {
//
//        }
//
//        for (Integer bb : linkedList) {
//            System.out.println(bb);
//        }

    //    public TreeNode getTreeNode (TreeNode treeNode) {
//        Integer poll = linkedList.poll();
//        if (null != poll) {
//            treeNode = new TreeNode();
//            treeNode.val = poll;
//        }
//        getTreeNode(treeNode.left);
//        getTreeNode(treeNode.right);
//
//        return treeNode;
//    }

}
