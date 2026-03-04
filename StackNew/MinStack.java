import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        stack= new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int val){
        stack.push(val);
        val = Math.min(val, minStack.isEmpty()?val:minStack.peek());
        minStack.push(val);

    }

    public void pop(){
        stack.pop();
        minStack.pop();

    }

    public int top(){
        return stack.peek();

    }

    public int getMin(){
        return minStack.peek();

    }
    

}

class Main{
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }
}