package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

@RunWith(Parameterized.class)
public class RemoveDuplicatesInUnorderedSLLTest {
	Integer[] head;
	Integer[] result;
	RemoveDuplicatesInUnorderedSLL duplicatesInUnorderedSLL;

	@Before
	public void setUp() throws Exception {
		duplicatesInUnorderedSLL = new RemoveDuplicatesInUnorderedSLL();
	}

	public RemoveDuplicatesInUnorderedSLLTest(Integer[] head, Integer[] result) {
		this.head = head;
		this.result = result;
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
			{ null, null},
			{ new Integer[]{1}, new Integer[] { 1 } },
			{ new Integer[]{1, 2}, new Integer[] { 1, 2 } },
			{ new Integer[]{1, 1}, new Integer[] { 1 } },
			{ new Integer[]{1, 2, 1}, new Integer[] { 1, 2 } },
			{ new Integer[]{1, 1, 1}, new Integer[] { 1 } },
			{ new Integer[]{1, 1, 2}, new Integer[] { 1, 2 } },
			{ new Integer[]{2, 1, 1}, new Integer[] { 2, 1 } },
			{ new Integer[]{1, 2, 3, 1, 2, 1 , 4, 2, 5, 1,6}, new Integer[] { 1, 2, 3, 4, 5, 6 } }
		});
	}

	@Test
	public void testGetNonDuplicateListBruteForce() {
		assertArrayEquals(result,SLLUtil.getArrayFromList(duplicatesInUnorderedSLL.getNonDuplicateListBruteForce(SLLUtil.createSLL(head))));
	}

	@Test
	public void testGetNonDuplicateListUsingHashSet() {
		assertArrayEquals(result,SLLUtil.getArrayFromList(duplicatesInUnorderedSLL.getNonDuplicateListUsingHashSet(SLLUtil.createSLL(head))));
	}
}
