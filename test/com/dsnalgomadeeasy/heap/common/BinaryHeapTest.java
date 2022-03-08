package com.dsnalgomadeeasy.heap.common;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.heap.common.BinaryHeap.HeapType;

@RunWith(Parameterized.class)
public class BinaryHeapTest {
	private BinaryHeap binaryHeap;
	private HeapType heapType;
	private Integer[] data;
	private Integer[] expectedResult;

	public BinaryHeapTest(HeapType heapType, Integer[] data, Integer[] expectedResult) {
		super();
		this.heapType = heapType;
		this.data = data;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
				{ HeapType.MAXIMUM, null, null },
				{ HeapType.MAXIMUM, new Integer[] {}, new Integer[] {} },
				{ HeapType.MAXIMUM, new Integer[] {1}, new Integer[] {1} },
				{ HeapType.MAXIMUM, new Integer[] {4,2,7,1}, new Integer[] {7,2,4,1} },
				{ HeapType.MAXIMUM, new Integer[] {1,2,3,4}, new Integer[] {4,2,3,1} },
				{ HeapType.MAXIMUM, new Integer[] {4,3,2,1}, new Integer[] {4,3,2,1} },
				{ HeapType.MAXIMUM, new Integer[] {1,2,3,4,5,6,7,8,9,10}, new Integer[] {10,9,7,8,5,6,3,1,4,2} },
				
				{ HeapType.MINIMUM, null, null },
				{ HeapType.MINIMUM, new Integer[] {}, new Integer[] {} },
				{ HeapType.MINIMUM, new Integer[] {1}, new Integer[] {1} },
				{ HeapType.MINIMUM, new Integer[] {4,2,7,1}, new Integer[] {1,2,7,4} },
				{ HeapType.MINIMUM, new Integer[] {1,2,3,4}, new Integer[] {1,2,3,4} },
				{ HeapType.MINIMUM, new Integer[] {4,3,2,1}, new Integer[] {1,3,2,4} },
				{ HeapType.MINIMUM, new Integer[] {10,9,8,7,6,5,4,3,2,1}, new Integer[] {1,2,4,3,6,5,8,10,7,9} }
			}
		);
	}

	@Test
	public void buildHeapTest() {
		binaryHeap = new BinaryHeap(this.data == null?0:this.data.length, heapType);
		
		Assert.assertArrayEquals(expectedResult, binaryHeap.buildHeap(binaryHeap, data));
	}

}
