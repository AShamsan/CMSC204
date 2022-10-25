import java.util.ListIterator;
import java.util.Comparator;
import java.lang.UnsupportedOperationException;

/**
 * 
 * @author Abdullah Shamsan
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private Comparator<T> comp;
	
	/**
	 * Creates empty list with specified comparator.
	 * @param comparator
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		comp = comparator;
	}

	/**
	 * Implements iterator by calling super class iterator 
	 * @param comparator
	 */
	public ListIterator<T> iterator(Comparator<T> comparator) {
		return super.iterator();
	}

	/**
	 * Inserts element at the correct position in sorted list.
	 * @param data
	 */
	public void add(T data) {
		Node<T> current = head;
		Node<T> n = new Node(data);
		
		if (head == null) {
			head  = tail = n;
		}
		else if (comp.compare(data, tail.data) > 0){
			tail.next = n;
			n.prev = tail;
			tail = n;
			tail.next = null;
		}
		else if (comp.compare(head.data, data) >= 0)	{
			head.prev = n;
			n.next = head;
			head = n;
			head.prev = null;
		}
		else {
			while (!(current.next == null) && comp.compare(data,current.data) > 0) {
				current = current.next;
			}
			current.prev.next = n;
			n.prev = current.prev;
			current.prev = n;
			n.next = current;		
		}
		size++;
	}
	
	@Override
	/**
	 * @param targetData
	 * @param comparator
	 */
	public Node remove(T targetData, Comparator<T> comparator) {
		return super.remove(targetData, comparator);
	}
	
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException { 
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public void addToFront(T data) throws UnsupportedOperationException { 
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
}