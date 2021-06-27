package com.hanwenlong.code.dfs;

import com.hanwenlong.code.bfs.TreeNode;

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
public class LeetCode_111_2 {



//    static Queue<Integer> linkedList = new LinkedList<>();

    static List<Integer> list = new ArrayList<>();

    static Integer deep = 0;

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        getDeep(root);
        Collections.sort(list);
        return list.get(0);
    }

    private int getDeep(TreeNode root) {

        deep++;

        if ( null == root.left && null == root.right ) {
            list.add(deep);
            deep = 1;
        }

        if ( null != root.left ) {
            getDeep(root.left);
        }

        if ( null != root.right ) {
            getDeep(root.right);
        }

        return deep;
    }

    static Integer [] a = {2,null,3,null,4,null,5,null,6};

    //static Integer [] a = {3,9,20,null,null,15,7};

    //[0,2,4,1,null,3,-1,5,1,null,6,null,8]

    // [0,2,4,1,null,3,-1,5,1,null,6,null,8] 预期4

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(a[0]);
        //treeNode.left = new TreeNode(a[1]);
        treeNode.right = new TreeNode(a[2]);
        //treeNode.left.left = new TreeNode(a[3]);
        //treeNode.left.right = new TreeNode(a[4]);
        //treeNode.right.left = new TreeNode(a[5]);
        treeNode.right.right = new TreeNode(a[4]);
        //treeNode.right.right = new TreeNode(a[6]);
        treeNode.right.right.right = new TreeNode(a[6]);
        treeNode.right.right.right.right = new TreeNode(a[8]);
        //System.out.println(new LeetCode_111_1().minDepth(treeNode));
        System.out.println(new LeetCode_111_2().minDepth(treeNode));

//        System.out.println("---------------");
//        for (int a : list) {
//            System.out.println(a);
//        }

    }

}
