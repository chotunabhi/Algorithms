package com.graph;

public class Graph {
	private int vertices;
	private boolean[][] adj;

	public int getVertices() {
		return vertices;
	}

	public Graph(int vertices) {
		super();
		this.vertices = vertices;

		adj = new boolean[vertices][vertices];

		for (int i = 0; i < vertices; i++)
			adj[i] = new boolean[vertices];
	}

	public void addEdge(int v, int w) {
		adj[v][w] = true;
		adj[w][v] = true;
	}

	public boolean hasEdge(int v, int w) {
		return adj[v][w];
	}

	public void printGraph() {
		StringBuilder sb = new StringBuilder("head : ");
		for (int i = 0; i < vertices; i++) {
			boolean hasChild = false;
			
			for (int j = i + 1; j < vertices; j++) {
				if(adj[i][j]){
					if(!hasChild){
						System.out.println( i +  " -- " + j);
						hasChild = true;
					}else
						System.out.println(" | __ "+ j);
				}
			}
			if(!hasChild)
				continue;

		}
	}
}
