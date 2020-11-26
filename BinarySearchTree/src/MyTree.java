import java.util.Scanner;

public class MyTree {

	public static void main(String[] args) {
		Node head = null;
		BinarySearchTree bst = new BinarySearchTree();
		
		Scanner in = new Scanner(System.in);
		String ans;
		do {
			System.out.println("********** Menu **********");
			System.out.println("1. Create a BST.");
			System.out.println("2. Print the BST (Inorder).");
			System.out.println("3. Find a number in the BST.");
			System.out.println("4. Print the BST in level wise order.");
			System.out.println("**************************");
			System.out.println("Enter your choice - ");
			int choice = in.nextInt();		
			switch(choice) {
				case 1: head = bst.createBST(head); 
						break;
				case 2: bst.inorder(head); 
		    			break;
		    	case 3: boolean isPresent = false;
		    			System.out.println("Enter the number - ");
		    			int no = in.nextInt(); 
		    			isPresent = bst.contains(head, no);
		    			if(isPresent)
		    				System.out.println(no + " is present in the BST.");
		    			else 
		    				System.out.println(no + " is not present in the BST.");
		    			break;
		    	case 4: bst.levelWisePrinting(head);
		    			break;
		    	default:break;
			}
			
			System.out.println("Do you want to continue? (Y/N) ");
			in.nextLine();
        	ans = in.nextLine();
		}while(ans.equals("Y") || ans.equals("y"));
	}

}
