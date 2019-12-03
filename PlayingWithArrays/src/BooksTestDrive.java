
public class BooksTestDrive {

	public static void main(String[] args) {
		int i = 0;
		Books myBooks[] = new Books[3];
		
		for (i = 0; i <3; i++)
			myBooks[i] = new Books();
		
		myBooks[0].title = "Head First java";
		myBooks[0].author = "Kathy Sierra";
		myBooks[0].price = (float)20.5;
		
		myBooks[1].title = "Java for Dummies";
		myBooks[1].author = "Doug Lowe";
		myBooks[1].price = (float)10.95;
		
		myBooks[2].title = "Java a Beginner's Guide";
		myBooks[2].author = "Herbert Schildt";
		myBooks[2].price = (float)15.99;
		
		for(i = 0; i < 3; i++)
		{
			myBooks[i].display();
			System.out.println("\n");
		}

	}

}
