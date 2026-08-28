import java.util.*;
public class PermutationsInString{
        //Time - O(26*n)
//        public static boolean checkInclusion(String s1, String s2) {
//            int[] ref = new int[26];
//            char[] s1Array = s1.toCharArray();
//            for(char ch:s1Array) ref[ch-'a']++;
//            int[] freq = new int[26];
//            int left =0;
//            for(int right = 0;right<s2.length();right++){
//                freq[s2.charAt(right)-'a']++;
//                while((right-left+1)>s1.length()){
//                    freq[s2.charAt(left)-'a']--;
//                    left++;
//                }
//                if(Arrays.equals(freq,ref)) return true;
//            }
//            return false;
//        }
        //O(n) solution
        public static boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;

            int[] ref = new int[26];
            int[] freq = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                ref[s1.charAt(i) - 'a']++;
                freq[s2.charAt(i) - 'a']++;
            }

            int matches = 0;
            for (int i = 0; i < 26; i++) {
                if (ref[i] == freq[i]) matches++;
            }

            int left = 0;
            for (int right = s1.length(); right < s2.length(); right++) {
                if (matches == 26) return true;

                // Add right character
                int index = s2.charAt(right) - 'a';
                freq[index]++;
                if (freq[index] == ref[index]) matches++;
                else if (freq[index] == ref[index] + 1) matches--;

                // Remove left character
                index = s2.charAt(left) - 'a';
                freq[index]--;
                if (freq[index] == ref[index]) matches++;
                else if (freq[index] == ref[index] - 1) matches--;

                left++;
            }

            return matches == 26;
        }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidabooo"));
    }
}