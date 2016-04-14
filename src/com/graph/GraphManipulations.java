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

		rootQueue.add(startingAt);
		visited[startingAt] = true;
		System.out.print(startingAt + " ");

		while (!rootQueue.isEmpty()) {
			int i = rootQueue.poll();
			for (int j = 0; j < g.getVertices(); j++) {
				if (g.hasEdge(i, j) && !visited[j]) {
					System.out.print(j + " ");
					visited[j] = true;
					rootQueue.add(j);
				}
			}
		}
		clearVisited();
	}

	public void DFSRecursive(int startingAt) {
		visited[startingAt] = true;
		System.out.print(startingAt + " ");

		for (int i = 0; i < visited.length; i++) 
			if (g.hasEdge(startingAt, i) && !visited[i])
				DFSRecursive(i);
	}

	public void DFS(int startingAt) {
		Stack<Integer> rootStack = new Stack<Integer>();
		rootStack.push(startingAt);
		
		while (!rootStack.isEmpty()) {
			int i = rootStack.pop();

			if (!visited[i]) {
				visited[i] = true;
				System.out.print(i + " ");

				for (int j = visited.length - 1; j > 0 ; j--)
					if (g.hasEdge(i, j) && !visited[j])
						rootStack.push(j);
			}
		}
		
		clearVisited();
	}
}
