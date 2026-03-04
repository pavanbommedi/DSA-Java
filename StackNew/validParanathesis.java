import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParanathesis{
    public static void main(String[] args) {
        System.out.println(valid("({[]})"));

    }

    public static boolean valid(String s){
        Stack stack = new Stack<>();

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']', '[');

        for(int i=0;i<s.length();i++){ 
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(!stack.isEmpty() && stack.peek().equals(map.get(ch))){
                    stack.pop();
                }
                else return false;
            }
            else stack.push(ch);
        }
        if(stack.isEmpty()) return true; else return false;

        
    }
}