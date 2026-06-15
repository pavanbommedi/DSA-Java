public class DiameterTree {
    int diameter = 0;
    public int  diameterOfTree(TreeNode root){
        findDiameter(root);
        return diameter;
    }

    public int findDiameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        diameter = Math.max(left+right,diameter);

        return Math.max(left,right)+1; //Returning maximum height
    }

}
