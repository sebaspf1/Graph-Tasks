package assignment9;

import java.util.*;

class Graph {
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	int[][] g;
	char[] vertices;
	
	public Graph(int n) {
		g = new int[n][n];
		vertices = new char[n];
	}
	
	public char vertexAt(int i) {
		return vertices[i];
	}
	
	public void addVertex(char c, int i) {
		map.put(c, i);
		vertices[i] = c;
	}
	
	public void addEdge(char v1, char v2) {
		g[map.get(v1)][map.get(v2)] = 1;
	}
	
	public int getEdge(int i, int j) {
		return g[i][j];
	}
}

public class Task1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of vertices");
		int n = scanner.nextInt();
		scanner.nextLine();
		Graph graph = new Graph(n);
		
		System.out.println("Enter list of vertices");
		String s = scanner.nextLine();
		for(int i = 0; i < n; i++) {
			char c = s.charAt(2*i);
			graph.addVertex(c, i);
		}
		
		System.out.println("Enter 1 for yes and 0 for no");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					System.out.println("Does " + graph.vertexAt(i) + " have an adge with " + graph.vertexAt(j));
					int b = scanner.nextInt();
					if(b > 0)
						graph.addEdge(graph.vertexAt(i), graph.vertexAt(j));
				}
			}
		}
		
		scanner.close();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(graph.getEdge(i, j) + " ");
			}
			System.out.println();
		}
	}

}
