package com.dsnalgomadeeasy.disjointSets;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {
	@Test
	public void testUnion() {
		DisjointSet ds = new DisjointSet(5);
		ds.makeSlowFindSet();

		ds.union(0, 0);
		Assert.assertEquals(0, ds.slowFind(0));
		
		ds.union(0, 1);
		Assert.assertEquals(1, ds.slowFind(0));
		Assert.assertEquals(1, ds.slowFind(1));
		
		ds.union(1, 2);
		Assert.assertEquals(2, ds.slowFind(1));
		Assert.assertEquals(2, ds.slowFind(2));
		
		ds.union(3, 2);
		Assert.assertEquals(2, ds.slowFind(3));
		Assert.assertEquals(2, ds.slowFind(2));
		
		ds.union(4,3);
		Assert.assertEquals(2, ds.slowFind(4));
		Assert.assertEquals(2, ds.slowFind(3));
	}
	
	@Test
	public void testUnionBySize() {
		DisjointSet ds = new DisjointSet(5);
		ds.makeQuickFindSet();

		ds.unionBySize(0, 0);
		Assert.assertEquals(0, ds.quickFind(0));
		
		ds.unionBySize(0, 1);
		Assert.assertEquals(1, ds.quickFind(0));
		Assert.assertEquals(1, ds.quickFind(1));

		ds.unionBySize(3, 4);
		Assert.assertEquals(4, ds.quickFind(3));
		Assert.assertEquals(4, ds.quickFind(4));
		
		ds.unionBySize(3,0);
		Assert.assertEquals(1, ds.quickFind(4));
		Assert.assertEquals(1, ds.quickFind(3));
		
		ds.unionBySize(1, 2);
		System.out.println(Arrays.toString(ds.getSet()));
		Assert.assertEquals(1, ds.quickFind(1));
		Assert.assertEquals(1, ds.quickFind(2));
	}

	@Test
	public void testUnionByRank() {
		DisjointSet ds = new DisjointSet(5);
		ds.makeQuickFindSet();

		ds.unionByRank(0, 0);
		Assert.assertEquals(0, ds.quickFind(0));
		
		ds.unionByRank(0, 1);
		Assert.assertEquals(1, ds.quickFind(0));
		Assert.assertEquals(1, ds.quickFind(1));
		
		ds.unionByRank(3, 4);
		Assert.assertEquals(4, ds.quickFind(3));
		Assert.assertEquals(4, ds.quickFind(4));
		
		ds.unionByRank(3,0);
		Assert.assertEquals(1, ds.quickFind(3));
		Assert.assertEquals(1, ds.quickFind(0));
		
		ds.unionByRank(1, 2);
		Assert.assertEquals(1, ds.quickFind(1));
		Assert.assertEquals(1, ds.quickFind(2));
	}
}
