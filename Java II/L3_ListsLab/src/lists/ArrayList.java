package lists;

public class ArrayList<E> {

	private E[] data;
	private int size;
	
	public static final int DEFAULT_SIZE = 10;
	public ArrayList() {
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data 	  = (E[]) (new Object[capacity]);
		size	  = 0;
	}
	
	public boolean add(E item) {
		int oldSize = size;
		data[size++]  = item;
		return  size == (oldSize + 1);
	}
	
	public E remove(int index) {
		E element = data[index];
		shiftLeft(index);
		size --;
		data[size] = null;
		return element;
	}
	
	public void shiftLeft(int index) {
		for  (int i = index; i < size; i++) {
			data[i] = data[i + 1];
			
		}
	}
	public int size() {
		return size;
	}
	
	public String toString() {
		if (size == 0) {
			return "[]";
		}else {
			StringBuilder result = new StringBuilder("[" + data[0]);
			for (int i = 1; i < size; i++) {
				result.append(",").append(data[i]);
				
			}
			result.append("]");
			return result.toString();
		}
	}
}
