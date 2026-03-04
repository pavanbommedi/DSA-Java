import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater{
	public static void main(String[] args){
		int [] res = nextGreaterArray(new int[] {2,1,4,3},new int[] {6,1,3,4,2,5,7});
		System.out.println(Arrays.toString(res));
	}
	public static int[] nextGreaterArray(int[] nums1,int[] nums2){
		Stack<Integer> stack = new Stack<>();
		Map<Integer,Integer> map = new HashMap<>();
		int[] res = new int[nums1.length];
		Arrays.fill(res,-1);
		for(int i=0;i<nums1.length;i++) map.put(nums1[i],i );
		for(int i=0;i<nums2.length;i++){
			while(!stack.isEmpty() && stack.peek()<nums2[i]){
				res[map.get(stack.peek())] = nums2[i];
				stack.pop();
			}
			if(map.containsKey(nums2[i])) stack.push(nums2[i]);
		}
		return res;
	}
}