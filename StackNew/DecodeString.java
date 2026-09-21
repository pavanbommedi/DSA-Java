import java.util.*;

class DecodeString {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Normal character or '['
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            }

            else {
                // Build substring inside []
                StringBuilder subStr = new StringBuilder();

                while (!stack.peek().equals("[")) {
                    subStr.insert(0, stack.pop());
                }

                // Remove '['
                stack.pop();

                // Build number
                StringBuilder number = new StringBuilder();

                while (!stack.isEmpty() &&
                        stack.peek().matches("\\d")) {
                    number.insert(0, stack.pop());
                }

                int k = Integer.parseInt(number.toString());

                // Repeat substring
                StringBuilder decoded = new StringBuilder();

                for (int j = 0; j < k; j++) {
                    decoded.append(subStr);
                }

                stack.push(decoded.toString());
            }
        }

        // Combine everything remaining in stack
        StringBuilder result = new StringBuilder();

        for (String str : stack) {
            result.append(str);
        }

        return result.toString();
    }
}