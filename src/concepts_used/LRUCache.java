package concepts_used;


import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {
	
	private final int capacity;
	private int size;
	private final Map<String,Node> hashMap;
	private final DoublyLinkedlist internalQueue;
	
	LRUCache(final int capacity)
	{
		this.capacity = capacity;
		this.hashMap = new HashMap<>();
		this.internalQueue = new DoublyLinkedlist();
		this.size = 0;
	}

	public T get(final String key)
	{
		Node node = hashMap.get(key);
		if(node == null)
		{
			return null;
		}
		internalQueue.modeNodeToFront(node);
		return hashMap.get(key).value;
	}
	
	public void put(final String key, final T value)
	{
		Node currentNode = hashMap.get(key);
		if(currentNode != null)
		{
			currentNode.value = value;
			internalQueue.modeNodeToFront(currentNode);
		}
		
		if(size == capacity)
		{
			String rearNodekey = internalQueue.getRearKey();
			internalQueue.removeNodeFromRear();
			hashMap.remove(rearNodekey);
			size--;
		}
		
		Node node = new Node(key, value);
		internalQueue.addNodetoFront(node);;
		hashMap.put(key, node);
		size++;
		
		
	}
	
	private class Node{
		String key;
		T value;
		Node next, prev;
		
		public Node(final String key, final T value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	
	private class DoublyLinkedlist{
		private Node front, rear;
		
		public void DoublyLinkedlist() {
			front = rear = null;
		}
		
		private void addNodetoFront(final Node node)
		{
			if(rear == null)
			{
				front = rear = node;
				return;
			}
			node.next = front;
			front.prev = node;
			front = node;
		}
		
		public void modeNodeToFront(final Node node)
		{
			if(front == node)
			{
				return;
			}
			if(node == rear)
			{
				rear = rear.prev;
				rear.next = null;
			}
			else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
			
			node.prev = null;
			node.next = front;
			front.prev = node;
			front = node;
			
			
		}
		private void removeNodeFromRear()
		{
		
			if(rear == null)
			{
				return;
			}
			
			System.out.println("Deleting Key: "+ rear.key);
			
			if(front == rear)
			{
				front = rear = null;
			}
			else {
				rear = rear.prev;
				rear.next = null;
			}
		}
		private String getRearKey()
		{
			return rear.key;
		}
	}

}
