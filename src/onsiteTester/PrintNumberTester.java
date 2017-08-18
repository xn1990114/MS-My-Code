package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.PrintNumber;

public class PrintNumberTester {

	@Test
	public void test() {
		PrintNumber pn=new PrintNumber();
		int[] array={0,1,2,3,4,5,6,7,8,9,10,11,12};
		pn.print(array, true, 3);
		pn.print(array, false, 3);
	}

}
