import java.util.*;
class EvaluateReversePolishNotation {
    public static  int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")) stack.push(stack.pop()+stack.pop());
            else if(s.equals("-")) stack.push(-stack.pop()+stack.pop());
            else if(s.equals("*")) stack.push(stack.pop()*stack.pop());
            else if(s.equals("/")){
                int divs = stack.pop();
                int divd = stack.pop();
                stack.push(divd/divs);
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] s = new String[]{"1","2","3","-","*"};
        System.out.println(evalRPN(s));
    }
}