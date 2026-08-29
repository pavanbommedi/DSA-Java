import java.util.*;
class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t == null || t.isEmpty()) return "";
        if(t.length()>s.length()) return "";
        Map<Character,Integer> tmap = new HashMap<>();
        Map<Character,Integer> window= new HashMap<>();
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        int resStart = -1;
        int resEnd = -1;
        int resLen = Integer.MAX_VALUE;
        int need = tmap.size();
        int have =0;
        int left =0;
        int right =0;
        while(right<s.length()){
            char chR = s.charAt(right);
            if(tmap.containsKey(chR)){
                window.put(chR,window.getOrDefault(chR,0)+1);
                if(window.get(chR).equals(tmap.get(chR))) have+=1;
            }
            while(have == need){
                if(resLen>right-left+1){
                    resStart = left;
                    resEnd = right;
                    resLen = right-left+1;
                }
                char chL = s.charAt(left);
                if(window.containsKey(chL)){
                    window.put(chL,window.get(chL)-1);
                    if(tmap.get(chL)>window.get(chL)) have-=1;
                }
                left++;
            }
            right++;
        }
        return (resLen!=Integer.MAX_VALUE)?
                s.substring(resStart,resEnd+1):"";

    }

    public static void main(String[] args) {
        String s = "abcdedgshehe";
        String t = "sdh";
        System.out.println(minWindow(s,t));
    }
}