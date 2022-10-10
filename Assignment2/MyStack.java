/**
 * @author Abdullah Shamsan
 */
import java.util.ArrayList;

public class MyStack <T> implements StackInterface {

	private T[] stack;
	private int top;
	private int size;
	private final int MAX_SIZE = 10000;
	
	public MyStack() {
		stack = (T[]) new Object [MAX_SIZE];
	}
	
	
	/**
	 * 
	 * @param maxSize
	 */
	public MyStack(int maxSize) {
		stack = (T[]) new Object [maxSize];
		top = -1;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {

		return stack[0] == null;
	}

	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (top == stack.length-1) {
			return true;
		}
		return false;
	}

	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public Object pop() throws StackUnderflowException {
		T x = null;
		
		if (isEmpty())
		{
			throw new StackUnderflowException();
		}
		
		else
		x = stack[top];
		stack[top] = null;
		top--;
		
		return x;
	}

	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public Object top() throws StackUnderflowException {
		T x = null;
		
		if (isEmpty())
			throw new StackUnderflowException();
			
		else 
			x = stack[top];
		
		return x;
	}

	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return top + 1;
	}

	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(Object e) throws StackOverflowException {
		
		
		if (isFull()) {
			throw new StackOverflowException();
		}
	
		else 
			top++;
			stack[top] = (T) e;
				
		return true;
	}
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i = 0; i <= top; i++)
			str += stack[i];
		
		return str;
	}
	
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		
		for(int i = 0; i <= top; i++)
		{
			
				str += stack[i];
				if (i < top)
					str += delimiter;
		}
		
		return str;
	}

	
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList list) {
		
		
		for (int i = 0; i < list.size(); i++) {
		
				push(list.get(i));
		}
	}

}