package onsiteTester;

import static org.junit.Assert.*;
import onsite.ThreePatitionArray;

import org.junit.Test;

public class ThreePatitionArrayTester {

	@Test
	public void test() {
		ThreePatitionArray tpa=new ThreePatitionArray();
		int[] a1={5,61,6,37,72,64,82,8,2,1};
		tpa.reArrange(a1, 40,20);
		for(int i=0;i<a1.length;i++){
			System.out.print(a1[i]+"\t");
		}
		System.out.println();
		tpa.reArrange(a1, 36,5);
		for(int i=0;i<a1.length;i++){
			System.out.print(a1[i]+"\t");
		}
		System.out.println();
		int[] a2={5,61,6,37,72,64,82,8,2,1};
		tpa.reArrange(a2, -200,-300);
		for(int i=0;i<a2.length;i++){
			System.out.print(a2[i]+"\t");
		}
		System.out.println();
		int[] a3={2,39,1,3};
		tpa.reArrange(a3, 40,10);
		for(int i=0;i<a3.length;i++){
			System.out.print(a3[i]+"\t");
		}
		System.out.println();
		tpa.reArrange(a3, 50,40);
		for(int i=0;i<a3.length;i++){
			System.out.print(a3[i]+"\t");
		}
	}

}
