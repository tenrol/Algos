class Node {
	
	Node next;
	int val;

	public Node(int val) {
		this.val = val;
	}
}

class LinkedList {

	Node head;

	public void append(int val) {
		
		if (head == null) {
			head = new Node(val);
			return;
		}
		
		Node tmp = head;
		
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new Node(val);
	}

	public void preprend(int val) {
		
		Node newHead = new Node(val);
		newHead.next = head;
		head = newHead;
	}

	public void deleteWithValue(int val) {

		if (head == null) return;
		if (head.val == val) head = head.next;

		Node tmp = head;

		while (tmp.next != null) {
			
			if (tmp.next.val == val) {
				tmp.next = tmp.next.next;
				return;
			}
			tmp = tmp.next;
		} 
	}
}