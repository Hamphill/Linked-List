package double_linked_list;

public class DoubleLinkedList {
	private Node head; 
    private Node tail; 


    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Adding a new node in the end.
    public void append(int data) {
        Node newNode = new Node(data); 
        if (head == null) {
            head = newNode; 
        } else {
            tail.next = newNode; // Adding the new node to the tail node.
            newNode.prev = tail; 
        }
        tail = newNode; // Setting the new node as the tail node.
    }

    // Adding a new node in the head.
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;  // If the linked list is empty, then new node is either head or tail.
            tail = newNode; 
        } else {
            newNode.next = head; 
            head.prev = newNode; 
            head = newNode; // Setting the new node as the head.
        }
    }
    
    public void insert(int index, int data) {
    	Node newNode = new Node(data);
    	Node current = this.head;
    	if(index < 0) {
    		System.out.println("Invalid");
    	}else {
    		if(index == 0) {
    			prepend(data);
    		} else {
                int currentIndex = 0;
                while (current != null && currentIndex < index - 1) {
                    current = current.next;
                    currentIndex++;
                }
                newNode.next = current.next; // Connecting the new node after the current node.
                if (current.next != null) {
                    current.next.prev = newNode; // If the current node is not the tail node, update the previous node of the next node as the new node.
                }
                current.next = newNode; 
                newNode.prev = current; 
    		}
    	}
    }
    
    public void delete(int data) {
    	Node current = head; 
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    // If it is head node
                    head = current.next; 
                    if (head != null) {
                        head.prev = null; 
                    } else {
                        tail = null; 
                    }
                } else if (current == tail) {
                    // If it is tail node
                    tail = current.prev; // Updating the tail node to the previous node.
                    tail.next = null; 
                } else {
                    // If the deleted node in the middle
                    current.prev.next = current.next; 
                    current.next.prev = current.prev; 
                }
                return; 
            }
            current = current.next; 
        }

    }
    
    public Node find(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
            	System.out.println("Successful find "+ data);
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
    
 
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList list = new DoubleLinkedList(); 
        list.append(3); 
        list.append(2);
        list.append(1);
        list.insert(1, 0);
        list.prepend(4); 
        list.display();
        list.find(2);
        list.delete(4);
        list.delete(1);
        list.display(); 
	}

}
