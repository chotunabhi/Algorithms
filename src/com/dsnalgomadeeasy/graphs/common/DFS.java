package com.dsnalgomadeeasy.graphs.common;

import java.util.ArrayList;
import java.util.Stack;

public class DFS<T extends Comparable<T>> {
	private Graph<T> graph;
	private boolean visited[];
	private T vertices[];
	private ArrayList<T> path;

	public DFS(Graph<T> graph, T[] vertices) {
		super();
		this.graph = graph;
		this.vertices = vertices;

		visited = new boolean[vertices.length];
		path = new ArrayList<>();
	}

	public ArrayList<T> depthFirstSearch(T startVertex) {
		int verticeIndex = graph.getVertices().get(startVertex);

		if (!visited[verticeIndex]) {
			path.add(startVertex);
			visited[verticeIndex] = true;

			for (int i = 0; i < visited.length; i++) {
				if (graph.hasEdge(startVertex, this.vertices[i]) && !startVertex.equals(this.vertices[i]))
					depthFirstSearch(this.vertices[i]);
			}
		}

		return path;
	}

	public ArrayList<T> depthFirstSearchIterative(T startVertex) {
		if (!graph.getVertices().containsKey(startVertex))
			return path;

		Stack<T> vertexStack = new Stack<>();
		vertexStack.push(startVertex);
		Integer currentVertexIndex = graph.getVertices().get(startVertex);
		path.add(startVertex);
		visited[currentVertexIndex] = true;

		while (!vertexStack.isEmpty()) {
			T currentVertex = vertexStack.peek();
			int nextVertexIndex = -1;

			for (int i = 0; i < visited.length; i++) {
				if (graph.hasEdge(currentVertex, this.vertices[i]) && !currentVertex.equals(this.vertices[i])
						&& !visited[i]) {
					nextVertexIndex = i;
					break;
				}
			}

			if (nextVertexIndex == -1) {
				vertexStack.pop();
			} else {
				visited[nextVertexIndex] = true;
				path.add(vertices[nextVertexIndex]);
				vertexStack.push(vertices[nextVertexIndex]);
			}
		}
		return path;
	}
}
