package JavaQuestionThree;

import java.util.ArrayList;

public interface Operations {
	
	public void addNode(int id, Node n);
	
	public ArrayList<Integer> getParents(ArrayList<Integer> depgraph[],int id);
	
	public ArrayList<Integer> getChildren(ArrayList<Integer> depgraph[],int id);
	
	public ArrayList<Integer> getAncestors(ArrayList<Integer> depgraph[],int id);
	
	public ArrayList<Integer> getDescendents(ArrayList<Integer> depgraph[],int id);
	
	public boolean addDependency(int id1, int id2);
	
	public boolean deleteDependency(ArrayList<Integer> depgraph[],int id);
	
	public boolean deleteDependency(ArrayList<Integer> depgraph[],int parentId, int childId);
}
