package LeetCode;
import java.util.*;
public class LC366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<TreeNode>> rt = new ArrayList<>();
        Map<TreeNode,Integer> child =new HashMap<>();
        Map<TreeNode, TreeNode>parent = new HashMap<>();
        if(root==null) return new ArrayList<>();
        rt.add(new ArrayList<>());
        scan(root,child,parent,rt.get(rt.size()-1));
        while(!child.isEmpty()){
            List<TreeNode> lastLevel = rt.get(rt.size()-1);
            rt.add(new ArrayList<>());
            List<TreeNode> newLevel = rt.get(rt.size()-1);
            for(TreeNode tn:lastLevel){
                TreeNode p=parent.get(tn);
                child.put(p,child.get(p)-1);
                if(child.get(p)==0){
                    newLevel.add(p);
                    child.remove(p);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<TreeNode> l:rt){
            List<Integer> tmp = new ArrayList<>();
            for(TreeNode tn:l)
                tmp.add(tn.val);
            result.add(tmp);
        }
        return result;
    }

    public void scan(TreeNode root, Map<TreeNode,Integer> child , Map<TreeNode,TreeNode> parent,List<TreeNode> rt ){
        if(root.left==null && root.right==null)
            rt.add(root);
        else{
            if(!child.containsKey(root))
                child.put(root,0);
            if(root.left!=null){
                child.put(root,child.get(root)+1);
                parent.put(root.left,root);
            }
            if(root.right!=null){
                child.put(root,child.get(root)+1);
                parent.put(root.right,root);
            }
        }
    }
}
