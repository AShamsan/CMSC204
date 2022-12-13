
/**
 * @author Abdullah Shamsan
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = new Town("Town#" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Road#1");
		  graph.addEdge(town[1], town[3], 4, "Road#2");
		  graph.addEdge(town[1], town[5], 6, "Road#3");
		  graph.addEdge(town[3], town[7], 1, "Road#4");
		  graph.addEdge(town[3], town[8], 2, "Road#5");
		  graph.addEdge(town[4], town[8], 3, "Road#6");
		  graph.addEdge(town[6], town[9], 3, "Road#7");
		  graph.addEdge(town[9], town[10], 4, "Road#8");
		  graph.addEdge(town[8], town[10], 2, "Road#9");
		  graph.addEdge(town[5], town[10], 5, "Road#10");
		  graph.addEdge(town[10], town[11], 3, "Road#11");
		  graph.addEdge(town[2], town[11], 6, "Road#12");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[2], town[11],6, "Road#12"), graph.getEdge(town[2], town[11]));
		assertEquals(new Road(town[3], town[7],1, "Road#4"), graph.getEdge(town[3], town[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		graph.addEdge(town[3], town[5], 1, "Road_13");
		assertEquals(true, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_12");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		assertEquals(false, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town#2")));
		assertEquals(false, graph.containsVertex(new Town("Town#12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road#1", roadArrayList.get(0));
		assertEquals("Road#10", roadArrayList.get(1));
		assertEquals("Road#11", roadArrayList.get(2));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road#1", roadArrayList.get(0));
		assertEquals("Road#2", roadArrayList.get(1));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		graph.removeEdge(town[2], town[11], 6, "Road#12");
		assertEquals(false, graph.containsEdge(town[2], town[11]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[10]));
	}

	 @Test
	  public void testTown_1ToTown_11() {
		  String beginTown = "Town#1", endTown = "Town#11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town#1 via Road#1 to Town#2 2 mi",path.get(0).trim());
			  assertEquals("Town#2 via Road#12 to Town#11 6 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_10() {
		  String beginTown = "Town#1", endTown = "Town#10";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town#1 via Road#2 to Town#3 4 mi",path.get(0).trim());
			  assertEquals("Town#3 via Road#5 to Town#8 2 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_11() {
		  String beginTown = "Town#4", endTown = "Town#11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town#4 via Road#6 to Town#8 3 mi",path.get(0).trim());
			  assertEquals("Town#8 via Road#9 to Town#10 2 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}