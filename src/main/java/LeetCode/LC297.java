package LeetCode;

/**
 * Created by jie on 7/23/17.
 */
import java.util.*;
public class LC297 {
    public static String serialize(TreeNode root) {
        StringBuilder sb =new StringBuilder();
        helper(root,"-1",0,sb);
        return sb.toString().substring(1);
    }
    public static int helper(TreeNode root, String parentIndex, int nextIndex,StringBuilder sb){
        if(root!=null){
            sb.append(',');
            sb.append(parentIndex);
            sb.append('/');
            sb.append(nextIndex);
            sb.append('/');
            sb.append(root.val);
            int rightStartIndex = helper(root.left,String.valueOf(nextIndex)+"L",nextIndex+1,sb);
            int rightEndIndex = helper(root.right,String.valueOf(nextIndex)+"R",rightStartIndex,sb);
            return rightEndIndex;
        }
        else
            return nextIndex;

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Map<Integer, TreeNode> m =new HashMap<>();
        if(data.equals("")) return null;
        String[] d = data.split(",");
        TreeNode rt =null;
        for(int i=0;i<d.length;i++){
            int slash=d[i].indexOf("/");
            int nodeIndex = Integer.valueOf(d[i].substring(0,slash));
            int nodeVal = Integer.valueOf(d[i].substring(slash+1,d[i].length()));
            if(nodeIndex==0){
                rt=new TreeNode(nodeVal);
                m.put(nodeIndex,rt);
            }else{
                int parentIdx = (nodeIndex-1)/2;
                TreeNode node = new TreeNode(nodeVal);
                if(nodeIndex%2==1)
                    m.get(parentIdx).left=node;
                else
                    m.get(parentIdx).right=node;
                m.put(nodeIndex,node);
            }

        }
        return rt;
    }

    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode parent=n1;
        for(int i=2;i<=40;i++){
            TreeNode child = new TreeNode(i);
            parent.right=child;
            parent=child;
        }

        deserialize(serialize(n1));
    }
}
