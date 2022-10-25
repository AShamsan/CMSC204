


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedListTestStudent {
	SortedDoubleLinkedList<String> srtdLStr;
	SortedDoubleLinkedList<Double> srtdLDoub;
	SortedDoubleLinkedList<Car> srtdLCar;
	StringComparator comparator;
	DoubleComparator compD;
	CarComparator compCar;
	
	public Car a =new Car("Nissan", "Armada", 2009);
	public Car b=new Car("RoolsRoyce", "Phantom", 2022);
	public Car c =new Car("Porshce", "911", 2015);
	public Car d=new Car("Toyota", "LandCruiser", 2006);
	public Car e =new Car("Honda", "Civic", 2015);
	public Car f =new Car("Mitsubichi", "Lancer", 2005);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		srtdLStr = new SortedDoubleLinkedList<String>(comparator);
		
		compD = new DoubleComparator();
		srtdLDoub = new SortedDoubleLinkedList<Double>(compD);
		
		compCar = new CarComparator();
		srtdLCar = new SortedDoubleLinkedList<Car>(compCar);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		compD = null;
		compCar = null;
		srtdLStr = null;
		srtdLDoub = null;
		srtdLCar = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			srtdLStr.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			srtdLStr.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		srtdLCar.add(a);
		srtdLCar.add(b);
		srtdLCar.add(c);
		srtdLCar.add(d);
		ListIterator<Car> iterator = srtdLCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		srtdLStr.add("Begin");
		srtdLStr.add("World");
		srtdLStr.add("Hello");
		srtdLStr.add("Zebra");
		ListIterator<String> iterator = srtdLStr.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		srtdLCar.add(e);
		srtdLCar.add(c);
		srtdLCar.add(b);
		srtdLCar.add(d);
		//ArrayList<Car> carList = srtdLCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = srtdLCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		srtdLDoub.add(new Double(8));
		srtdLDoub.add(new Double(6));
		srtdLDoub.add(new Double(1));
		srtdLDoub.add(new Double(2));
		ListIterator<Double> iterator = srtdLDoub.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		srtdLDoub.add(new Double(5));
		srtdLDoub.add(new Double(10));
		srtdLDoub.add(new Double(8));
		srtdLDoub.add(new Double(2));
		ListIterator<Double> iterator = srtdLDoub.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		srtdLCar.add(e);
		srtdLCar.add(c);
		srtdLCar.add(b);
		srtdLCar.add(d);
		//ArrayList<Car> carList = srtdLCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = srtdLCar.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		srtdLCar.add(e);
		srtdLCar.add(c);
		srtdLCar.add(b);
		srtdLCar.add(d);
		//ArrayList<Car> carList = srtdLCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = srtdLCar.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	public void testAddCar() {
		//alphabetic order: e f a c b d
		srtdLCar.add(a);
		srtdLCar.add(b);
		srtdLCar.add(c);
		assertEquals(a, srtdLCar.getFirst());
		assertEquals(b, srtdLCar.getLast());
		srtdLCar.add(d);
		srtdLCar.add(e);
		assertEquals(e, srtdLCar.getFirst());
		assertEquals(d, srtdLCar.getLast());
		//deletes Elephant from linked list
		assertEquals(d,srtdLCar.retrieveLastElement());
		assertEquals(b, srtdLCar.getLast());
	}

	@Test
	public void testRemoveFirstCar() {
		//alphabetic order: e f a c b d
		srtdLCar.add(b);
		srtdLCar.add(c);
		assertEquals(c, srtdLCar.getFirst());
		assertEquals(b, srtdLCar.getLast());
		srtdLCar.add(a);
		assertEquals(a, srtdLCar.getFirst());
		// remove the first
		srtdLCar.remove(a, compCar);
		assertEquals(c, srtdLCar.getFirst());
	}
	
	@Test
	public void testRemoveEndCar() {
		//alphabetic order: e f a c b d
		srtdLCar.add(b);
		srtdLCar.add(f);
		assertEquals(f, srtdLCar.getFirst());
		assertEquals(b, srtdLCar.getLast());
		srtdLCar.add(d);
		assertEquals(d, srtdLCar.getLast());
		//remove from the end of the list
		srtdLCar.remove(d, compCar);
		assertEquals(b, srtdLCar.getLast());
	}

	@Test
	public void testRemoveMiddleCar() {
		//alphabetic order: e f a c b d
		srtdLCar.add(a);
		srtdLCar.add(b);
		assertEquals(a, srtdLCar.getFirst());
		assertEquals(b, srtdLCar.getLast());
		srtdLCar.add(f);
		assertEquals(f, srtdLCar.getFirst());
		assertEquals(b, srtdLCar.getLast());
		assertEquals(3,srtdLCar.getSize());
		//remove from middle of list
		srtdLCar.remove(a, compCar);
		assertEquals(f, srtdLCar.getFirst());
		assertEquals(b, srtdLCar.getLast());
		assertEquals(2,srtdLCar.getSize());
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
			return arg0.getMake().compareTo(arg1.getMake());
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
