package onsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 题目是猜一个数组里的数字，比如对于数组［1, 2, 3, 4］，你要猜每个index上面的数字，
 * 题目给你一个函数，对于你猜的数组会返回几个 strong guess 和几个weak guess。 weak guess 就是你猜的数字是对的，
 * 但是index不对；strong guess就是你猜的数字和index都对。举例：
 * 对于游戏对手的数组［1,2,3,4］:
 * 如果你猜的数组是［1, 10, 8, 9］，题目给的函数会返回 1 strong, 0 weak；
 * 如果你猜的数组是［1, 4, 8, 9］，题目给的函数会返回 1 strong, 1 weak；
 */

//assuming all nums range from 0-19.
public class GuessArray {
	public int[] findOriginal(int[] nums){
		int[] res=new int[nums.length];
		Arrays.fill(res, -1);
		int[] curr=new int[2];
		int[] startIndex=new int[20];
		for(int i=0;i<res.length;i++){
			if(res[i]!=-1){
				continue;
			}
			for(int num=0;num<20;num++){
				res[i]=num;
				int[] temp=checkRes(res,nums);
				if(temp[0]==curr[0]+1){
					curr[0]++;
					break;
				}
				else if(temp[1]==1){
					int index=Math.max(i+1,startIndex[num]);
					while(index<res.length){
						if(res[index]!=-1){
							index++;
							continue;
						}
						res[index]=num;
						int[] t=checkRes(res,nums);
						if(t[0]==curr[0]+1){
							curr[0]++;
							startIndex[num]=index+1;
							break;
						}
						res[index]=-1;
						index++;
					}
				}
			}
		}
		return res;
	}
	public int[] checkRes(int[] nums1, int[] nums2) {
		int match = 0;
		int misPlaced = 0;
		Map<Integer, Integer> c1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> c2 = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] == nums2[i]) {
				match++;
			} else {
				if (!c2.containsKey(nums2[i])) {
					c2.put(nums2[i], 0);
				}
				c2.put(nums2[i], 1 + c2.get(nums2[i]));
				if (!c1.containsKey(nums1[i])) {
					c1.put(nums1[i], 0);
				}
				c1.put(nums1[i], 1 + c1.get(nums1[i]));
			}
		}
		for(Integer key:c1.keySet()){
			if(c2.containsKey(key)){
				misPlaced=misPlaced+Math.min(c1.get(key), c2.get(key));
			}
		}
		return new int[]{match,misPlaced};
	}
}
