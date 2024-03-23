package single_linked_list;

public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) { // If the linked list is empty, then set the newNode as the head.
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next; // Moving to the last node.
			}
			current.next = newNode; // Adding the newNode to the end.
		}
	}

	public void delete(int data) {
		if (isEmpty()) { // If the linked list is empty, then there is no node can be deleted.
			return;
		}
		if (head.data == data) { // If the head is deleted, then the head change to the next node.
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

	public Node find(int data) {
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				System.out.println("find the value!");
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			if (current.next != null) {
				System.out.print(current.data + " -> ");
				current = current.next;
			} else {
				System.out.print(current.data);
				current = current.next;
			}
		}
		System.out.println();
	}

	public void free() {
		Node current = head;
		while (current != null) {
			Node nextNode = current.next;
			current.next = null; // Leaves the next reference for the current node blank.
			current = nextNode;
		}
		head = null;
	}

	public Node findMiddle() {
		if (head == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) { // The slow pointer takes one step, the fast pointer takes two
													// steps, and when the fast pointer reaches the tail, the slow
													// pointer goes right to the middle
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public boolean hasCycle() {
		if (head == null) {
			return false;
		}
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true; // If the fast and slow meet, then the list is looped.
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev; // The current node points to the previous node
			prev = current; // Update the previous node to the current node
			current = next; // Update the current node to the next node
		}
		head = prev;
	}

	public void reverseRecursive() {
		head = reverseRecursiveUtil(head, null);
	}

	private Node reverseRecursiveUtil(Node current, Node prev) {
		if (current == null) {
			return prev;
		}
		Node next = current.next;
		current.next = prev; // The current node points to the previous node
		return reverseRecursiveUtil(next, current); // Recursively processes the next node, updating the current node
													// and the previous node
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(9);
		list.insert(6);
		list.insert(3);
		list.find(2);
		list.display();
		list.delete(2);
		list.display();
		Node middle = list.findMiddle();
		System.out.println("Middle node: " + middle.data);

		System.out.println("Has cycle: " + list.hasCycle());

		list.reverse();
		list.display();

		list.reverseRecursive();
		list.display();
		list.reverse();
		list.display();

		list.free();
		list.display();

	}
}
