package onsite;

public class ThreePatitionArray {
	public void reArrange(int[] nums,int midHigh,int midLow){
		int highIndex=0;
		int lowIndex=nums.length-1;
		for(int i=0;i<=lowIndex;i++){
			if(nums[i]>midHigh){
				int temp=nums[i];
				nums[i]=nums[highIndex];
				nums[highIndex]=temp;
				highIndex++;
			}
			else if(nums[i]<midLow){
				int temp=nums[i];
				nums[i]=nums[lowIndex];
				nums[lowIndex]=temp;
				lowIndex--;
				i--;
			}
		}
	}
}
