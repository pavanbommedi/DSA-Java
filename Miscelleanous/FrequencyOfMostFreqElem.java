import java.util.Arrays;
//Bucksort
public class FrequencyOfMostFreqElem {

    public int freq1(int[] nums, int k){
        Arrays.sort(nums);

        int l = 0;
        int res = 0;
        long total = 0;

        for(int r = 0; r < nums.length; r++){

            total += nums[r];

            while((long)nums[r] * (r-l+1) > total + k){
                total -= nums[l];
                l++;
        }

        res = Math.max(res, r-l+1);
    }

    return res;
    }

    public int freq2(int[] nums, int k){
        Arrays.sort(nums);
        int max = 1;
        int i = nums.length - 1;

        while (i >= max) {

            int ref = nums[i];
            int j = i - 1;
            int cn = k;
            int freq = 1;

            while (cn > 0 && j >= 0) {

                if (cn >= ref - nums[j]) {
                    cn = cn - (ref - nums[j]);
                    freq += 1;
                    j -= 1;
                } else {
                    break;
                }
            }

            max = Math.max(max, freq);
            i -= 1;
        }

        return max;
    }

}
