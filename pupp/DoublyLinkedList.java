package pupp;

public class DoublyLinkedList<T> implements IDoublyLinkedList<T> {
	protected DNode head = null;
	protected DNode tail = null;
	private int size = 0;
	@Override
	public void addFirst(T data) {
//		@SuppressWarnings("unused")
		DNode node = new DNode(data);
		node.setNextNode(head);
		if (isEmpty()) {
			tail = node;
		} else {
			head.setPrevNode(node);
		}
		head = node;
		size += 1;
	}
	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return head.getData();
	}
	@Override
	public T removeFirst() {
		T data = getFirst();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head.getNextNode().setPrevNode(null);
			head = head.getNextNode();		
		}
		size -= 1;
		return data;
	}
	@Override
	public void addLast(T data) {
//		@SuppressWarnings("unused")
		DNode node = new DNode(data);
		
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNextNode(node);
			node.setPrevNode(tail);
		}
		tail = node;
		size += 1;
	}
	@Override
	public T removeLast() {
		T data = getLast();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail.getPrevNode().setNextNode(null);
			tail = tail.getPrevNode();
		}
		size -= 1;
		return data;
	}
	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return tail.getData();
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DNode node = head;
		sb.append("[ ");
		while (node != null) {
			sb.append(node.getData().toString() + " ");
			node = node.getNextNode();
		}
		sb.append("]");
		return sb.toString();
	}
	@Override
	public java.util.Iterator<T> iterator() {
		return new ForwardIterator();
	}
	@Override
	public java.util.Iterator<T> reverseIterator() {
		return new ReverseIterator();
	}
	private class ForwardIterator implements java.util.Iterator<T> {
		private DNode node = null;
		private DNode nextNode = head;
		@Override
		public boolean hasNext() {
			if (nextNode == null) {
				return false;
			}
			return true;
		}
		@Override
		public T next() {
			if (nextNode == null) {
				throw new java.util.NoSuchElementException();
			}
			node = nextNode;
			T data = nextNode.getData();
			nextNode = nextNode.getNextNode();
			return data;
		}
		@Override
		public void remove() {
			if (node == null) {
				throw new java.util.NoSuchElementException();
			}
			if (node.getNextNode() == null && node.getPrevNode() == null) {
				head = null;
				tail = null;
			} else {
				if (node.getNextNode() == null) {
					node.getPrevNode().setNextNode(null);
					tail = null;
				} else {
					if (node.getPrevNode() == null) {
						node.getNextNode().setPrevNode(null);
						head = null;
					} else {
						node.getPrevNode().setNextNode(node.getNextNode());
						node.getNextNode().setPrevNode(node.getPrevNode());
					}
				}
			}
			node = null;
			size--;
		}
	}
	private class ReverseIterator implements java.util.Iterator<T> {
		private DNode nextNode = tail;
		@Override
		public boolean hasNext() {
			if (nextNode == null) {
				return false;
			}
			return true;
		}
		@Override
		public T next() {
			if (nextNode == null) {
				throw new java.util.NoSuchElementException();
			}
			T data = nextNode.getData();
			nextNode = nextNode.getPrevNode();
			return data;
		}
	}
	protected class DNode {
		private DNode nextNode;
		private DNode prevNode;
		private T data;
		public DNode(T data) {
			setData(data);
		}
		public DNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(DNode nextNode) {
			this.nextNode = nextNode;
		}
		public DNode getPrevNode() {
			return prevNode;
		}
		public void setPrevNode(DNode prevNode) {
			this.prevNode = prevNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
	}
}
