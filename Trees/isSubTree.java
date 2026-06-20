

public class isSubTree {

    public boolean isSubTree(TreeNode root,TreeNode subRoot){
        if(subRoot == null) return true;
        if(root == null) return false;

        if(isSameTree(root,subRoot)){
            return true;
        }

        return(isSubTree(root.left,subRoot)||isSubTree(root.right,subRoot));
    }

    public boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null && t==null) return true;

        if(s==null||t==null) return false;

        if(s.val!=t.val) return false;

        return (isSameTree(s.left,t.left));

    }

}
