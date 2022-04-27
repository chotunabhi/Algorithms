package com.dsnalgomadeeasy.queue.problems;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.queue.common.QueueUtil;

@RunWith(Parameterized.class)
public class QueueReversalTest {
	private QueueReversal<Integer> qr;
	private Integer[] expectedResult;
	private Integer[] data;
	
	public QueueReversalTest(Integer[] data,Integer[] expectedResult) {
		super();
		this.expectedResult = expectedResult;
		this.data = data;
	}

	@Before
	public void setUp() throws Exception {
		qr = new QueueReversal<>();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{ null, null },
			{new Integer[] {1},new Integer[] {1}},
			{new Integer[] {1,2},new Integer[] {2,1}},
			{new Integer[] {1,2,3,4,5,6},new Integer[] {6,5,4,3,2,1}}
		});
	}
	
	@Test
	public void testReverseQueue() {
		assertArrayEquals(expectedResult, QueueUtil.getArrayFromQueue(qr.reverseQueue(QueueUtil.getQueueFromArray(data))));
	}

}
