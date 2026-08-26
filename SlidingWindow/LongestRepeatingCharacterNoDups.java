import java.util.*;
class LongestRepeatingCharacterNoDups {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        char[] array = s.toCharArray();
        for(int j =0;j<array.length;j++){
            while(map.containsKey(array[j])){
                map.remove(array[left]);
                left++;
            }
            map.put(array[j],j);
            max=Math.max(max,j-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcdbdeasb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}