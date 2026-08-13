import java.util.*;
class FrequentElement {
    public static  int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int cn = 0;

        // Count frequency
        for (int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }

        // frequency -> list of keys
        List<List<Integer>> freq = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        // Put keys into their frequency bucket
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }

        // Traverse from highest frequency
        for (int i = nums.length; i > 0; i--) {

            for (int j = 0; j < freq.get(i).size(); j++) {
                res[cn++] = freq.get(i).get(j);
            }

            if (cn == k)
                return res;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{2,3,4,5,3,2,7};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
}