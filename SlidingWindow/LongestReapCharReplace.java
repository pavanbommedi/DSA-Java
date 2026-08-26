import java.util.*;
class LongestReapCharReplace {
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        Arrays.fill(freq,0);
        int res =0;
        char[] nums = s.toCharArray();
        for(int right=0;right<nums.length;right++){
            freq[nums[right]-'A']++;
            while((right-left+1)-findMax(freq)>k){
                freq[nums[left]-'A']--;
                left++;
            }
            res = Math.max(res,right-left+1);

        }
        return res;

    }
    public static int findMax(int[] freq){
        int max =0;
        for(int n:freq) max = Math.max(max,n);
        return max;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.println(characterReplacement(s,1));
    }
}