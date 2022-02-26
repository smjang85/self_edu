package co.kr.programmers.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph{
	Node[] nodes;
	
	public Node[] getNode() {
		return nodes;
	}
	public Graph(int n, int[][] edge) {
		nodes = new Node[n];
		for(int i = 0; i < n ; i++) {
			nodes[i] = new Node(i + 1);
		}
		
		for(int i = 0; i <edge.length; i++) {
			addEdge(edge[i][0] -1, edge[i][1] -1);
		}
	}
	
	public void addEdge(int a, int b) {
		addEdge(nodes[a], nodes[b]);
	}
	
	private void addEdge(Node a, Node b) {
		if(a.adjacents.contains(b) == false) {
			a.adjacents.add(b);
		}
		
		if(b.adjacents.contains(a) == false) {
			b.adjacents.add(a);
		}
	}
}

class Node{
	int data;
	int distance;
	boolean visit;
	List<Node> adjacents;
	
	public Node(int data) {
		this.data = data;
		adjacents = new LinkedList<>();
	}
}

public class Test01 {
    public static int solution(int n, int[][] edge) {
        Graph graph = new Graph(n, edge);
        int answer = 0;
        int max = bfs(graph,0);
        for (Node node : graph.getNode()) {
        	if(node.distance == max) {
        		answer++;
        	}
        }
        return answer;
    }
    
    public static int bfs(Graph graph, int n) {
    	return bfs(graph.getNode()[n]);
    }
    
    public static int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.visit = true;
        int maxDistance = -1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node adjecent : node.adjacents) {
                if (!adjecent.visit) {
                    adjecent.distance = node.distance + 1;
                    adjecent.visit = true;
                    maxDistance = Math.max(maxDistance, adjecent.distance);
                    queue.add(adjecent);
                }
            }
        }
        
        return maxDistance;
    }
	
	public static void main(String[] args) throws Exception {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, edge));
	}
}
