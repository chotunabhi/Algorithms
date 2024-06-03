//package com.dsnalgomadeeasy.heap.problems;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import com.dsnalgomadeeasy.heap.common.BinaryHeap;
//import com.dsnalgomadeeasy.heap.common.BinaryHeap.HeapType;
//
//@RunWith(Parameterized.class)
//public class MaxElementInMinHeapTest {
//	MaxElementInMinHeap meimh;
//	Integer expected;
//	Integer[] data;
//	
//	public MaxElementInMinHeapTest(Integer[] data, Integer expected) {
//		super();
//		this.data = data;
//		this.expected = expected;
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		meimh = new MaxElementInMinHeap();
//	}
//	
//	@Parameterized.Parameters
//	public static Collection testData() {
//		return Arrays.asList(new Object[][] { 
//				{new Integer[] {},null},
//				{ new Integer[] {1}, 1 },
//				{ new Integer[] {4,2,7,1}, 7 },
//				{ new Integer[] {1,2,3,4,5,6,7,8,9,10},10 }
//			}
//		);
//	}
//
//	@Test
//	public void testGetMaxInMinHeap() {
//		BinaryHeap mH = new BinaryHeap(this.data.length,HeapType.MINIMUM);
//		mH.buildHeap(mH, data);
//		
//		Assert.assertEquals(expected,meimh.getMaxInMinHeap(mH));
//	}
//
//}
