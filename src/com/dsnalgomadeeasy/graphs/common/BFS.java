package com.dsnalgomadeeasy.graphs.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS<T extends Comparable<T>> {
	private Graph<T> graph;
	private boolean visited[];
	private T vertices[];
	private ArrayList<T> path;

	public BFS(Graph<T> graph, T[] vertices) {
		super();
		this.graph = graph;
		this.vertices = vertices;

		visited = new boolean[vertices.length];
		path = new ArrayList<>();
	}

	public ArrayList<T> breadthFirstSearch(T startVertex) {
		if(graph.getVertices().containsKey(startVertex)) {
			Queue<T> queue = new LinkedList<T>();
			queue.offer(startVertex);
			path.add(startVertex);
			visited[graph.getVertices().get(startVertex)] = true;
			
			while(!queue.isEmpty()) {
				T currentVertex = queue.poll();
				
				for(int i = 0; i < visited.length; i++) {
					if(graph.hasEdge(currentVertex, vertices[i])
						&& !currentVertex.equals(vertices[i])
						&& !visited[i] 
					){
						queue.offer(vertices[i]);
						visited[i] = true;
						path.add(vertices[i]);
					}
				}
			}
		}

		return path;
	}
}
