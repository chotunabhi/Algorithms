package com.dsnalgomadeeasy.tree.common;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryTreeBuildTreeTest {
	private String[] data;
	private Integer[] expectedResult;
	private BinaryTreeTraversals btt;
	
	public BinaryTreeBuildTreeTest(Integer[] expectedResult,String[] data) {
		this.expectedResult = expectedResult;
		this.data = data;
	}
	
	@Before
	public void init() {
		btt = new BinaryTreeTraversals();
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{new Integer[] {}, null},
			{new Integer[]{1}, new String[] {"1"}},
			{new Integer[]{1}, new String[] {"1","n"}},
			{new Integer[]{1}, new String[] {"1","n","n"}},
			{new Integer[]{1}, new String[] {"1","n","n","8"}},
			{new Integer[]{1,2,3}, new String[] {"1","2","n","3"}},
			{new Integer[]{1,2,3}, new String[] {"1","n","2","n","3"}},
			{new Integer[]{1,2,3,4,5}, new String[] {"1","2","3","4","5"}},
			{new Integer[]{1,2,3,4,5}, new String[] {"1","2","3","4","n","n","5"}},
			{new Integer[]{1,2,3,4,5}, new String[] {"1","2","3","n","4","5","n"}},
			{new Integer[]{1,2,3,4,5,6,7}, new String[] {"1","2","3","4","5","6","7"}}
		});
	}
	
	@Test
	public void testBuildTree() {
		BinaryTreeNode<Integer> root = BinaryTreeUtil.buildTree(data);
		 btt.levelOrderTraversal(root);
		assertArrayEquals(expectedResult,btt.getResultList().toArray());
	}
}
