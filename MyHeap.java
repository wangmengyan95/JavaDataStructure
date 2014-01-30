
public class MyHeap {
	private int capacity;
	private int size;
	private int[] items;
	
	public MyHeap(){
		size = 0;
		initialize(10);
	}
	public void initialize(int capacity){
		if(capacity <= this.capacity) return;
		
		int[] newItsms = new int[capacity];
		for(int i=0; i<=size-1; i++) newItsms[i] = items[i];
		items = newItsms;
		this.capacity = capacity;
		return;
	}
	private int getParent(int i){
		if(i <= 0) return -1;
		return (i-1)/2;
	}
	private int getLeftChild(int i){
		return i*2+1;
	}
	private int getRightChild(int i){
		return i*2+2;
	}
	private void swap(int index1, int index2){
		if(index1 >= size || index1 < 0 || index2 >= size || index2 < 0) return;
		
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	private void heapify(int index){
		if(index >= size && index < 0) return;
		
		int l = getLeftChild(index);
		int r = getRightChild(index);
		
		int largestIndex = index;
		if(l <= size-1 && items[l] > items[largestIndex]) largestIndex = l;
		if(r <= size-1 && items[r] > items[largestIndex]) largestIndex = r;
		
		if(largestIndex != index){
			swap(index, largestIndex);
			heapify(largestIndex);
		}
	}
	public void increaseKey(int index, int key){
		if(index >= size && index < 0) return;
		if(items[index] >= key) return;
		
		items[index] = key;
		while(getParent(index) >= 0 && items[getParent(index)] < items[index]){
			swap(getParent(index), index);
			index = getParent(index);
		}
		return;
	}
	public void insert(int key){
		size++;
		items[size-1] = Integer.MIN_VALUE;
		increaseKey(size-1, key);
	}
	public void print(){
		for(int i=0; i<=size-1;i++) System.out.print(items[i]+ " ");
		System.out.println();
		return;
	}
	public int extractMax(){
		if(size == 0) throw new IndexOutOfBoundsException();
		
		int result = items[0];
		items[0] = items[size-1];
		size--;
		heapify(0);
		return result;
	}
}
