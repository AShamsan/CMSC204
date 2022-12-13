
/**
 * @author Abdullah Shamsan
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph = new Graph();
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		try {
			graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(new Town(town1), new Town(town2)).getName();

	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));

	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		for (Town tempTown : graph.vertexSet()) {
			if (tempTown.getName().equals(name)) {
				return tempTown;
			}
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));

	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));

	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();

		for (Road tempRoad: graph.edgeSet()) {
			roads.add(tempRoad.getName());
		}

		Collections.sort(roads);
		return roads;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		int weight = 0;

		for (Road tempRoad : graph.edgeSet()) {
			if (tempRoad.getName().equals(getRoad(town1, town2)))
				weight = tempRoad.getWeight();
		}

		return graph.removeEdge(new Town(town1), new Town(town2), weight, road) != null;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(getTown(v));

	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<>();

		for (Town towns : graph.vertexSet())
			allTowns.add(towns.getName());

		Collections.sort(allTowns);
		return allTowns;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));

	}

	/**
	 * 
	 * @param selectedFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException,IOException{
		String[] temp;
		String str;

		Scanner fileScanner = new Scanner(selectedFile);

		while (fileScanner.hasNextLine()) {
			str = fileScanner.nextLine();
			temp = str.split(",|;");
			graph.addVertex(new Town(temp[2]));
			graph.addVertex(new Town(temp[3]));
			graph.addEdge(new Town(temp[2]), new Town(temp[3]), Integer.parseInt(temp[1]), temp[0]);
		}
		fileScanner.close();
	
	}

}
