package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.GasStationStops;
import onsite.GasStationStops.GasStation;

public class GasStationStopsTester {

	@Test
	public void test1() {
		GasStationStops tester=new GasStationStops();
		int gas=10;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 1), tester.new GasStation(14, 10), 
				tester.new GasStation(12, 12)};
		assertTrue(tester.findMinStops(gas, dis, stations)==1);
	}
	@Test
	public void test2() {
		GasStationStops tester=new GasStationStops();
		int gas=5;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 14), tester.new GasStation(11, 1), 
				tester.new GasStation(5, 4)};
		assertTrue(tester.findMinStops(gas, dis, stations)==2);
	}
	@Test
	public void test3() {
		GasStationStops tester=new GasStationStops();
		int gas=30;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 1), tester.new GasStation(14, 10), 
				tester.new GasStation(12, 12)};
		assertTrue(tester.findMinStops(gas, dis, stations)==0);
	}
	@Test
	public void test4() {
		GasStationStops tester=new GasStationStops();
		int gas=10;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 2), tester.new GasStation(11, 1), 
				tester.new GasStation(5, 1)};
		assertTrue(tester.findMinStops(gas, dis, stations)==-1);
	}
	@Test
	public void test5() {
		GasStationStops tester=new GasStationStops();
		int gas=10;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 2), tester.new GasStation(11, 3), 
				tester.new GasStation(5, 5)};
		assertTrue(tester.findMinStops(gas, dis, stations)==3);
	}
	@Test
	public void test6() {
		GasStationStops tester=new GasStationStops();
		int gas=10;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 2), tester.new GasStation(11, 2), 
				tester.new GasStation(5, 5)};
		assertTrue(tester.findMinStops(gas, dis, stations)==-1);
	}
	@Test
	public void test7() {
		GasStationStops tester=new GasStationStops();
		int gas=15;
		int dis=20;
		GasStation[] stations={tester.new GasStation(15, 2), tester.new GasStation(11, 1), 
				tester.new GasStation(5, 2)};
		assertTrue(tester.findMinStops(gas, dis, stations)==3);
	}
}
