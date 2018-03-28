package onsite;

import java.util.Arrays;

/*
 * 一辆公交车，有一定的油，要到d miles 之外的目的地。起点终点之间有一些加油站(GasStation)，
 * 加油站这个类有两个变量，1，到目的地的距离，2，有多少油。
 * 问公交车最少要停多少次来加油 才能到目的地。公交车耗油是 1 加仑／迈
g = 10 gallon,
d = 20 miles,
list of GasStation,
gasStations = [[15, 1], [14,10], [12,12]]
minimum stop = 1, 停在最后一个加油站加油就行。
 */

public class GasStationStops {
	public class GasStation implements Comparable<GasStation>{
		int distanceToDestination;
		int availableGas;
		public GasStation(int dis,int gas){
			this.distanceToDestination=dis;
			this.availableGas=gas;
		}
		public int compareTo(GasStation s2){
			return s2.distanceToDestination-this.distanceToDestination;
		}
	}
	
	public int findMinStops(int gas,int dis,GasStation[] stations){
		if(dis<=gas){
			return 0;
		}
		Arrays.sort(stations);
		int[] last=new int[stations.length];
		Arrays.fill(last, -1);
		boolean cont=false;
		for(int i=0;i<stations.length&&dis-gas<=stations[i].distanceToDestination;i++){
			last[i]=gas-(dis-stations[i].distanceToDestination);
			cont=true;
		}
		int step=1;
		while(cont){
			cont=false;
			int[] curr=new int[stations.length];
			Arrays.fill(curr, -1);
			for(int i=0;i<last.length;i++){
				if(last[i]!=-1){
					int currMax=last[i]+stations[i].availableGas;
					int currPos=stations[i].distanceToDestination;
					if(currPos<=currMax){
						return step;
					}
					for(int j=i+1;j<stations.length&&currPos-currMax<=stations[j].distanceToDestination;j++){
						int remain=currMax-(currPos-stations[j].distanceToDestination);
						if(curr[j]==-1||curr[j]<remain){
							curr[j]=remain;
							cont=true;
						}
					}
				}
			}
			last=curr;
			step++;
		}
		return -1;
	}
}
