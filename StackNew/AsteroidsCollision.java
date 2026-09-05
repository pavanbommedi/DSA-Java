import java.lang.reflect.Array;
import java.util.*;
class AsteroidsCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int n:asteroids){
            if(n>0) stack.push(n);
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(n)){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek()==Math.abs(n)){
                    stack.pop();
                    continue;
                }
                if(!stack.isEmpty() && stack.peek()>Math.abs(n)) continue;
                stack.push(n);
            }
        }
        int[] res = new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            res[i]=stack.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,3,-4,6,-4};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}