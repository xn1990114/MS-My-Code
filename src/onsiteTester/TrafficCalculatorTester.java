package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.TrafficCalculator;

public class TrafficCalculatorTester {
/*
 * tc 1: first index is city id, second is popultion
 *       0,5
 *       |
 * 2,3 -1,4  - 3,2  - 4,4 - 5,1
 */
	@Test
	public void test() {
		TrafficCalculator tester=new TrafficCalculator();
		int[] pop1={5,4,3,2,4,1};
		int[][] conn1={{0,1},
					   {1,2},
					   {1,3},
					   {3,4},
					   {4,5}};
		int t1=3;
		int[] r1=tester.calOneTime(pop1, conn1, t1);
		assertTrue(r1[0]==12&&r1[1]==3&&r1[2]==1);
		int t12=1;
		int[] r2=tester.calOneTime(pop1, conn1, t12);
		assertTrue(r2[0]==7&&r2[1]==1&&r2[2]==3);
		/*
		 * tc 2: first index is city id, second is popultion
		 *              0,5
		 *               |
		 * 2,3 -1,1  - 3,2  - 4,3 - 5,1
		 */
		int[] pop2={5,1,3,2,3,1};
		int[][] conn2={{0,3},
					   {1,2},
					   {1,3},
					   {3,4},
					   {4,5}};
		int t2=3;
		int[] r3=tester.calOneTime(pop2, conn2, t2);
		assertTrue(r3[0]==5&&r3[1]==3&&r3[2]==0);
	}
}
