package JavaQuestionThree;


import java.util.*;

public class DependencyGraph implements Operations {

	public ArrayList<Integer> depGraph[];
	public int vertices; 
	public Map<Integer,Node> nodesOfGraph = new HashMap<Integer,Node>() ;
	public boolean hasCycle=false;

	Dfs dfsObj = new Dfs();

	public DependencyGraph(int v) {
		this.vertices=v;
		depGraph = new ArrayList[v];
		for(int index=0;index<v;index++) {
			depGraph[index]= new ArrayList<>();
		}
	}
	public DependencyGraph() {
		this.vertices=5;
	}

	public ArrayList<Integer>[] getDependancyGraph() {
		return depGraph;
	}
	public void displayGraph(ArrayList<Integer> depGraph[]) {
		
		int flag;
		for(int index=0;index<depGraph.length;index++) {
			flag=1;
			if(depGraph[index].size()!=0)
				System.out.print(index + " --->");
			for(int j=0;j<depGraph[index].size();j++) {
				System.out.print(depGraph[index].get(j)+" ");
				flag=0;
			}
			if(flag==0)
				System.out.println();
		}
	}
	
	public ArrayList<Integer>[] reverseDependency(ArrayList<Integer> depgraph[],int vertices) {
		
		ArrayList<Integer> revDependency[]= new ArrayList[vertices];
		for(int index=0;index<vertices;index++) {
			revDependency[index]= new ArrayList<>();
		}
		
		for(int index=0;index<vertices;index++) {
			for(int j=0;j<depgraph[index].size();j++) {
				if(depgraph[index].get(j)!=null) {
					revDependency[depgraph[index].get(j)].add(index);
				}
			}
		}
		return revDependency;
	}
	
	@Override
	public void addNode(int id, Node n) {
		nodesOfGraph.put(id, n);		
	}

	@Override
	public ArrayList<Integer> getParents(ArrayList<Integer> depgraph[],int id) {
		
		ArrayList<Integer> revDependency[];
		revDependency= reverseDependency(depgraph,vertices);
		int level=0 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.dfs(vertices,id, revDependency,level);
	}

	@Override
	public ArrayList<Integer> getChildren(ArrayList<Integer> depgraph[],int id) {
		int level=0 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.dfs(vertices,id,depgraph,level);
	}

	@Override
	public ArrayList<Integer> getAncestors(ArrayList<Integer> depgraph[],int id) {
		ArrayList<Integer> revDependency[];
		revDependency= reverseDependency(depgraph,vertices);
		int level=2 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.dfs(vertices,id, revDependency,level);
	}

	@Override
	public ArrayList<Integer> getDescendents(ArrayList<Integer> depgraph[],int id) {
		// To find parent pass level as 0, if ancestor pass level any value greater than 1
		int level=2 ;  
		return dfsObj.dfs(vertices,id,depgraph,level);
	}

	@Override
	public boolean addDependency(int id1, int id2) {
		
		if(!(nodesOfGraph.containsKey(id1) & nodesOfGraph.containsKey(id2))) {
			System.out.println("The Specified Node/Nodes doesn't exist !!");
			return false;
		}
		
		depGraph[id1].add(id2);
		
		//Check for cycle and Remove if it exists
		CheckCycle cycle = new CheckCycle();
		hasCycle=cycle.checkCycles(depGraph, id1, id2, vertices);
		if(hasCycle) {
			System.out.println("This edge Can't be added . It Would Cause a cycle");
			for(int j=0;j<depGraph[id1].size();j++) {
				if(depGraph[id1].get(j)==id2)
					// Removing the edge since it is already added
					depGraph[id1].remove(j);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDependency(ArrayList<Integer> depgraph[],int id) {

		depgraph[id].clear();
		
		for(int i=0;i<depgraph.length;i++) {
			for(int j=0;j<depgraph[i].size();j++) {
				if(depgraph[i].get(j)==id) {
					depgraph[i].remove(j);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteDependency(ArrayList<Integer> depgraph[],int parentId, int childId) {
		
		for(int index=0;index<depgraph[parentId].size();index++) {
			if(depgraph[parentId].get(index)==childId) {
				depgraph[parentId].remove(index);
				return true;
			}
		}
		return false;
	}

}
