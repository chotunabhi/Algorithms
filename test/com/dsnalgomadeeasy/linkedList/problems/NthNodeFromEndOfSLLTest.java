package com.dsnalgomadeeasy.linkedList.problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;
import com.dsnalgomadeeasy.linkedList.common.SLLUtil;

import junit.framework.Assert;

@RunWith(Parameterized.class)
public class NthNodeFromEndOfSLLTest {
	private NodeSLL<Integer> head;
	private Integer expectedResult;
	private int n;
	private NthNodeFromEndOfSLL nnfeos;
	
	public NthNodeFromEndOfSLLTest(NodeSLL<Integer> head, int n, Integer expectedResult) {
		super();
		this.head = head;
		this.n = n;
		this.expectedResult = expectedResult;
	}

	@Before
	public void init() {
		nnfeos = new NthNodeFromEndOfSLL();
	}
	
	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
			{null, 0,null},
			{SLLUtil.createSLL(new Integer[] {1}), -1, null},
			{SLLUtil.createSLL(new Integer[] {1}), 1, 1},
			{SLLUtil.createSLL(new Integer[] {1}), 0, null},
			{SLLUtil.createSLL(new Integer[] {1}), 5, null},
			{SLLUtil.createSLL(new Integer[] {1,2,3,4,5}), 1, 5},
			{SLLUtil.createSLL(new Integer[] {1,2,3,4,5}), 4, 2},
			{SLLUtil.createSLL(new Integer[] {1,2,3,4,5}), 5, 1}
		});
	}
	
	@Test
	public void testBruteForce() {
		assertEquals(expectedResult,nnfeos.bruteForce(head, n) );
	}

	@Test
	public void testUsingStack() {
		assertEquals(expectedResult,nnfeos.usingStack(head, n));
	}
	
	@Test
	public void testUsingHT() {
		assertEquals(expectedResult,nnfeos.usingHT(head, n));
	}
	
	@Test
	public void testUsingLengthOfSLL() {
		assertEquals(expectedResult,nnfeos.usingLengthOfSLL(head, n));
	}
	/*
	@Test
	public void testUsingOnePass() {
		assertEquals(expectedResult,nnfeos.usingOnePass(head, n));
	}
	
	@Test
	public void testUsingRecursion() {
		assertEquals(expectedResult,nnfeos.usingRecursion(head, n));
	}*/
}
