package assignment9;

import java.util.*;

class Graph2 {
	class Node {
		int value;
		Node next; 
	}
	
	Node[] g;
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	char[] vertices;
	
	public Graph2(int n) {
		g = new Node[n];
		vertices = new char[n];
	}
	
	public void addVertex(char c, int i) {
		map.put(c, i);
		vertices[i] = c;
	}
	
	public void addEdge(int v1, int v2) {
		if(g[v1] == null) {
			g[v1] = new Node();
			g[v1].value = v2;
			return;
		}
		
		Node temp = g[v1];
		while(temp.next != null)
			temp = temp.next;
		Node newNode = new Node();
		newNode.value = v2;
		temp.next = newNode;
	}
	
	public char vertexAt(int i) {
		return vertices[i];
	}
	
	public int getKey(char c) {
		return map.get(c);
	}
	
	public void printList(int i) {
		Node temp = g[i];
		while(temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}
}

public class Task2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int n = scanner.nextInt();
		scanner.nextLine();
		Graph2 graph = new Graph2(n);
		
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
				graph.addEdge(graph.getKey(c), i);
			}
		}
		scanner.close();
		
		for(int i = 0; i < n; i++) {
			graph.printList(i);
			System.out.println();
		}
	}

}
