import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTree {
    //Iterative
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left!=null || curr.right!=null){
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right=temp;
            }
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
    }
    return root;
    }

    //Recursive
    public static TreeNode invertBT(TreeNode root){
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBT(root.left);
        invertBT(root.right);

        return root;

    }

}
