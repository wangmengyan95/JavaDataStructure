
public class MyMinHeap {
	private int capacity;
	private int size;
	private int[] items;
	
	public MyMinHeap(){
		this.capacity = 10;
		this.size = 10;
		this.items = new int[this.size];
	}
	public MyMinHeap(int[] items){
		this.size = items.length;
		this.items = items;
		this.capacity = items.length;
	}
	private int getParent(int index){
		if(index == 0) return -1;
		else return (index-1)/2;
	}
	private int getLeftChild(int index){
		return index*2+1;
	}
	private int getRightChild(int index){
		return index*2+2;
	}
	private void swap(int i, int j){
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	private void heapify(int index){
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		int left = getLeftChild(index);
		int right = getRightChild(index);
		
		int minIndex = index;
		if(left < size && items[left] < items[minIndex]) minIndex = left;
		if(right < size && items[right] < items[minIndex]) minIndex = right;
		
		if(minIndex != index){
			swap(minIndex, index);
			heapify(minIndex);
		}
		return;
	}
	public void buildHeap(){
		for(int i=size-1; i>=0; i--) heapify(i);
	}
	public void printHeap(){
		for(int i=0; i<=size-1; i++) System.out.print(items[i]+" ");
		System.out.println();
	}
	private void decreaseKey(int index, int value){
		if(index < 0 && index >= size) throw new IndexOutOfBoundsException();
		
		items[index] = value;
		int parentIndex = getParent(index);
		while(parentIndex >= 0 && items[parentIndex] > items[index]){
			swap(index, parentIndex);
			parentIndex = getParent(parentIndex);
		}
		return;
	}
	public int extractMin(){
		if(size == 0) throw new IndexOutOfBoundsException();
		
		int result = items[0];
		items[0] = items[size-1];
		size--;
		heapify(0);
		return result;
	}
	public void insert(int value){
		if(size == capacity) throw new IndexOutOfBoundsException();
		
		size++;
		items[size-1] = Integer.MAX_VALUE;
		decreaseKey(size-1, value);
	}
	public int top() {
		if(size <= 0) throw new IndexOutOfBoundsException();
		
		return items[0];
	}
}
