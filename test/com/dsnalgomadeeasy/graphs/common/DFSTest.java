package com.dsnalgomadeeasy.graphs.common;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.dsnalgomadeeasy.graphs.common.DFS;
import com.dsnalgomadeeasy.graphs.common.Graph;

@RunWith(Parameterized.class)
public class DFSTest {
	String[] vertices;
	String[][] edges;
	String startingVertex;
	String[] expectedResult;

	public DFSTest(String[] vertices, String[][] edges, String startingVertex, String[] expectedResult) {
		super();
		this.vertices = vertices;
		this.edges = edges;
		this.startingVertex = startingVertex;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] {
				{ 
					new String[] { "A", "B", "C", "D" },
					new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "A" }, { "B", "D" } },
					"A",
					new String[] { "A", "B", "C", "D" } 
				},
				{ 
					new String[] { "A", "B", "C", "D" },
					new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "A" } }, 
					"A",
					new String[] { "A", "B", "C", "D" } 
				},
				{ 
					new String[] { "A", "B", "C", "D" },
					new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "A" }, { "B", "D" } }, 
					"B",
					new String[] { "B", "A", "D", "C" } 
				},
				{
					new String[] { "A", "B", "C", "D" },
					new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "A" }, { "B", "D" },{ "A", "C" } },
					"A", 
					new String[] { "A", "B", "C", "D" } 
				},
				{ 
					new String[] { "A", "B", "C", "D", "E", "F", "G","H" },
					new String[][] { { "A", "B" }, { "B", "H" }, { "B", "C" }, { "H", "E" }, { "C", "E" },{ "C", "D" }, { "E", "F" }, { "E", "G" } },
					"A", 
					new String[] { "A", "B", "C", "D", "E", "F", "G", "H" } 
				} 
			}
		);
	}

	@Test
	public void testDFS() {
		Graph<String> graph = new Graph<String>(this.vertices);
		graph.buildGraph(this.edges);

		DFS<String> dfs = new DFS<String>(graph, this.vertices);

		Assert.assertArrayEquals(expectedResult, dfs.depthFirstSearch(this.startingVertex).toArray());
	}

	@Test
	public void testDFSIterative() {
		Graph<String> graph = new Graph<String>(this.vertices);
		graph.buildGraph(this.edges);

		DFS<String> dfs = new DFS<String>(graph, this.vertices);

		Assert.assertArrayEquals(expectedResult, dfs.depthFirstSearchIterative(this.startingVertex).toArray());
	}

}
