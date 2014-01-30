
public class MyQueue {
	private int capacity;
	private int size;
	private int front;
	private int end;
	private int[] items;

	public MyQueue(){
		initialize(10);
	}
	public MyQueue(int size){
		initialize(size);
	}
	private void initialize(int size){
		this.size = 0;
		this.capacity = size;
		this.front = 0;
		this.end = -1;
		this.items = new int[size];
	}
	public boolean inQueue(int n){
		if(size == capacity) throw new IndexOutOfBoundsException();
		end = (end+1) % capacity;
		items[end] = n;
		size++;
		return true;
	}
	public int deQueue(){
		if(size == 0) throw new IndexOutOfBoundsException();
		int item = items[front];
		front = (front+1) % capacity;
		size--;
		return item;
	}
	public void print(){
		for(int i=0; i<=capacity-1; i++) System.out.print(items[i]+" ");
		System.out.println();
		System.out.println(front);
		System.out.println(end);
	}
}
