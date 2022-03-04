package com.dsnalgomadeeasy.tree.common;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.tree.common.BinaryTreeTraversals.TraversalMethod;

@RunWith(Parameterized.class)
public class BinaryTreeTraversalsTest {
	BinaryTreeTraversals btt;
	Integer[] expectedResult;
	String[] data;
	BinaryTreeTraversals.TraversalMethod traversalMethod;

	public BinaryTreeTraversalsTest(String[] data, Integer[] expectedResult, TraversalMethod traversalMethod) {
		this.data = data;
		this.traversalMethod = traversalMethod;
		this.expectedResult = expectedResult;
	}

	@Before
	public void setUp() throws Exception {
		btt = new BinaryTreeTraversals();
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { { null, new Integer[] {}, TraversalMethod.PREORDER },
				{ null, new Integer[] {}, TraversalMethod.INORDER },
				{ null, new Integer[] {}, TraversalMethod.POSTORDER },
				{ null, new Integer[] {}, TraversalMethod.LEVELORDER },

				{ new String[] { "1" }, new Integer[] { 1 }, TraversalMethod.PREORDER },
				{ new String[] { "1" }, new Integer[] { 1 }, TraversalMethod.INORDER },
				{ new String[] { "1" }, new Integer[] { 1 }, TraversalMethod.POSTORDER },
				{ new String[] { "1" }, new Integer[] { 1 }, TraversalMethod.LEVELORDER },

				{ new String[] { "1", "n" }, new Integer[] { 1 }, TraversalMethod.PREORDER },
				{ new String[] { "1", "n" }, new Integer[] { 1 }, TraversalMethod.INORDER },
				{ new String[] { "1", "n" }, new Integer[] { 1 }, TraversalMethod.POSTORDER },
				{ new String[] { "1", "n" }, new Integer[] { 1 }, TraversalMethod.LEVELORDER },

				{ new String[] { "1", "n", "n" }, new Integer[] { 1 }, TraversalMethod.PREORDER },
				{ new String[] { "1", "n", "n" }, new Integer[] { 1 }, TraversalMethod.INORDER },
				{ new String[] { "1", "n", "n" }, new Integer[] { 1 }, TraversalMethod.POSTORDER },
				{ new String[] { "1", "n", "n" }, new Integer[] { 1 }, TraversalMethod.LEVELORDER },

				{ new String[] { "1", "2", "n", "3" }, new Integer[] { 1, 2, 3 }, TraversalMethod.PREORDER },
				{ new String[] { "1", "2", "n", "3" }, new Integer[] { 3, 2, 1 }, TraversalMethod.INORDER },
				{ new String[] { "1", "2", "n", "3" }, new Integer[] { 3, 2, 1 }, TraversalMethod.POSTORDER },
				{ new String[] { "1", "2", "n", "3" }, new Integer[] { 1, 2, 3 }, TraversalMethod.LEVELORDER },

				{ new String[] { "1", "n", "2", "n", "3" }, new Integer[] { 1, 2, 3 }, TraversalMethod.PREORDER },
				{ new String[] { "1", "n", "2", "n", "3" }, new Integer[] { 1, 2, 3 }, TraversalMethod.INORDER },
				{ new String[] { "1", "n", "2", "n", "3" }, new Integer[] { 3, 2, 1 }, TraversalMethod.POSTORDER },
				{ new String[] { "1", "n", "2", "n", "3" }, new Integer[] { 1, 2, 3 }, TraversalMethod.LEVELORDER },

				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 1, 2, 4, 5, 3 }, TraversalMethod.PREORDER },
				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 4, 2, 5, 1, 3 }, TraversalMethod.INORDER },
				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 4, 5, 2, 3, 1 },
						TraversalMethod.POSTORDER },
				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 1, 2, 3, 4, 5 },
						TraversalMethod.LEVELORDER },

				{ new String[] { "1", "2", "3", "4", "n", "n", "5" }, new Integer[] { 1, 2, 4, 3, 5 },
						TraversalMethod.PREORDER },
				{ new String[] { "1", "2", "3", "4", "n", "n", "5" }, new Integer[] { 4, 2, 1, 3, 5 },
						TraversalMethod.INORDER },
				{ new String[] { "1", "2", "3", "4", "n", "n", "5" }, new Integer[] { 4, 2, 5, 3, 1 },
						TraversalMethod.POSTORDER },
				{ new String[] { "1", "2", "3", "4", "n", "n", "5" }, new Integer[] { 1, 2, 3, 4, 5 },
						TraversalMethod.LEVELORDER },

				{ new String[] { "1", "2", "3", "n", "4", "5", "n" }, new Integer[] { 1, 2, 4, 3, 5 },
						TraversalMethod.PREORDER },
				{ new String[] { "1", "2", "3", "n", "4", "5", "n" }, new Integer[] { 2, 4, 1, 5, 3 },
						TraversalMethod.INORDER },
				{ new String[] { "1", "2", "3", "n", "4", "5", "n" }, new Integer[] { 4, 2, 5, 3, 1 },
						TraversalMethod.POSTORDER },
				{ new String[] { "1", "2", "3", "n", "4", "5", "n" }, new Integer[] { 1, 2, 3, 4, 5 },
						TraversalMethod.LEVELORDER },

				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 1, 2, 4, 5, 3 }, TraversalMethod.PREORDER },
				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 4, 2, 5, 1, 3 }, TraversalMethod.INORDER },
				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 4, 5, 2, 3, 1 },
						TraversalMethod.POSTORDER },
				{ new String[] { "1", "2", "3", "4", "5" }, new Integer[] { 1, 2, 3, 4, 5 },
						TraversalMethod.LEVELORDER },

				{ new String[] { "1", "2", "3", "4", "5", "6", "7" }, new Integer[] { 1, 2, 4, 5, 3, 6, 7 },
						TraversalMethod.PREORDER },
				{ new String[] { "1", "2", "3", "4", "5", "6", "7" }, new Integer[] { 4, 2, 5, 1, 6, 3, 7 },
						TraversalMethod.INORDER },
				{ new String[] { "1", "2", "3", "4", "5", "6", "7" }, new Integer[] { 4, 5, 2, 6, 7, 3, 1 },
						TraversalMethod.POSTORDER },
				{ new String[] { "1", "2", "3", "4", "5", "6", "7" }, new Integer[] { 1, 2, 3, 4, 5, 6, 7 },
						TraversalMethod.LEVELORDER } });
	}

	@Test
	public void testTreversals() {
		assertArrayEquals(expectedResult, btt.getTreeAsArray(BinaryTreeUtil.buildTree(data), traversalMethod));
	}

}
