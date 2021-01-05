package pupp;

public class OrderedList<T> extends DoublyLinkedList<T> implements IOrderedList<T> {
	@Override
	public void add(T data) {
		this.addLast(data);
	}
	@Override
	public boolean contains(T data) {
		boolean found = false;
		java.util.Iterator<T> it = iterator();
		while (it.hasNext()) {
			if (it.next().equals(data)) {
				found = true;
				break;
			} 
		}
		return found;
	}
}
