public class SameTree {

    public boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null && t==null) return true;

        if(s==null||t==null) return false;

        if(s.val!=t.val) return false;

        return (isSameTree(s.left,t.left));

    }

}
