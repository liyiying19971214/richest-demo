package com.example.richest.text;


public class text {

    int maxLevel = -1;
    int sum = 0;


    public static void main(String[] args) {
        TreeNode  root=new TreeNode(3);
        growth(root,2);

        print(root);
    }

    static void print(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val);
        print(root.left);    //递归调用
        print(root.right);   //递归调用
    }

    private static void growth(TreeNode root, int deep) {
        if(deep==0) return;

        TreeNode left  = new TreeNode(deep);    //创建左子节点
        TreeNode right = new TreeNode(deep);    //创建右子节点

        root.left=left;
        root.right=right;

        growth(left,deep-1);    //递归调用
        growth(right,deep-1);   //递归调用
    }


    public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return sum;
        }

        public void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                sum = node.val;
            } else if (level == maxLevel) {
                sum += node.val;
            }
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }



        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

}
