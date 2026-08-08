import java.util.*;
public  class GroupAnagrams{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap<>();
        // List<List<String>> res = new ArrayList<>();
        for(String s: strs){
            int[] arr = new int[26];
            for(int j =0;j<s.length();j++){
                arr[s.charAt(j)-'a']++;
            }
            String key = Arrays.toString(arr);
            map.computeIfAbsent(key,k->new ArrayList<>()).add(s);
        }
        // for(Map.Entry<String,List<String>> entry : map.entrySet()){
        //     res.add(entry.getValue());
        // }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"ate","bat","eat","tea"};
        System.out.println(groupAnagrams(strs));

    }
}