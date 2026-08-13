import java.util.*;
public class EncodeAndDecodeStrings {

    public static String encode(List<String> strs) {
//        String s = "";
//
//        for (String str : strs) {
//            s += String.valueOf(str.length()) + "#" + str;
//        }
//
//        return s;
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            String b = str.substring(j + 1, j + 1 + len);

            res.add(b);

            i = j + len + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"Leet","4#Code","goo#d","resorc3e"};
        String s = encode(Arrays.stream(strs).toList());
        List<String> res = decode(s);
        System.out.println(res);
    }
}