package lists;

import java.util.NoSuchElementException;

import utility.Iterator;
import utility.List;

public class LinkedList<E> implements List<E>{

	// data fields
	private Node<E> first; // store the address of the first node
	private Node<E> last; // store the address of the last node
	private int 	size;

	// constructor
	public LinkedList() {
		size  = 0;
		first = null;
		last  = null;

	}

	public LinkedList(List<E> other) {
		this();
		for (int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}

	// return true if the data added successfully
	public boolean add(E item) {
		int oldSize = size;
		Node<E> oldLast = last;
		Node<E> newNode = new Node<E>(oldLast, item);
		last = newNode;

		if (oldLast == null) {
			first = newNode;
		} else {
			oldLast.next = newNode;
		}

		size++;

		return size == (oldSize + 1);
	}

	// inserts the given value at the given index
	public void add(int index, E item) {	
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Out of bounds");
		}
		
		if (index == size) {
			add(item);
		}else {
			insertBefore(index, item);
		}
//		if (index == 0) {
//			first = new Node<E>(null,first,item);
//		} else {
//			Node<E> current = first;
//			for (int i = 0; i < index - 1; i++) {
//				current = current.next;
//			}
//			current.next = new Node<E>(current.prev, item);
//		}

	}

	@SuppressWarnings("unused")
	private void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	// removes all elements from the list
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	// return true if list is empty, false otherwise
	public boolean contains(E item) {
		return indexOf(item) >= 0;
	}

	// detaches the node at the specified index
	@SuppressWarnings("unused")
	private E detach(int index) {
		Node<E> current = node(index);
		Node<E> prev = current.prev;
		Node<E> next = current.next;
		E item = current.data;

		// detach the left side
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			current.prev = null;
		}

		// detach the right side
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			current.next = null;
		}

		current.data = null;
		size--;
		return item;
	}

	// return the item at the specified position in the list
	public E get(int index) {
		checkIndex(index);
		Node<E> current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	// returns the position of the first occurrence of the given value
	// -1 if not found
	public int indexOf(E item) {
		int index = 0;
		Node<E> current = first;
		while (current != null) {
			if (current.data == item) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;

	}

	// return true if the list is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	public void insertBefore(int index, E item) {
		
		Node<E> current = node(index);
		Node<E> prev 	= current.prev;
		Node<E> newNode = new Node<E> (prev, current, item);
		current.prev	= newNode;
		
		if (prev == null) {
			first = newNode;	
		}else {
			prev.next = newNode;
		}
		
		
		size ++;

		}
//		Node<E> prev = null;
//		Node<E> current = first;




	private Node<E> node(int index) {
		Node<E> current = null;
		if (index < size / 2) {
			current = first;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = last;
			for (int i = size - 1; i > index; i--) {
				current = current.prev;
			}
		}
		return current;
	}

	public E remove(int index) {

		checkIndex(index);
		if (index == 0) {
			E element = first.data;
			first = first.next;
			return element;
		} else {
			Node<E> current = first;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			E element = current.next.data;
			current.next = current.next.next;
			return element;
		}

	}

	public boolean remove(E item) {
		if (first == null) {
			return false;
		}
		if (first.data.equals(item)) {
			first = first.next;
			return true;
		} else {
			Node<E> current = first;
			while (current.next != null) {
				if (current.next.data.equals(item)) {
					current.next = current.next.next;
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}

	public E set(int index, E item) {
		
		checkIndex(index);
		Node<E> current = node(index);
		E oldValue = current.data;
		current.data = item;
		return oldValue;

	}

	// return the number of elements in the list
	public int size() {
		int count = 0;
		Node<E> current = first;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// display the contents of the list
	public String toString() {
		if (first == null) {
			return "[]";
		} else {
			String result = "[" + first.data;
			for (Node<E> x = first.next; x != null; x = x.next) {
				result += "," + x.data;
			}
			result += "]";
			return result;
		}
	}

	private class LinkedIterator implements Iterator<E> {
		private int 		position;
		private Node<E> 	current; 		// location of next value to return
		private boolean 	isRemovable; 	// whether it's okay to remove

		// initializes current to start point
		// and isRemovale to false
		public LinkedIterator() {
			current 		= first;
			position 		= 0;
			isRemovable 	= false;
		}

		// return true if there are more elements left
		public boolean hasNext() {
			return position < size;
		}

		// returns next element in the iteration
		public E next() {
            if (!hasNext())
                throw new  NoSuchElementException("No item in the list");
            E  currentItem  = current.data;
            current 	    = current.next;
            position++;
            
			isRemovable 	= true;
			return currentItem;
        }

		public void remove() {
			if(!isRemovable) {
				throw new IllegalStateException("Unable to remove item");
				
			}  
			LinkedList.this.remove(--position);
			isRemovable = false;	
		}
	}

	public static class Node<E> {
		Node<E> prev; // store the previous node
		Node<E> next; // store the next node
		E 		data; // store the data

		Node(E data) {
			this.data = data;
			this.next = null;
			this.prev = null;

		}

		Node(Node<E> prev, E data) {
			this(prev, null, data);

		}

		Node(Node<E> prev, Node<E> next, E data) {
			this.data = data;
			this.next = next;
			this.prev = prev;

		}
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}

	@Override
	public boolean equals(List<E> other) {
		// TODO Auto-generated method stub
		return false;
	}

}
