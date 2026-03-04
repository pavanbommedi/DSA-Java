                                      import java.util.Stack;

public class RectangleHistogram{
    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max=0;
        for(int i = 0; i<heights.length;i++){
            int popCount = i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int area = (i-stack.peek()[0])*stack.peek()[1];
                max = Math.max(max,area);
                popCount=stack.peek()[0];

                stack.pop();

            }
            stack.push(new int[]{popCount,heights[i]});
        }
        while(!stack.isEmpty()){
            int area = (heights.length-stack.peek()[0])*stack.peek()[1];
            max = Math.max(area,max);
            stack.pop();
        }
        return max;
        
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));
    }
}
