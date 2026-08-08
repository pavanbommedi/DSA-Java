public class LongestCommonPrefix{
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1; i<strs.length;i++){
            int j =0;
            while(j<prefix.length() && j<strs[i].length() &&
                    prefix.charAt(j)==strs[i].charAt(j)) j++;
            prefix = prefix.substring(0,j);
            if(prefix.isEmpty()) return "";
        }
        return prefix;

        // if(strs.length==1) return strs[0];
        // String s = strs[0];
        // boolean flag = false;
        // int i = 1;
        // while(i<strs.length){
        //     String com = "";
        //     int n = Math.min(strs[i].length(),s.length());
        //     for(int j = 0 ;j<n;j++){
        //         if(s.charAt(j)==strs[i].charAt(j)){
        //             com+=strs[i].charAt(j);
        //             flag = true;

        //         }
        //         else break;
        //     }
        //     if(s.length()>com.length()) s = com;
        //     i++;
        // }
        // if(flag) return s;
        // else return "";


    }
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }
}