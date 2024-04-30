package assignment9;

import java.util.*;

class Graph3 {
	ArrayList<Integer>[] g;
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	char[] vertices;
	
	@SuppressWarnings("unchecked")
	public Graph3(int n) {
		vertices = new char[n];
		g = new ArrayList[n];
		for(int i = 0; i < n; i++) 
			g[i] = new ArrayList<Integer>();
	}
	
	public void addVertex(char c, int i) {
		map.put(c, i);
		vertices[i] = c;
	}
	
	public char vertexAt(int i) {
		return vertices[i];
	}
	
	public int getKey(char c) {
		return map.get(c);
	}
	
	public void addEdge(int v1, int v2) {
		g[v1].add(v2);
	}
	
	public void printEdges(int i) {
		System.out.println(g[i]);
	}
}

public class Task3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int n = scanner.nextInt();
		scanner.nextLine();
		Graph3 graph = new Graph3(n);
		
		System.out.println("Enter list of vertices");
		String s = scanner.nextLine();
		for(int i = 0; i < n; i++) {
			char c = s.charAt(2*i);
			graph.addVertex(c, i);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println("How many edges are associated with " + graph.vertexAt(i));
			int m = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter adjacent vertices to " + graph.vertexAt(i));
			s = scanner.nextLine();
			for(int j = 0; j < m; j++) {
				char c = s.charAt(2*j);
				graph.addEdge(i, graph.getKey(c));
			}
		}
		scanner.close();
		
		for(int i = 0; i < n; i++) {
			graph.printEdges(i);
		}
	}

}
