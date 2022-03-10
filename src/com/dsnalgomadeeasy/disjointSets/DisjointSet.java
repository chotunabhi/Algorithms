package com.dsnalgomadeeasy.disjointSets;

public class DisjointSet {
	private int set[];
	private int size;
	
	public DisjointSet(int size) {
		this.size = size;
		set = new int[size];
	}
	
	public void makeSlowFindSet() {
		for(int i = 0 ; i < size; i++)
			set[i] = i;
	}
	
	public void makeQuickFindSet() {
		for(int i = 0 ; i < size; i++)
			set[i] = -1;
	}
	
	public int slowFind(int x) {
		if(x < 0 || x >= size)
			return Integer.MIN_VALUE;
		
		if(set[x] == x)
			return x;
		else
			return slowFind(set[x]);
	}
	
	public void union(int root1,int root2) {
		if(slowFind(root1) == slowFind(root2))
			return;
		if(root1 < 0 || root1 > size || root2 < 0 || root2 > size)
			return;
		
		set[root1] = root2;
	}
	
	public int quickFind(int x) {
		if(x < 0 || x >= size)
			return Integer.MIN_VALUE;
		
		if(set[x] < 0)
			return x;
		else
			return quickFind(set[x]);
	}
	
	public void unionBySize(int element1,int element2) {
		int root1 = quickFind(element1);
		int root2 = quickFind(element2);
		
		if(root1 == root2 && root1 != -1)
			return;
		
		if(set[root1] < set[root2]) {
			set[root1] += set[root2];
			set[root2] = root1;
		}else {
			set[root2] += set[root1];
			set[root1] = root2;
		}
	}
	
	public void unionByRank(int element1,int element2) {
		int root1 = quickFind(element1);
		int root2 = quickFind(element2);
		
		if(root1 == root2 && root1 != -1)
			return;
		
		if(set[root1] < set[root2]) {
			set[root2] = root1;
		}else {
			if(set[root1] == set[root2])
				set[root2]--;
			
			set[root1] = root2;
		}
	}

	public int[] getSet() {
		return set;
	}
}
