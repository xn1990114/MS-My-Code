package onsite;
import java.util.*;
/*
 * 许多城市组成的 graph, 城市间有双向道路联通， 每个城市有一个人口数，无 cycle， 
 * 问 如果其中以城市举行赛事，求哪条路上travel 人最多 （所有城市所有人都会去）
follow-up: 如果经常call 这个function，怎么优化
 */


public class TrafficCalculator {
	// one time
	public int[] calOneTime(int[] population,int[][] connection,int target){
		int[] max=new int[3];
		boolean[] visited=new boolean[population.length];
		visited[target]=true;
		Map<Integer,Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
		for(int i=0;i<connection.length;i++){
			int c1=connection[i][0];
			int c2=connection[i][1];
			if(!map.containsKey(c1)){
				map.put(c1, new HashSet<Integer>());
			}
			if(!map.containsKey(c2)){
				map.put(c2, new HashSet<Integer>());
			}
			map.get(c1).add(c2);
			map.get(c2).add(c1);
		}
		calSum(target,population,visited,map,max);
		return max;
	}
	// one time
	public int calSum(int curr,int[] population,boolean[] visited,Map<Integer,Set<Integer>> map,int[] max){
		int sum=population[curr];
		Set<Integer> child=map.get(curr);
		visited[curr]=true;
		if(child!=null){
			for(int c:child){
				if(visited[c]){
					continue;
				}
				int temp=calSum(c,population,visited,map,max);
				if(temp>max[0]){
					max[0]=temp;
					max[1]=curr;
					max[2]=c;
				}
				sum=sum+temp;
			}
		}
		
		return sum;
	}
}
