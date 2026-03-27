package Miscelleanous.BucketSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements 
{
    class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Frequency count
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Step 2: Bucket initialization
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        // Step 3: Fill buckets
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            bucket.get(e.getValue()).add(e.getKey());
        }

        // Step 4: Collect top k
        int[] res = new int[k];
        int ind = 0;

        for (int i = bucket.size() - 1; i > 0; i--) {
            List<Integer> curr = bucket.get(i);

            for (int num : curr) {
                res[ind++] = num;
                if (ind == k) return res;
            }
        }

        return res;
    }
}
}
