
public class Node {
	char c;
	boolean  isWord;
	Node[] children;
	
	public Node(char c) {
		super();
		this.c = c;
		this.isWord = false;
		this.children = new Node[26];
	} 
	
	
}
