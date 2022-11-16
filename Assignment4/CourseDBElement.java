/**
 * 
 * @author Abdullah Shamsan
 *
 */
public class CourseDBElement implements Comparable{
	
	private String id; 
	private int crn;
	private int  credits; 
	private  String roomNum;
	private String instructor;
	
	/**
	 * 
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this .id = id; 
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
		
	}

	/**
	 * 
	 */
	public CourseDBElement() {
		this .id = null; 
		this.crn = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}



	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String room) {
		this.roomNum = room;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	@Override
	public int compareTo(Object o) {
		CourseDBElement other = (CourseDBElement) o;
		if (this.crn == other.crn)
			return 0;
		else if (this.crn > other.crn)
			return 1;
		else 
			return -1;
	
		
	}
	
	@Override
	public String toString() {
		return "\nCourse:" + this.id + " CRN:" + this.crn  + " Credits:" + this.credits + " Instructor:" + this.instructor + " Room:" + this.roomNum;
	}

	
	@Override
	public boolean equals(Object o) {
		if(this.crn==(((CourseDBElement) o).getCRN()))
			return true;
		else
			return false;
	}	
	
}

