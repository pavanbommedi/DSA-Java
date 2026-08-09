public class MajorityElement{
    public static  int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));

    }
}

//169. Majority Element
//        ────────────────────────
//
//        Pattern:
//        Boyer-Moore Voting Algorithm
//
//        Idea:
//        Different elements cancel each other.
//
//        Majority > n/2
//        → cannot be completely cancelled
//        → must survive.
//
//        candidate = current potential majority
//        count = candidate's advantage
//
//        Same as candidate:
//        count++
//
//        Different:
//        count--
//
//        count == 0:
//        choose new candidate
//
////        Time: O(n)
//        Space: O(1)