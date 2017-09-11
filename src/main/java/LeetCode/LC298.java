package LeetCode;

/**
 * Created by jo0235 on 8/18/17.
 */

public class LC298 {
    int rt = 0;
    public int longestConsecutive(TreeNode root) {

         int last=helper(root);
         int result = Math.max(rt,last);
         return result;
    }
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left =helper(root.left);
        int right =helper(root.right);
        boolean cond1=root.left!=null && (root.left.val==root.val+1);
        boolean cond2=root.right!=null && (root.right.val==root.val+1);
        if(cond1 && cond2)
            return Math.max(left,right)+1;
        else if(cond1){
            rt=Math.max(rt,right);
            return 1+left;
        }else if(cond2){
            rt=Math.max(rt,left);
            return 1+right;
        }else{
            rt = Math.max(rt,Math.max(right,left));
            return 1;
        }

    }
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.right=node3;
        node3.left=node2;
        node3.right=node4;
        node4.right=node5;
        new LC298().longestConsecutive(node1);
    }
}
