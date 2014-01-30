
public class MyArrayList<Anytype> {
	private int capacity;
	private int size;
	private Anytype[] theItems;
	
	public MyArrayList(){
		ensureCapacity(2);
		this.size = 0;
	}
	public MyArrayList(int capacity){
		ensureCapacity(this.capacity);
		this.size = 0;
	}
	public int size(){
		return this.size;
	}
	private void ensureCapacity(int capacity){
		if(capacity <= this.capacity) return;
		
		Anytype[] oldItems = this.theItems;
		this.theItems = (Anytype[]) new Object[capacity];
		
		for(int i=0; i<=this.size-1; i++) theItems[i] = oldItems[i];
		this.capacity = capacity;
		return;
	}
	public boolean add(Anytype item){
		return this.add(item, this.size);
	}
	public boolean add(Anytype item, int index){
		if(index > this.size || index < 0) throw new ArrayIndexOutOfBoundsException();
		
		if(this.size == this.capacity) ensureCapacity(this.capacity*2);
		
		for(int i=this.size-1; i>=index; i--) this.theItems[i+1] = this.theItems[i];
		this.theItems[index] = item;
		
		this.size++;
		return true;
	}
	public Anytype remove(int index){
		if(index >= this.size || index < 0) throw new ArrayIndexOutOfBoundsException();
		
		Anytype deleteItem = this.theItems[index];
		for(int i=index+1; i<=this.size-1; i++) this.theItems[i-1] = this.theItems[i];
		
		this.size--;
		
		return deleteItem;
	}
	public Anytype get(int index){
		if(index >= this.size || index < 0) throw new ArrayIndexOutOfBoundsException();
		return this.theItems[index];
	}
}
