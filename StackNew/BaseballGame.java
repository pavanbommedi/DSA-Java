import java.util.Stack;

class BaseballGame {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (String op : operations) {
            if (op.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first); // Put the first one back

                int newScore = first + second;
                stack.push(newScore);
                sum += newScore;
            }
            else if (op.equals("C")) {
                sum -= stack.pop();
            }
            else if (op.equals("D")) {
                int x = stack.peek();
                stack.push(2 * x);
                sum += (2 * x);
            }
            else {
                // If it is not +, C, or D, it must be a integer string (e.g., "5" or "-2")
                int value = Integer.parseInt(op);
                stack.push(value);
                sum += value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"-1","2","5","+","C","D"};
        System.out.println(calPoints(operations));
    }
}