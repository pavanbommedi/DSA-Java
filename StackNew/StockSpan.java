import java.util.*;
public class StockSpan {
    private Stack<int[]> stack;
    private int day;
    public StockSpan() {
        stack = new Stack<>();
        day =0;
    }

    public int next(int price) {
        while(!stack.isEmpty() && stack.peek()[1]<=price){
            stack.pop();
        }
        int span;
        if(!stack.isEmpty()) span = day - stack.peek()[0];
        else span = day +1;
        stack.push(new int[]{day,price});
        day++;
        return span;
    }
}
