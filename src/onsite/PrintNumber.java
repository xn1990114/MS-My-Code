package onsite;
/*
 * 给你一个int array  一个数字代表多少行或者多少列，一个boolean代表 横着打印或者竖着打印。
【1,2,3,4】 2 横  
1  2
3  4
【1,2,3,4】 1 竖
1
2
3
4
 */
public class PrintNumber {
	public void print(int[] array,boolean horizon,int rowOrCol){
		int interval=horizon?1:rowOrCol;
		int maxCol=horizon?rowOrCol:Integer.MAX_VALUE;
		int max=horizon?array.length:interval;
		int i=0;
		while(i<max){
			int count=0;
			int j=i;
			while(j<array.length&&count<maxCol){
				System.out.print(array[j]+"\t");
				count++;
				j=j+interval;
			}
			System.out.println();
			i=horizon?j+1:(i+1);
		}
	}
}
