package com.dsnalgomadeeasy.tree.problems;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.tree.common.BinaryTreeUtil;

import org.junit.*;

@RunWith(Parameterized.class)
public class MaxBinaryTreeTest {
	MaxBinaryTree mmbt;
	int expectedResult;
	String[] data;

	public MaxBinaryTreeTest(String[] data, int expectedResult) {
		super();
		this.data = data;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		mmbt = new MaxBinaryTree();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { 
				{ null, Integer.MIN_VALUE},
				{ new String[] { "1" },1 },
				{ new String[] { "1", "2" },2 },
				{ new String[] { "2", "1", "n" }, 2},
				{ new String[] { "1", "2", "n", "3" }, 3},
				{ new String[] { "1", "n", "2", "n", "3" }, 3 },
				{ new String[] { "1", "2", "3", "4", "5" },5  },
				{ new String[] { "5", "4", "3", "2", "1"},5},
				{ new String[] { "1", "2", "3", "n", "4", "5", "n" }, 5},
				{ new String[] { "5","2","10","n","n","11" },11 },
				{ new String[] { "5","2","10","n","0","11","n","99" }, 99} 
			});
	}

	@Test
	public void testGetMaxInBinaryTree() {
		Assert.assertEquals(expectedResult, mmbt.getMaxInBinaryTree(BinaryTreeUtil.buildTree(data)));
	}

	@Test
	public void testGetMaxInBinaryTreeIt() {
		Assert.assertEquals(expectedResult, mmbt.getMaxInBinaryTreeIt(BinaryTreeUtil.buildTree(data)));
	}
}
