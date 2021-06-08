package JavaQuestionThreeTest;

import JavaQuestionThree.Node;
import JavaQuestionThree.DependencyGraph;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


//@TestInstance(Lifecycle.PER_CLASS)
class DependencyGraphTest extends DependencyGraph {
    DependencyGraph graphTest = new DependencyGraph(5);

    @Before
    public void setUp()  {
        DependencyGraphTest dgt = new DependencyGraphTest();
        Node n1 = new Node(0,"A");
        Node n2 = new Node(1,"B");
        Node n3 = new Node(2,"C");
        Node n4 = new Node(3,"D");
        Node n5 = new Node(4,"E");

        graphTest.addNode(0, n1);
        graphTest.addNode(1, n2);
        graphTest.addNode(2, n3);
        graphTest.addNode(3, n4);
        graphTest.addNode(4, n5);

        graphTest.addDependency(0,1);
        graphTest.addDependency(0,2);
        graphTest.addDependency(1,3);
        graphTest.addDependency(3,2);
        graphTest.addDependency(1,4);
    }

    @Test
    void testGetParents() {
        ArrayList<Integer> expectedOutput = new ArrayList<Integer>(Arrays.asList(0,3));
        ArrayList<Integer> parents = getParents(graphTest.getDependancyGraph(),2);
        assertArrayEquals(parents.toArray(),expectedOutput.toArray());
    }

    @Test
    void testGetChildren() {
        ArrayList<Integer> expectedOutput = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> parents = getChildren(graphTest.getDependancyGraph(),3);
        assertArrayEquals(parents.toArray(),expectedOutput.toArray());
    }

    @Test
    void testGetAncestors() {
        ArrayList<Integer> expectedOutput = new ArrayList<Integer>(Arrays.asList(1,0));
        ArrayList<Integer> parents = getAncestors(graphTest.getDependancyGraph(),3);
        assertArrayEquals(parents.toArray(),expectedOutput.toArray());
    }

    @Test
    void testGetDescendents() {
        ArrayList<Integer> expectedOutput = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> parents = getDescendents(graphTest.getDependancyGraph(),3);
        assertArrayEquals(parents.toArray(),expectedOutput.toArray());
    }

    @Test
    void testAddDependency() {
        assertFalse(addDependency(1,3));
    }

    @Test
    void testDeleteDependency() {
        assertTrue(deleteDependency(graphTest.getDependancyGraph(),1));
    }

    @Test
    void testDeleteDependencyOne() {
        assertTrue(deleteDependency(graphTest.getDependancyGraph(),1,3));
    }
}