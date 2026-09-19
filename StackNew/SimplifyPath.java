import java.util.;
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : str){
            if(s.equals("") || s.equals(".")) continue;
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(s);
        }
        StringBuilder res = new StringBuilder();

        for(String ele : stack) {
            res.append("/").append(ele);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}
