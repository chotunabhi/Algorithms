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

		return path;
	}

	public ArrayList<T> depthFirstSearchIterative(T startVertex) {
		return path;
	}
}
