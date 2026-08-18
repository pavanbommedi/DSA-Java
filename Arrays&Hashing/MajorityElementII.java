import java.util.*;
class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {

        // Map<Integer, Integer> map = new HashMap<>();

        // // Find at most 2 possible candidates
        // for (int n : nums) {

        //     // If n already exists, increase its count
        //     if (map.containsKey(n)) {
        //         map.put(n, map.get(n) + 1);
        //     }

        //     // If we have less than 2 candidates, add n
        //     else if (map.size() < 2) {
        //         map.put(n, 1);
        //     }

        //     // We already have 2 candidates and n is a new element.
        //     // Cancel one occurrence of every current candidate.
        //     else {
        //         Map<Integer, Integer> newMap = new HashMap<>();

        //         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

        //             int key = entry.getKey();
        //             int count = entry.getValue();

        //             if (count > 1) {
        //                 newMap.put(key, count - 1);
        //             }
        //         }

        //         map = newMap;
        //     }
        // }

        // // IMPORTANT:
        // // map contains only possible candidates.
        // // We still need to verify their actual frequencies.

        // Map<Integer, Integer> countMap = new HashMap<>();

        // for (int n : nums) {
        //     if (map.containsKey(n)) {
        //         countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        //     }
        // }`

        // List<Integer> res = new ArrayList<>();

        // for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

        //     if (entry.getValue() > nums.length / 3) {
        //         res.add(entry.getKey());
        //     }
        // }

        // return res;

        //Boyer-Moore Algo
        int cn1 = 0;
        int cn2 = 0;
        int el1 = 0;
        int el2 = 0;

        // Find candidates
        for (int n : nums) {

            if (cn1 == 0 && el2 != n) {
                el1 = n;
                cn1 = 1;
            }
            else if (cn2 == 0 && el1 != n) {
                el2 = n;
                cn2 = 1;
            }
            else if (el1 == n) {
                cn1++;
            }
            else if (el2 == n) {
                cn2++;
            }
            else {
                cn1--;
                cn2--;
            }
        }

        // Verify candidates
        cn1 = 0;
        cn2 = 0;

        for (int n : nums) {
            if (n == el1) cn1++;
            else if (n == el2) cn2++;
        }

        List<Integer> res = new ArrayList<>();

        if (cn1 > nums.length / 3)
            res.add(el1);

        if (cn2 > nums.length / 3)
            res.add(el2);

        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1,2,3,4,5};
        System.out.println(majorityElement(nums));
    }
}