

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListStudentTest {
	BasicDoubleLinkedList<String> linStr;
	BasicDoubleLinkedList<Double> linDoub;
	BasicDoubleLinkedList<Car> linCar;
	StringComparator comparatorStr;
	DoubleComparator comparatorDoub;
	CarComparator comparatorCar;
	
	public Car a=new Car("Nissan", "Armada", 2009);
	public Car b=new Car("Toyota", "LandCruiser", 2006);
	public Car c=new Car("Honda", "Civic", 2015);
	public Car d=new Car("Mitsubichi", "Lancer", 2005);


	public ArrayList<Car> fill = new ArrayList<Car>();
	

	@Before
	public void setUp() throws Exception {
		linStr = new BasicDoubleLinkedList<String>();
		linStr.addToEnd("Howdy");
		linStr.addToEnd("World");
		comparatorStr = new StringComparator();
		
		linDoub = new BasicDoubleLinkedList<Double>();
		linDoub.addToEnd(20.0);
		linDoub.addToEnd(90.0);
		comparatorDoub = new DoubleComparator();
		
		linCar= new BasicDoubleLinkedList<Car>();
		linCar.addToEnd(b);
		linCar.addToEnd(c);
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linStr = null;
		linDoub = null;
		linCar = null;
		comparatorDoub = null;
		comparatorStr = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linStr.getSize());
		assertEquals(2,linDoub.getSize());
		assertEquals(2,linCar.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linStr.getLast());
		linStr.addToEnd("End");
		assertEquals("End", linStr.getLast());
		
		assertEquals(c,linCar.getLast());
		linCar.addToEnd(d);
		assertEquals(d,linCar.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Howdy", linStr.getFirst());
		linStr.addToFront("Begin");
		assertEquals("Begin", linStr.getFirst());
		
		assertEquals(b,linCar.getFirst());
		linCar.addToFront(a);
		assertEquals(a,linCar.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Howdy", linStr.getFirst());
		linStr.addToFront("New");
		assertEquals("New", linStr.getFirst());
		
		assertEquals(b,linCar.getFirst());
		linCar.addToFront(a);
		assertEquals(a,linCar.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linStr.getLast());
		linStr.addToEnd("New");
		assertEquals("New", linStr.getLast());
		
		assertEquals(c,linCar.getLast());
		linCar.addToEnd(d);
		assertEquals(d,linCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		linCar.addToFront(a);
		linCar.addToEnd(d);
		list = linCar.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linStr.addToFront("Begin");
		linStr.addToEnd("End");
		ListIterator<String> iterator = linStr.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Howdy", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linCar.addToFront(a);
		linCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(c, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linCar.addToFront(a);
		linCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linCar.addToFront(a);
		linCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linCar.addToFront(a);
		linCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linCar.addToFront(a);
		linCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linCar.getFirst());
		assertEquals(c, linCar.getLast());
		linCar.addToFront(a);
		assertEquals(a, linCar.getFirst());
		linCar.remove(a, comparatorCar);
		assertEquals(b, linCar.getFirst());
		//remove from the end of the list
		linCar.addToEnd(d);
		assertEquals(d, linCar.getLast());
		linCar.remove(d, comparatorCar);
		assertEquals(c, linCar.getLast());
		//remove from middle of list
		linCar.addToFront(a);
		assertEquals(a, linCar.getFirst());
		assertEquals(c, linCar.getLast());
		linCar.remove(b, comparatorCar);
		assertEquals(a, linCar.getFirst());
		assertEquals(c, linCar.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linCar.getFirst());
		linCar.addToFront(a);
		assertEquals(a, linCar.getFirst());
		assertEquals(a, linCar.retrieveFirstElement());
		assertEquals(b,linCar.getFirst());
		assertEquals(b, linCar.retrieveFirstElement());
		assertEquals(c,linCar.getFirst());
		
		assertEquals("Howdy", linStr.getFirst());
		linStr.addToFront("New");
		assertEquals("New", linStr.getFirst());
		assertEquals("New", linStr.retrieveFirstElement());
		assertEquals("Howdy",linStr.getFirst());
		assertEquals("Howdy", linStr.retrieveFirstElement());
		assertEquals("World",linStr.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linCar.getLast());
		linCar.addToEnd(d);
		assertEquals(d, linCar.getLast());
		assertEquals(d, linCar.retrieveLastElement());
		assertEquals(c,linCar.getLast());
		
		assertEquals("World", linStr.getLast());
		linStr.addToEnd("New");
		assertEquals("New", linStr.getLast());
		assertEquals("New", linStr.retrieveLastElement());
		assertEquals("World",linStr.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
