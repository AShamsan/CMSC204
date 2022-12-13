
public class Town implements Comparable<Town>{

	private String name;
	
	Town(String name){
		
		this.name = name;
	}
	
	Town(Town tempelateTown){
		
		this.name = tempelateTown.getName();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		Town tempTown = (Town)o;
		
		return ((this.name.toLowerCase().equals(tempTown.getName().toLowerCase())) || this == tempTown);
	}

	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		
		return this.name.hashCode();
	}
	
	@Override
	public String toString(){
		
		return this.getName();
	}
}
