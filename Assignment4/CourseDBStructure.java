/**
 * @author Abdullah Shamsan
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	int size;
	int tableLength;
	LinkedList<CourseDBElement> [] dataArray;
	ArrayList<String> data;
	
	/**
	 * 
	 * @param n
	 */
	public CourseDBStructure(int n) {
		double loadFactor = 1.5;
		tableLength = fourKPlus3(n, loadFactor);
		dataArray = new LinkedList[tableLength];
		size =0;
		data = new ArrayList<String>();
}

	
	/**
	 * 
	 * @param string
	 * @param i
	 */
	public CourseDBStructure(String string, int i) {
		tableLength = 20;
		dataArray = new LinkedList[tableLength];
		size = 0;
		data = new ArrayList<String>();

	}

	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override 
	public void add(CourseDBElement cde1) {
		boolean unEmpty = false;
		Integer tempInteger = cde1.getCRN();
		
		int hashIndex = tempInteger.hashCode()%tableLength;
		if (dataArray[hashIndex] == null) {
			dataArray[hashIndex] = new LinkedList<CourseDBElement>();
			data.add(cde1.toString());	
		}
		else {
			for(int i = 0; i <dataArray[hashIndex].size(); i++) {
				
				if (dataArray[hashIndex].get(i).compareTo(cde1) == 0) {
					dataArray[hashIndex].set(i, cde1);
					unEmpty = true;
				}
			}
		}	
		if(!(unEmpty)) {
			dataArray[hashIndex].add(cde1);
			size++;
		}
	}

	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		boolean unEmpty = false;		
		Integer tempInteger = crn;
		int hashIndex = tempInteger.hashCode()%tableLength;
		
//		String tempString = "" + crn;
//		int ijk = tempString.hashCode()%tableLength;
		if(dataArray [hashIndex] != null) {
			for(int i = 0; i < dataArray[hashIndex].size(); i++) {
				if (dataArray[hashIndex].get(i).getCRN() == (int)crn){
					return dataArray[hashIndex].get(i);
				}
			}
		}
		throw new IOException();
	}
	
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		
		ArrayList <String> stringList = new ArrayList<String>(size);
		for (int i =0; i< dataArray.length; i++) {
			if (dataArray[i] != null) {
				for(int j=0; j<dataArray[i].size(); j++)
                {
                    stringList.add(dataArray[i].get(j).toString());
                }
			}
		}
		return stringList;
	}

	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return tableLength;
	}

	/**
	 * find prime number using 4K+3
	 * @param n
	 * @param loadfactor
	 * @return
	 */
	public static int fourKPlus3(int n, double loadfactor)
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;
	  

	   prime = (int)(n/loadfactor);
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;

	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   } // end of 4k+3 prime search loop
	   return prime;
	}


}
