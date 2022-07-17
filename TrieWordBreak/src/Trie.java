
public class Trie {
	Node root;
	
	
	public Trie() {
		root = new Node('*'); 
	}


	public void insert(String word) {
		Node curr = root;
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int position = ch - 'a';
			if(curr.children[position] == null)
				curr.children[position] = new Node(ch);
			curr = curr.children[position];
		}
		curr.isWord = true;
	}
}
