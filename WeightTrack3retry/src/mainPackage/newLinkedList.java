package mainPackage;

import java.util.AbstractList;

class newLinkedList<T> extends AbstractList {
	private Node head;
	private int listCount;

	public newLinkedList() {

		// makes null head node to use to make list
		head = new Node(null);
		listCount = 0;
	}

	// adds object to end of list
	public void addLast(T data) {
		Node temp = new Node(data);
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while (current.getNext() != null) {
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		listCount++;
	}

	public void add(T data, int index)
	// inserts the specified element at the specified position in this list
	{
		Node temp = new Node(data);
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node
		// reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}

	public T get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index <= 0)
			return null;

		Node current = head.getNext();
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;

			current = current.getNext();
		}
		return current.getData();
	}

	public T remove(int index) {
		throw new UnsupportedOperationException();
	}

	public boolean myRemove(int index)
	// removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		Node current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;

			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}

	public T removeFirst() {
		Node oldFirst = head;
		head = head.next;
		listCount--;
		return (T) oldFirst.data;
	}

	public int size()
	// returns the number of elements in this list.
	{
		return listCount;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		Node current = head.getNext();
		String output = "";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}

	public void push(T data) {
	}

	public T pop() {
		return removeFirst();
	}

	public boolean empty() {
		return isEmpty();
	}

	private class Node {
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		T data;

		// Node constructor
		public Node(T dataValue) {
			next = null;
			data = dataValue;
		}

		// another Node constructor if we want to
		// specify the node to point to.
		public Node(T dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}

		// these methods should be self-explanatory
		public T getData() {
			return data;
		}

		public void setData(T dataValue) {
			data = dataValue;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node nextValue) {
			next = nextValue;
		}
	}
}
