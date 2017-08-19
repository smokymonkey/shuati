import LeetCode.TreeNode;

public class LC156 {
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        if(root.left==null)
            return root;
        else{
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;
            TreeNode rt = upsideDownBinaryTree(leftChild);
            leftChild.left = rightChild;
            leftChild.right=root;
            return rt;
        }

    }
    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        n1.left=n2;
        n1.right=n3;
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        n2.left=n4;
        n2.right=n5;
        TreeNode rt = upsideDownBinaryTree(n1);
    }
}


