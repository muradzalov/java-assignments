package util;

public class Node{
	public Object data;
	public Node next;
	@Override
	public String toString() {
		return data.toString();
	}
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(Object data) {
		this.data = data;
	}
}