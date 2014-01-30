import java.util.HashMap;

public class LRUCache {
    int capacity = 0;
    int size = 0;
    
    class ListNode{
        public ListNode next;
        public ListNode prev;
        public int key;
        public int value;
        public ListNode(ListNode next, ListNode prev, int key, int value){
            this.next = next;
            this.prev = prev;
            this.key = key;
            this.value = value;
        }
    }
    
    HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    ListNode dummyHead = new ListNode(null, null, -1, -1);
    ListNode tail = dummyHead;
    
    private void deleteNode(ListNode node){
    	if(node == tail) tail = tail.prev;
        node.prev.next = node.next;
        if(node.next!= null) node.next.prev = node.prev;
    }
    private void addNode(ListNode prev, ListNode node){
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        if(node.next != null) node.next.prev = node;
        if(tail == dummyHead) tail = dummyHead.next;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            result = node.value;
            
            deleteNode(node);
            addNode(dummyHead, node);
        }
        return result;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	ListNode node = map.get(key);
            node.value  = value;
            deleteNode(node);
            addNode(dummyHead, node);
        }
        else{
            size++;
            if(size > capacity){
                map.remove(tail.key);
                deleteNode(tail);
                size--;
            }
            ListNode newHead = new ListNode(null, null, key, value);
            addNode(dummyHead, newHead);
            map.put(key, newHead);
        }
        return;
    }
    
    
    public void printList(){
    	ListNode current = dummyHead.next;
    	while(current != null){
    		System.out.print(current.key+"|"+current.value+"->");
    		current = current.next;
    	}
    	if(tail != null) System.out.print("tail" +tail.key+"|"+tail.value);
    	System.out.println();
    }
}