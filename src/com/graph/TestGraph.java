package com.graph;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		graph.addEdge(2, 1);
		graph.addEdge(2, 0);
		graph.addEdge(2, 4);
		graph.addEdge(0, 3);
		graph.addEdge(4, 3);
		
		graph.printGraph();
		
		GraphManipulations gm = new GraphManipulations(graph);
		gm.BFS(0);
		System.out.println();
		gm.DFS(0);
		System.out.println();
		gm.DFSRecursive(0);
//		gm.DFSRecursive(4);
	}

}
