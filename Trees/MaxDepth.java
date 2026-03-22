import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class MaxDepth {
    //Iterative BFS
    //Time - O(n) every node  Space- O(n) - max node at level
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cn=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            cn+=1;
        }
        return cn;
    }
    //Recursive DFS
    //Time - O(n) Space -O(log n)
    public int maxDepthDFS(TreeNode root) {
    if(root == null) return 0;
    return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)); //Preferred
}
    //Iterative DFS
    //Time - O(n) Space- O(log n)
     public int maxDepthIterativeDFS(TreeNode root) {
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root,1});
        int res=0;
        while(!stack.isEmpty()){
            Object[] obj = stack.pop();
            TreeNode node =(TreeNode) obj[0];
            int depth = (int) obj[1];
            if(node!=null){
                res = Math.max(res,depth);
                stack.push(new Object[]{node.left,depth+1});
                stack.push(new Object[]{node.right,depth+1});
            }
        }
        return res;
    }

}
