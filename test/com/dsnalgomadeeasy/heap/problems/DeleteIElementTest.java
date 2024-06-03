//package com.dsnalgomadeeasy.heap.problems;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import com.dsnalgomadeeasy.heap.common.BinaryHeap;
//import com.dsnalgomadeeasy.heap.common.BinaryHeap.HeapType;
//
//import org.junit.Assert;
//
//@RunWith(Parameterized.class)
//public class DeleteIElementTest {
//	DeleteIElement die;
//	Integer expectedKey;
//	int index;
//	Integer[] expectedHeap;
//	Integer[] data;
//	
//	public DeleteIElementTest(Integer[] data,int index, Integer expectedKey, Integer[] expectedHeap) {
//		super();
//		this.data = data;
//		this.index = index;
//		this.expectedKey = expectedKey;
//		this.expectedHeap = expectedHeap;
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		die = new DeleteIElement();
//	}
//	
//	@Parameterized.Parameters
//	public static Collection testData() {
//		return Arrays.asList(new Object[][] { 
//				{new Integer[] {},0,null,new Integer[] {}},
//				{ new Integer[] {1}, 1,null,new Integer[] {1} },
//				{ new Integer[] {4,3,6,1},10,null,new Integer[] {1,3,6,4} },
//				{  new Integer[] {4,3,6,1},0,1,new Integer[] {3,4,6,4} },
//				{  new Integer[] {4,3,6,1},3,4,new Integer[] {1,3,6,4} }
//			}
//		);
//	}
//
//	@Test
//	public void test() {
////		BinaryHeap h = new BinaryHeap(this.data.length,HeapType.MINIMUM);
////		h.buildHeap(h, data);
////		Integer actual = die.getIthIndexDeleted(h, this.index);
////		Integer[] finalHeap = h.array;
////		
////		Assert.assertEquals(this.expectedKey, actual);
////		Assert.assertArrayEquals(expectedHeap, finalHeap);
//	}
//
//}
