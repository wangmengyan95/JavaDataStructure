
public class MyLinkedList<AnyType> {
	 class Node<AnyType> {
	     public AnyType val;
	     public Node next;
	     public Node() {
	         next = null;
	     }
	     public Node(AnyType x) {
	    	 val = x;
	         next = null;
	     }
	 }
	 
	private int capacity;
	private int size;
	private Node<AnyType> dummyHead;
	
	public MyLinkedList(){
		this.dummyHead = new Node<AnyType>();
		return;
	}
	public boolean add(AnyType item){
		return this.add(item, this.size);
	}
	public boolean add(AnyType item, int index){
		if(index < 0 || index > this.size) throw new ArrayIndexOutOfBoundsException();
		
		int count = 0;
		Node<AnyType> current = dummyHead;
		while(current != null){
			if(count == index){
				Node<AnyType> node = new Node<AnyType>(item);
				node.next = current.next;
				current.next = node;
				break;
			}
			else{
				current = current.next;
				count++;
			}
		}
		
		return true;
	}
	public boolean remove(int index){
		if(index < 0 || index >= this.size) throw new ArrayIndexOutOfBoundsException();
		
		Node<AnyType> current = dummyHead;
		int count = 0;
		while(current != null){
			if(count == index){
				current.next = current.next.next;
			}
			else{
				current = current.next;
				count++;
			}
		}
		return true;
	}
	public AnyType get(int index){
		if(index < 0 || index >= this.size) throw new ArrayIndexOutOfBoundsException();
		
		AnyType result = null;
		Node<AnyType> current = dummyHead;
		int count = -1;
		while(current != null){
			if(count == index){
				result = current.val;
				break;
			}
			else{
				current = current.next;
				count++;
			}
		}
		return result;
	}
}
