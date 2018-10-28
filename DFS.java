import java.util.*;
public class DFS {
	public static class Graph{
		public static class Vertex{
			public String name;
			public boolean visited;
			public Vertex parent;
			public ArrayList<Vertex> adjVertices;
			public Vertex(){
				adjVertices = new ArrayList<Vertex>(); 
			}
			public Vertex(String name){
				this.name= name;
				adjVertices = new ArrayList<Vertex>(); 
			}
		}
		public static class Edge {
			public Vertex u;
			public Vertex v;
			public int w;
			public Edge(Vertex v1, Vertex v2){
				u = v1;
				v = v2;
			}
		}
		public ArrayList<Vertex> vertices;
		public ArrayList<Edge> edges;
		Graph(ArrayList<Vertex> V, ArrayList<Edge> E){
			vertices = V;
			edges = E;
		}
	}
	public static void main(String[] args) {
		ArrayList<DFS.Graph.Vertex> V = new ArrayList<DFS.Graph.Vertex>();
		ArrayList<DFS.Graph.Edge> E = new ArrayList<DFS.Graph.Edge>();
		Graph G = new Graph(V, E);
		for(DFS.Graph.Vertex v : G.vertices) {
			if(!v.visited) {
				DFSVisit(v);
			}
		}
	}
	public static void DFSVisit(DFS.Graph.Vertex u) {
		u.visited = true;
		for(DFS.Graph.Vertex v : u.adjVertices) {
			if(!v.visited) {
				v.parent = u;
				DFSVisit(v);
			}
		}
	}
}
