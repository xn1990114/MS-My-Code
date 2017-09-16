package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.GroupLabels;
/*
 * 
TC1:
Eg： 
A : 1, 2, 3
B:  4, 5.
C:  1, 4.
D:  7, 8
E:  8, 9.
F:  0
则应该输出 {A, B, C}, {D, E}. {F}.
TC2:
Eg： 
A : 1, 2, 3
B:  4, 5.
C:  1, 4.
D:  7, 8
E:  8, 9.
F:  0, 3
则应该输出 {A, B, C}, {D, E}. {F}.
 */
public class GroupLabelsTester {

	@Test
	public void test() {
		GroupLabels tester=new GroupLabels();
		List<Character> labels=new ArrayList<Character>();
		List<List<Integer>> ids=new ArrayList<List<Integer>>();
		labels.add('A');
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(1);l1.add(2);l1.add(3);
		labels.add('B');
		List<Integer> l2=new ArrayList<Integer>();
		l2.add(4);l2.add(5);
		labels.add('C');
		List<Integer> l3=new ArrayList<Integer>();
		l3.add(1);l3.add(4);
		labels.add('D');
		List<Integer> l4=new ArrayList<Integer>();
		l4.add(7);l4.add(8);
		labels.add('E');
		List<Integer> l5=new ArrayList<Integer>();
		l5.add(8);l5.add(9);
		labels.add('F');
		List<Integer> l6=new ArrayList<Integer>();
		l6.add(0);
		ids.add(l1);ids.add(l2);ids.add(l3);ids.add(l4);ids.add(l5);ids.add(l6);
		List<List<Character>> res1=tester.groupdLabels(ids, labels);
		tester.display(res1);
		l6.add(3);
		List<List<Character>> res2=tester.groupdLabels(ids, labels);
		tester.display(res2);
	}

}
