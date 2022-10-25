import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Abdullah Shamsan
 *
 * @param <T>
 */
public class BasicDoubleLinkedList <T> implements Iterable{
	
	protected Node <T> head;
	protected Node <T >tail;
	protected int size;
	
	/**
	 * constructor
	 */
public  BasicDoubleLinkedList(){
		head = null;
		tail = null;  
		size = 0;
}

/**
 * 
 * @return if the list is empty
 */
public boolean isEmpty() {
	
	return size ==0 || head ==null; // head == null
}

/**
 * 
 * @return list size
 */
public int getSize() {
	
	return size;
}

/**
 * 
 * @param data
 */
public void addToEnd(T data) {
	Node n = new Node(data);
	if(isEmpty()){
		head = n;
		tail = n;
	}
	else {
		tail.next = n;
		n.prev = tail;
	}
	tail = n;
	tail.next=null;
	size++; 
}

/**
 * 
 * @param data
 */
public void addToFront(T data) {
	Node n = new Node(data);
	
	if(isEmpty()) {
		head = n;
		tail = n;
//		head.prev = null;
//		tail.next = null;
	}
	else {
		head.prev = n;
		n.next = head;
	}
	head = n;
	head.prev = null;
	size++;
}

/**
 * 
 * @return data at the head of list
 */
public T getFirst() {
	if(isEmpty()) {
		return null;
	}
	else {
		return (T) head.data;
	}
}

/**
 * 
 * @return data at the tail of list
 */
public T getLast() {
	if(isEmpty()) {
		return null;
	}
	else {
		return (T) tail.data;
	}
}

/**
 * @return new DoubleLinkedListIterator
 */
public ListIterator<T> iterator(){
	
	return new DoubleLinkedListIterator<T>();
}

/**
 * 
 * @param targetData
 * @param comparator
 * @return the node
 */
public Node <T> remove(T targetData, Comparator<T> comparator){
	Node<T> n=head;
	while (!(n == null)) {
		if (comparator.compare(targetData, n.data)==0) {
			if (n==head) {
				head = head.next;
			} 
			else if (n==tail) {
				tail = tail.prev;
			} 
			else {
				n.prev.next=n.next;
				n.next.prev=n.prev;
			}
			size--;
			return n;
		}
		n=n.next;
	}
	return null;
}


/**
 * 
 * @return the first element data
 */
public T retrieveFirstElement() {

	if(isEmpty()) {
		return null;
	}
	else {
		T retrieved =  (T) head.data;
		head = head.next;
		head.prev = null;
		size--;
		return retrieved;
	}
}

/**
 * 
 * @return the last element data
 */
public T retrieveLastElement() {
	
	if(isEmpty()) {
		return null;
	}
	else{
		T retrieved = (T) tail.data;
		tail = tail.prev;
		tail.next = null;
		size--;
		return retrieved;
	}
}

/**
 * 
 * @return linkedList with data
 */
public ArrayList <T> toArrayList(){
	ArrayList <T> linkedList = new ArrayList<T>();
	
	Node<T> n = head;
	
	while( n != null) {
		linkedList.add(n.data);
		n = n.next;
	}
	return linkedList;
}


/**
 * 
 * @author Abdullah Shamsan
 *
 * @param <T>
 */
public class Node <T>{ //Start of inner class Node

	protected T data;
	protected Node prev;
	protected Node next; 
	
	/**
	 * 
	 * @param dataNode
	 */
	public Node (T dataNode) {
		
		data = dataNode;
		prev = null;
		next = null;
	}
}

/**
 * 
 * @author Abdullah Shamsan
 *
 * @param <T>
 */
public class DoubleLinkedListIterator <T> implements ListIterator { //Start of inner class DoubleLinkedListIterator

	protected Node pointer;
	protected Node ender;
	protected int x;
	

	public DoubleLinkedListIterator() {
		
		pointer = head;
		ender = null;
		x = 0;
		
	}
	
	@Override
	public boolean hasNext() {
		if(pointer == null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public T next() throws NoSuchElementException{
		if(pointer ==null) {
			throw new NoSuchElementException();
		}

		else {
			ender = pointer;
			pointer = pointer.next;
			return (T) ender.data;
		}
	}

	@Override
	public boolean hasPrevious() {
		if(ender == null) {
			return false;
		}
		else {
			
			return true;
		}
	}

	@Override
	public T previous()  throws NoSuchElementException{
		if(ender == null){
			throw new NoSuchElementException();
		}
		else {
			pointer = ender;
			ender = ender.prev;
			return (T) pointer.data;
		}
	}

	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
		
	}
	
	@Override
	public void add(Object data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
		
	}

	@Override
	public int nextIndex() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public int previousIndex() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(Object arg0) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
		
	}
}
	}
