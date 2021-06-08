package JavaQuestionThree;

import java.util.ArrayList;
import java.util.Iterator;

public class Dfs {


    public void dfsUtil(int v, boolean visited[], ArrayList<Integer>[] depGraph, ArrayList<Integer> resultofDFS, int level)
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        resultofDFS.add(v);
  
		// Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = depGraph[v].listIterator(); 
        while (i.hasNext()) {
            int n = i.next(); 
            if(level==1)
            	return;
            if (!visited[n])
                dfsUtil(n, visited,depGraph,resultofDFS,level+1);
        }
        return ;
    } 
 
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    public ArrayList<Integer> dfs(int v, int startingNode, ArrayList<Integer> depGraph[], int level)
    {  
        boolean visited[] = new boolean[v]; 
        
        ArrayList<Integer> resultofDFS= new ArrayList<Integer>();
        dfsUtil(startingNode, visited,depGraph,resultofDFS,level);
        resultofDFS.remove(0);
        
        return resultofDFS;
    } 
}
