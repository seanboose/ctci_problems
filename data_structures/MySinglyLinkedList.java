package seanboose.data_structures;


public class MySinglyLinkedList<T>{
	Node head;

	class Node{
		Node next = null;
		T data;
		public Node(T _data){
			data = _data;
		}
	}

	public MySinglyLinkedList(){
		head = null;
	}

	public Node insert(T _data){
		System.out.println("insert");

		return head;
	}
}
