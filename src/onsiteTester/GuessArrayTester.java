package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.GuessArray;

public class GuessArrayTester {

	@Test
	public void test() {
		GuessArray tester=new GuessArray();
		int[] input={4,5,6,1,4,2,13,3,16,5,6,4,2,1};
		int[] res=tester.findOriginal(input);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
		for(int i=0;i<res.length;i++){
			assertTrue(res[i]==input[i]);
		}
	}

}
