package onsiteTester;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import onsite.DepthOfBinaryTree;

public class DepthOfBinaryTreeTester {

	@Test
	public void test1() {
		DepthOfBinaryTree tester=new DepthOfBinaryTree();
		int[] nums= {2, 3, 3, -1, 2};
		assertTrue(tester.findMaxDepth(nums)==3);
	}
	@Test
	public void test2() {
		DepthOfBinaryTree tester=new DepthOfBinaryTree();
		int[] nums= {};
		assertTrue(tester.findMaxDepth(nums)==0);
	}
	@Test
	public void test3() {
		DepthOfBinaryTree tester=new DepthOfBinaryTree();
		int[] nums= {-1};
		assertTrue(tester.findMaxDepth(nums)==1);
	}

}
