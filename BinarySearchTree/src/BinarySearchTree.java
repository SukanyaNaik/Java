import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {
	
	public Node createBST(Node head) {
		Scanner in = new Scanner(System.in); 
		  
        if(head != null) {
        	System.out.println("Tree is already created");
        	return head;
        }
        else {
        	System.out.println("Enter number - ");
        	int no = in.nextInt(); 
        	//System.out.println("You entered integer "+a);
        
        	Node node = new Node();
        	node.data = no;
        	head = node;

        	System.out.println("do you want to add more numbers? (Y/N) - ");
    		
        	String ans =  in.nextLine();
        	ans = in.nextLine();
    		
    		while(ans.equals("y") || ans.equals("Y"))
        	{
    			System.out.println("Enter number - ");
            	no = in.nextInt();
            	
            	node = new Node();
            	node.data = no;
            	Node trav = head;
            	
            	while(trav != null) {
            		if(trav.data == no) {
            			System.out.println("Number is already present in the BST.");
            			break;
            		}
            		else if(trav.data > no) {
            			if(trav.lChild != null) 
            				trav = trav.lChild;
            			else {
            				trav.lChild = node;
            				break;
            			}
            		}
            		else {
            			if(trav.rChild != null) 
            				trav = trav.rChild;
            			else {
            				trav.rChild = node;
            				break;
            			}
            		}
            	}
            	System.out.println("do you want to add more numbers? (Y/N) - ");
        		in.nextLine();
        		ans = in.nextLine();
            }
        }
        	
        return head;
    }
	
	public void inorder(Node head) {
		Stack <Node>stack = new Stack<>();
		Node trav = head;
		
		if(trav == null) {
			System.out.println("The BST is not created.");
		}
		else {
			System.out.println("The BST in inorder traversal is - ");
			while(trav != null) {
				while(trav.lChild != null) {
					stack.push(trav);
					trav = trav.lChild;
				}
				System.out.print(trav.data + " ");
				
				if(trav.rChild != null) 
					trav = trav.rChild;
				else {
					boolean flag = true;
					
					while(flag)
					{
						if(stack.isEmpty()) {
							trav = null;
							flag = false;
						}
						else {
							trav = stack.pop();
							System.out.print(trav.data + " ");
						
							if(trav.rChild!=null)
							{
								trav = trav.rChild;
								flag = false;
							}
						}
					}
				}
			}
			System.out.println("\n");
		}
	}
	
	
	public boolean contains(Node head, int no) {
		boolean isPresent = false;
		Stack <Node>stack = new Stack<>();
		Node trav = head;
		
		if(trav == null) {
			System.out.println("The BST is not created.");
		}
		else {
			while(trav != null && isPresent == false) {
				if(trav.data == no) {
					isPresent = true;
				}
				else if(trav.data > no) {
					if(trav.lChild != null)
						trav = trav.lChild;
					else if (trav.rChild != null)
						trav = trav.rChild;
					else trav = null;
				}
				else {
					if (trav.rChild != null)
						trav = trav.rChild;
					else trav = null;
				}
			}
		}
		return isPresent;
	}
	
	public void levelWisePrinting(Node head) {
		Node trav = head;
		
		if(head == null)
			System.out.println("The BST is not created");
		else {
			Queue <Node>q = new LinkedList<Node>();
			System.out.print(trav.data + " ");
			
			while(trav != null) {
				if(trav.lChild != null) {
					System.out.print(trav.lChild.data + " ");
					q.add(trav.lChild);
				}
					
				if (trav.rChild != null)
				{
					System.out.print(trav.rChild.data + " ");
					q.add(trav.rChild);
				}
				trav = q.poll();
			}
			System.out.println("\n");
		}
		
	}
}
	

