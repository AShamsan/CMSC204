import java.util.ArrayList;

public class Road implements Comparable<Road>{

	private String roadName = "";
	private int weight = 0;
	private Town source = null, destination = null;
	
	ArrayList <Integer>nw = new ArrayList <Integer>();	
	
	
	public Road (Town source, Town destination, int degrees, String roadName){
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.roadName = roadName;
		
//		nw.get(nw.indexOf(3));
	}
	
	public Road (Town source, Town destination, String roadName){
		this.source = source;
		this.destination = destination;
		this.weight = 1;
		this.roadName = roadName;
	}
	
	
	
	public boolean contains(Town town) {
		return this.source.equals(town) || this.destination.equals(town);

	}
	//Town_2 to Town_11 via Road_12
	//Town_2 to Town_11 via Road_12
	@Override
	public String toString() {
		return source + " to " + destination + " via " + getName();
	}
	
	
	
	public String getName() {
		return roadName;
	}

	public void setName(String roadName) {
		this.roadName = roadName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Town getSource() {
		return source;
	}

	public void setSource(Town source) {
		this.source = source;
	}

	public Town getDestination() {
		return destination;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}

	@Override
	public int compareTo(Road o) {
		return this.getWeight() - o.getWeight();

	}
	
	@Override
	public boolean equals(Object o) {
		Road tempRoad = (Road)o;

//		return ((this.source.equals(tempRoad.source) || this.source.equals(tempRoad.destination)) && 
//				(this.destination.equals(tempRoad.destination) || this.destination.equals(tempRoad.source)) &&
//						(this == tempRoad));
		
		return (this.toString().equals(tempRoad.toString()));
	}
	
}
