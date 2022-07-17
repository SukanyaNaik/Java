
public class Node {
	char c;
	boolean isWord;
	Node children[];
	
	public Node(char c) {
		super();
		this.c = c;
		isWord = false;
		children = new Node[26];
	}
}
