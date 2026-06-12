import java.util.Queue;
import java.util.LinkedList;


public class BuildTree{
    public static void main(String[] args) {
        // 1 2 3 4 5 null 7 
        Integer[] arr = {1,2,3,4,5,null,7};
        Node root = buildTree(arr);
        display(root);

    }

    public static void display(Node root){
        if(root==null) return;

        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }

    public static Node buildTree(Integer[] arr){
        if(arr.length==0 || arr[0]==null){
            return null;
        }
        Queue<Node> queue  = new LinkedList<>();
        Node root = new Node(arr[0]);
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i<arr.length){
            Node curr = queue.poll();

            if(arr[i]!=null){
                curr.left = new Node(arr[i]);
                queue.add(curr.left); 
            }

            i+=1;

            if(i<arr.length && arr[i]!=null){
                curr.right = new Node(arr[i]);
                queue.add(curr.right);
            }
            i+=1;

        }
        return root;
    }
}n

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right =  null;
    }
}