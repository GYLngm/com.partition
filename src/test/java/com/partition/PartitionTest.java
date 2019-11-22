package com.partition;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class PartitionTest {


	@Test(expected=IndexOutOfBoundsException.class)
	public void testInteger() {
		Partition helper = new Partition();
		
		/*                   Test for integer                            */
		List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
		
		List<List<Integer>> list2PartSet = helper.partition(liste, 2);
		List<List<Integer>> list3PartSet = helper.partition(liste, 3);
		List<List<Integer>> list1PartSet = helper.partition(liste, 1);
		
		assertEquals(3,list2PartSet.size());
		assertEquals(2,list3PartSet.size());
		assertEquals(5,list1PartSet.size());
		
		Assert.assertArrayEquals(new int[][] {{1,2},{3,4},{5}}, helper.convertToArr(list2PartSet));
		Assert.assertArrayEquals(new int[][] {{1,2,3},{4,5}}, helper.convertToArr(list3PartSet));
		Assert.assertArrayEquals(new int[][] {{1},{2},{3},{4},{5}}, helper.convertToArr(list1PartSet));
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testString() {
		Partition helper = new Partition();
		
		/*                   Test for String                            */
		List<String> strings = Arrays.asList("ew","cs","rt","vt","ui");
		List<List<String>> list2PartSetStr = helper.partition(strings, 2);
		
		assertEquals(3,list2PartSetStr.size());
		Assert.assertArrayEquals(new String[][] {{"ew","cs"},{"rt","vt"},{"ui"}}, helper.convertToArr(list2PartSetStr));
	}
	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testObject() {
		Partition helper = new Partition();
		/*                   Test for Object                            */
		List<Object> objmix = Arrays.asList("ew",1,"rt",2,"ui");
		List<List<Object>> list2PartSetMix = helper.partition(objmix, 2);
		
		assertEquals(3,list2PartSetMix.size());
		Assert.assertArrayEquals(new Object[][] {{"ew",1},{"rt",2},{"ui"}}, helper.convertToArr(list2PartSetMix));
	}
}
