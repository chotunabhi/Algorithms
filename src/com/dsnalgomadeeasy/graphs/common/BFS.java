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

		return path;
	}
}
