package TwoPointers;

import java.util.Arrays;

public class MergeSortedArray {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = m - 1;
            int j = n - 1;
            int ind = m + n - 1;

            while (i >= 0 && j >= 0) {

                if (nums1[i] > nums2[j]) {
                    nums1[ind--] = nums1[i--];
                } else {
                    nums1[ind--] = nums2[j--];
                }
            }

            // Copy remaining nums2 elements
            while (j >= 0) {
                nums1[ind--] = nums2[j--];
            }
        }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2=new int[]{2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
