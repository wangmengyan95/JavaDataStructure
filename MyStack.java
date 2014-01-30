
public class MyStack<E> {
	private int capacity;
	private int size;
	private int head;
	private E[] items;
	
	public MyStack(){
		size = 0;
		head = -1;
		initialize(10);
	}
	public MyStack(int capacity){
		size = 0;
		head = -1;
		initialize(capacity);
	}
	public void initialize(int capacity){
		if(capacity <= this.capacity) return;
		
		E[] newItems = (E[]) new Object[capacity];
		for(int i=0; i<=size-1; i++) newItems[i] = items[i];
		items = newItems;
		this.capacity = capacity;
		return;
	}
	public boolean push(E item){
		if(size == capacity) initialize(capacity*2);
		items[++head] = item;
		size++;
		return true;
	}
	public E pop() throws Exception{
		if(size == 0) throw new Exception("Out of bound");
		E result = items[head--];
		size--;
		return result;
	}
	public void print(){
		for(int i=0; i<=size-1; i++) System.out.print(items[i]+ " ");
		System.out.println();
	}
}
