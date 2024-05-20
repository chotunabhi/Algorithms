package com.graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GraphManipulations {
	private Graph g;
	boolean visited[];

	public GraphManipulations(Graph g) {
		super();
		this.g = g;
		visited = new boolean[g.getVertices()];
	}

	private void clearVisited() {
		visited = new boolean[g.getVertices()];
	}

	private boolean allVisited() {
		int visitedCount = 0;
		
		for (boolean b : visited) 
			if(b)
				visitedCount++;
		
		return (visitedCount == visited.length || visitedCount == visited.length - 1);
	}
	public void BFS(int startingAt) {
		Queue<Integer> rootQueue = new ConcurrentLinkedQueue<Integer>();

		
		clearVisited();
	}

	public void DFSRecursive(int startingAt) {
		
	}

	public void DFS(int startingAt) {
		
		
		clearVisited();
	}
}
