import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DailyTemperature{
    public int[] dailyTemperatures(int[] temperatures) {

        int [] res = new int[temperatures.length];
        Arrays.fill(res,0);
        Stack<int[]> stack = new Stack<>();

        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                int [] popElement = stack.pop();
                int stackIndex = popElement[1];
                res[stackIndex]=i-stackIndex;

            }
            stack.push(new int[]{temperatures[i],i});
        }
        return res;
        
    }
}
class MonotonicMain{
    public static void main(String[] args) {
        DailyTemperature method = new DailyTemperature();
        System.out.println(Arrays.toString(method.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}