package lists;

import utility.List;
import java.util.NoSuchElementException;
import utility.Iterator;

public class ArrayList<E> implements List<E> {

	private E[] data;
	private int size;

	public static final int DEFAULT_SIZE = 10;

	// holds a default capacity
	public ArrayList() {
		this(DEFAULT_SIZE);
	}

	// generates an internal array with specified capacity
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	// generates an internal array copies the list specified into the current array
	// list
	@SuppressWarnings("unchecked")
	public ArrayList(List<E> other) {
		data = (E[]) new Object[other.size()];
		for (int i = 0; i < other.size(); i++) {
			data[i] = other.get(i);
			size++;
		}
	}

	// return true if the data was added successfully
	public boolean add(E item) {
		int oldSize 	= size;
		ensureCapacity(size + 1);
		data[size++] 	= item;
		return size 	== (oldSize + 1);
	}

	// inserts the item at specified location
	public void add(int index, E value) {
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = value;
		size++;
	}

	// check if the given index is valid
	@SuppressWarnings("unused")
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}

	}

	// size back to zero
	public void clear() {
		size = 0;
	}

	// searches for a specific value and return true if in the list
	public boolean contains(E value) {
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(value)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {

		if (minCapacity > data.length) {
			int newLength = Math.max(2 * data.length + 1, minCapacity);
			E[] newArray = (E[]) new Object[newLength];

			for (int i = 0; i < size; i++) {
				newArray[i] = data[i];
			}
			data = newArray;
		}

	}

	// returns if the contents of the current List<E> is equal to another
	public boolean equals(List<E> other) {
		if (other.size() == size()) {
			for (int i = 0; i < size(); i++) {
				if (other.get(i) != get(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	// returns the item at the specified position in the list
	public E get(int index) {
		checkIndex	(index);
		return 		data[index];
	}

	// returns the first occurrence in the array
	// otherwise returns -1
	public int indexOf(E item) {
		for (int i = 0; i < size(); i++) {
			if (data[i] == item) {
				return i;
			}
		}
		return -1;
	}

	// return true if the list is empty
	public boolean isEmpty() {
		return size() == 0;
	}

	// removes the item at the given index
	public E remove(int index) {
		checkIndex		(index);
		E element 		= data[index];
		shiftLeft		(index);
		size--;
		data[size] 		= null;
		return 			element;
	}

	// removes the first occurrence of the item specified from the list
	// return true if the item removed
	public boolean remove(E item) {
		if (contains(item)) {
			int index = indexOf(item);
			shiftLeft(index);
			data[size--] = null;
			return true;
		} else {
			return false;
		}
	}

	// replaces the item at the specified position
	public E set(int index, E element) {
		checkIndex			(index);
		E oldElement 		= data[index];
		data[index] 		= element;
		return 				oldElement;
	}

	// returns the size of the occupied locations
	public int size() {
		return size;
	}

	// shifts to left index location
	public void shiftLeft(int index) {
		for (int i  = index; i < size; i++) {
			data[i] = data[i + 1];

		}
	}

	// shifts to right index location
	public void shiftRight(int index) {
		for (int i  = size; i > index; i--) {
			data[i] = data[i - 1];
		}
	}

	// displays the contents of the list
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder result = new StringBuilder("[" + data[0]);
			for (int i = 1; i < size; i++) {
				result.append(",").append(data[i]);

			}
			result.append("]");
			return result.toString();
		}
	}
	
	private class ArrayListIterator implements Iterator<E>{

		private int position;
		private boolean isRemovable;
		
		// initializes index to 0
		// and isRemovable to false
		public ArrayListIterator() {
			
			this.position 		= 0;
			this.isRemovable 	= false;
			
		}
		
		// return true if there are more elements left in the list
		public boolean hasNext() {
			
			return position < size();
		}

		// returns the item at the last iterator position and advances the position by one
		public E next() {
			if (! hasNext()) {
				throw new NoSuchElementException();
			}
			E item = get(position);
			position ++;
			isRemovable = true;
			return item;
		}

		// removes the item returned by last call to next()
		public void remove() {
			if(!isRemovable) {
				throw new IllegalStateException();
			}  
			ArrayList.this.remove(position-1);
			isRemovable = false;	
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}



}
