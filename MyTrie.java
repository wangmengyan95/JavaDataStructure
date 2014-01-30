import java.util.TreeMap;


public class MyTrie {
	class TrieNode{
		public boolean isLeaf;
		public TreeMap<Character, TrieNode> map;
		public int count;
		
		public TrieNode(){
			this.isLeaf = false;
			this.map = new TreeMap<Character, MyTrie.TrieNode>();
			this.count = 0;
		}
		public TrieNode(boolean isLeaf, TreeMap<Character, TrieNode> map, int count){
			this.isLeaf = isLeaf;
			this.map = map;
			this.count = count;
		}
	}
	
	TrieNode root;
	
	public MyTrie(){
		root = new TrieNode();
	}
	
	public void insert(String s){
		TrieNode current = root;
		for(int i=0; i<=s.length()-1; i++){
			char c  = s.charAt(i);
			if(!current.map.containsKey(c)) current.map.put(c, new TrieNode());
			current = current.map.get(c);
		}
		current.count++;
		current.isLeaf = true;
		return;
	}
	
	public void printTrie(){
		if(root == null) return;
		print(root, "");
	}
	private void print(TrieNode node, String s){
		for(Character c : node.map.keySet()){
			print(node.map.get(c), s+String.valueOf(c));
		}
		if(node.isLeaf){
			for(int i=0; i<=node.count-1; i++) System.out.println(s);
		}
	}
}
