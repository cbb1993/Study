package com.andy.study.数据结构和算法.二叉树;

/**
 * Created by 坎坎 on 2018/1/18.
 */

public class 二叉排序树 {

    private static TreeNode root;// 根结点
    private static int[] datas ={10,2,6,15,23,5,9,11}; //待存储的数据
    public static void main(String[] args){
        // 循环添加
        for (int i : datas) {
            put(i);
        }
           midOrderTraverse(root);
    }

   /**
   * 添加一个数据
   * */
    public static TreeNode put(int data) {
        // 如果根结点为空
        if (root == null) {
            TreeNode node = new TreeNode(data);
            root = node;
            return node;
        }

        TreeNode parent = null;
        TreeNode node = root;
        // 从根结点开始往下遍历 ，比当前结点小 查找左边  ，比当前结点大 查找右边  ，直到找出的空结点
        for(; node != null;) {
            parent = node;
            if (data < node.data) {
                node = node.leftChild;
            } else if(data > node.data) {
                node = node.rightChild;
            } else {
                return node;
            }
        }
        //创建存储当前数据的结点
        TreeNode newNode = new TreeNode(data);
        // 判断是加载左边还是右边
        if (data < parent.data) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
        // 赋值新结点的父结点
        newNode.parent = parent;
        return newNode;
    }

    /**
     * 前序排序
     * */
    public void preOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println("前序:" + root.data);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }
    /**
    * 中序排序
    * */
    public static void midOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        midOrderTraverse(root.leftChild);
        System.out.println("中序" + root.data);
        midOrderTraverse(root.rightChild);
    }
    /**
     * 后序排序
     * */
    public void postOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println("post order:" + root.data);
    }

    /**
    * 二叉排序树结点
    * */
   static class TreeNode{
        TreeNode parent; //父结点
        TreeNode leftChild; // 左子结点
        TreeNode rightChild; //右子结点
        int data;//存储数据
        public TreeNode(int data){
            this.data=data;
        }
    }
}
