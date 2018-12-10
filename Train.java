import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Train {
	
	public static void main(String[] argv) {
		System.out.println("Start ...");
		
		Student studentF = new Student(2, "Flo");
		Student studentL = new Student(1, "Lo");
		//System.out.println(student.getName());
		//System.out.println(student.getId());

		Student[] students = new Student[2];
		students[1] = studentF;
		students[0] = studentL;

		String[] words1 = {"a", "b", "c"};
		String[] words2 = {"A", "B", "C"};

		System.out.println(students);

		Train o = new Train();
		HashMap<Integer, String> hashMapStudent = o.buildMap(students);
		System.out.println(hashMapStudent);

		System.out.println(o.merge(words1, words2));

		Node linkedList = new Node(1);
		linkedList.appendToTail(3);
		linkedList.appendToTail(9);
		linkedList.appendToTail(3);
		linkedList.appendToTail(3);
		linkedList.appendToTail(3);
		linkedList.appendToTail(4);
		linkedList.appendToTail(6);
		linkedList.appendToTail(3);

		Node.removeDuplicates(linkedList);
		//linkedList = Node.deletNode(linkedList, 3);
		System.out.println(linkedList.stringList());

		Stack stack = new Stack();
		stack.push(new Node(5));
		stack.push(new Node(4));
		stack.push(new Node(6));
		Train.p(stack.pop());
		Train.p(stack);

		Queue queue = new Queue();
		queue.enqueue(new Node(0));
		queue.enqueue(new Node(8));
		queue.enqueue(new Node(3));
		Train.p(queue.dequeue());
		Train.p(queue);
	}

	public HashMap<Integer, String> buildMap(Student[] students){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (Student student : students) map.put(student.getId(), student.getName());
		return map;
	}

	public ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> sentence = new ArrayList<String>();
		for (String word : words) sentence.add(word);
		for (String word : more) sentence.add(word);
		return sentence;
	}

	public static void p(Object o) {
		System.out.println(o);
	}

}

class Student {

	private Integer id;
	private String name;

	public Student() {
		this.id = 0;
		this.name = "Default";
	}

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}

}

class Node {

	int data;
	Node next = null;

	public Node(int d) {
		this.data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) { n = n.next; }
		n.next = end;
	}

	public static Node deletNode(Node head, int d) {
		Node n = head;
		if(n.data == d) {
			return head.next;
		}
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return null;
	}

	public static void removeDuplicates(Node n) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node previous = null;
		while(n != null) {
			//System.out.println("--" + n.stringList());
			if(table.containsKey(n.data)) {
				previous.next = n.next;
				//System.out.println("-- if -" + n.stringList());
				//System.out.println("-- if -" + previous.stringList());
			}
			else {
				table.put(n.data, true);
				previous = n;
				//System.out.println("-- else -" + n.stringList());
				//System.out.println("-- else -" + previous.stringList());
			}
			n = n.next;
		} 
	}

	public String toString() {
		return "" + data;
	}

	public String stringList() {
		Node n = this;
		String list = "";
		while(n != null) {
			list += n.toString();
			n = n.next;
		}
		return list;
	}
}

class Stack {

	Node top;

	Node pop() {
		if(top != null) {
			Node item = top;
			top = top.next;
			return item;
		}
		return null;
	}
	void push(Node item) {
		Node t = item;
		t.next = top;
		top = t;
	}

	public String toString() {
		if(top == null) return null;
		return top.stringList();
	}

}

class Queue {
	Node first, last;
	void enqueue(Node item) {
		if(first == null) {
			last = item;
			first = last;
		} else {
			last.next = item;
			last = last.next;
		}
	}
	Node dequeue() {
		if(first == null) {
			return null;
		} else {
			Node item = first;
			first = first.next;
			return item;
		}
	}
	public String toString() {
		if(first == null) return null;
		return first.stringList();
	}

}