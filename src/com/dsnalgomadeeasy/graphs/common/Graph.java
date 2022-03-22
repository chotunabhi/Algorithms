package com.dsnalgomadeeasy.graphs.common;

import java.util.HashMap;
import java.util.Map;

public class Graph<T extends Comparable<T>> {
	private int vertexCount;
	private boolean[][] adjMatrix;
	private Map<T, Integer> vertices;

	public Graph( T[] vertices) {
		this.vertexCount = vertices.length;
		this.adjMatrix = new boolean[vertexCount][vertexCount];
		this.vertices = new HashMap<T, Integer>();

		for (int i = 0; i < vertexCount; i++) {
			this.vertices.put(vertices[i], i);
		}

	}

	public void addEdge(T source, T destination) {
		if (!this.vertices.containsKey(source) || !this.vertices.containsKey(destination))
			return;

		int sourceIndex = this.vertices.get(source);
		int destinationIndex = this.vertices.get(destination);

		this.adjMatrix[sourceIndex][destinationIndex] = true;
		this.adjMatrix[destinationIndex][sourceIndex] = true;
	}

	public boolean hasEdge(T source, T destination) {
		return this.vertices.containsKey(source) 
				&& this.vertices.containsKey(destination)
				&& this.adjMatrix[this.vertices.get(source)][this.vertices.get(destination)];
	}

	public void buildGraph(T[][] edges) {
		for(T[] edge:edges) {
			addEdge(edge[0], edge[1]);
		}
	}
	
	public int getVertexCount() {
		return vertexCount;
	}

	public boolean[][] getAdjMatrix() {
		return adjMatrix;
	}

	public Map<T, Integer> getVertices() {
		return vertices;
	}
}
