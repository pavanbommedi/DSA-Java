public class ValidAnagarams{
    public static boolean isAnagram(String s, String t) {
        //linear space and linear time

        // Map<Character,Integer> map = new HashMap<>();
        // char[] chArrayS = s.toCharArray();
        // char[] chArrayT = t.toCharArray();

        // for(char ch : chArrayS){
        //     if(!map.containsKey(ch)) map.put(ch,1);
        //     else map.put(ch,map.get(ch)+1);
        // }
        // for(char ch : chArrayT){
        //     if(!map.containsKey(ch)) return false;
        //     else map.put(ch,map.get(ch)-1);
        // }
        // for(Map.Entry<Character,Integer> entry : map.entrySet()){
        //     if(entry.getValue()!=0) return false;
        // }
        // return true;

        //Linear time and constant space
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        char[] chArrayS = s.toCharArray();
        char[] chArrayT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int n : arr){
            if(n!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));

    }
}