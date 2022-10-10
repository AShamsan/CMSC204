/**
 * @author Abdullah Shamsan
 */
import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface<T> {

	private T[] queue;
	private int front;
	private int back;
	private int max;
	private static final int MAX_INDEX = 50;
	
	public MyQueue() {
		queue = (T[]) new Object[MAX_INDEX ];
	}

/**
 * 
 * @param maxSize
 */
	public MyQueue(int maxSize) {
		
		queue = (T[]) new Object[maxSize + 1];
		front = 0;
		back = 0;
		max = maxSize;
	}
	

	/**
	 * Checks if the Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return queue[front] == null;
	}
	
	
	/**
	 * Check if the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		
		for (int i = 0; i < max; i++)
		{
			if (queue[i] == null)
			{
				return  false;
			}
		}
		return true;
	}

	
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return Math.abs(back -front);
	}
	
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T x = null;
		
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		
		else
		x = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		
		return x;
	}


	/**
	 * Adds an element to the end of the Queue
	 * @param object the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {		
		
		if(isFull())
		{
			throw new QueueOverflowException();
		}
		
		queue[back] = (T) e;
		back = (back + 1) % queue.length; 
		
		return true;
	}
	

	/**
	 * Returns the string representation of the elements in the Queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i = front; i < back; i++)
		{
			if (i < queue.length)
				str += queue[i];
			else
				i = (i+1)%queue.length;
		}
			
		
		return str;
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue,
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		
		for(int i = front; i < back; i++)
		{
			if (i < queue.length)
			{
				str += queue[i];
				if (i < back-1)
					str += delimiter;
			}
			else
				i = (i+1)%queue.length;
		}
		
		return str;
	}
	

	 /**
	  * Fills the Queue with the elements of the ArrayList
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
	@Override
	public void fill(ArrayList list) {
	
		for (int i = 0; i < list.size(); i++) {
			
			enqueue(list.get(i));		
}
	}
}