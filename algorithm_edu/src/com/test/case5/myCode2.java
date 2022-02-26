package com.test.case5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

class Graph{
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph (int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
		visited[v] = true;
		Integer i;

		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();

			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v)) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

	Boolean isCyclic() {
		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}
		
		for (int u = 0; u < V; u++) {
			if (!visited[u]) {
				if (isCyclicUtil(u, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
}

public class myCode2 {
	public static void main(String args[]) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeCnt = Integer.parseInt(br.readLine());

		Graph graph = new Graph(nodeCnt);
		
		for(int i = 0 ; i < nodeCnt; i++) {
			String inputArr = br.readLine();
			try {
				String[] input = inputArr.split(" ");
				graph.addEdge(new Integer(input[0]), new Integer(input[1]));	
			}catch(Exception e) {
				
			}
		}
		
		if (graph.isCyclic()) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
}
