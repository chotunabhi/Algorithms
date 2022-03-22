package com.dsnalgomadeeasy.graphs.common;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BFSTest {
	String[] vertices;
	String[][] edges;
	String startingVertex;
	String[] expectedResult;

	public BFSTest(String[] vertices, String[][] edges, String startingVertex, String[] expectedResult) {
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
					new String[] { "A", "B", "D", "C" } 
				},
				{ 
					new String[] { "A", "B", "C", "D" },
					new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "A" } }, 
					"A",
					new String[] { "A", "B", "D", "C" } 
				},
				{ 
					new String[] { "A", "B", "C", "D" },
					new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "A" }, { "B", "D" } }, 
					"B",
					new String[] { "B", "A", "C", "D" } 
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
					new String[] { "A", "B", "C", "H", "D", "E", "F", "G" } 
				} 
			}
		);
	}

	@Test
	public void testBFS() {
		Graph<String> graph = new Graph<String>(this.vertices);
		graph.buildGraph(this.edges);

		BFS<String> bfs = new BFS<String>(graph, this.vertices);

		Assert.assertArrayEquals(expectedResult, bfs.breadthFirstSearch(this.startingVertex).toArray());
	}

}
