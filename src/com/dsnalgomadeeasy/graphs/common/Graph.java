package com.dsnalgomadeeasy.graphs.common;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	private int vertexCount;
	private boolean[][] adjMatrix;
	private Map<Object, Integer> vertices;

	public Graph(int vertexCount, Object[] vertices) {
		this.vertexCount = vertexCount;
		this.adjMatrix = new boolean[vertexCount][vertexCount];
		this.vertices = new HashMap<Object, Integer>();

		for (int i = 0; i < vertexCount; i++) {
			this.vertices.put(vertices[i], i);
		}

	}

	public void addEdge(Object source, Object destination) {
		if (!this.vertices.containsKey(source) || !this.vertices.containsKey(destination))
			return;

		int sourceIndex = this.vertices.get(source);
		int destinationIndex = this.vertices.get(destination);

		this.adjMatrix[sourceIndex][destinationIndex] = true;
		this.adjMatrix[destinationIndex][sourceIndex] = true;
	}

	public boolean hasEdge(Object source, Object destination) {
		return this.vertices.containsKey(source) 
				&& this.vertices.containsKey(destination)
				&& this.adjMatrix[this.vertices.get(source)][this.vertices.get(destination)];
	}
}
