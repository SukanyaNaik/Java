import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

	private ArrayList<String> grid = new ArrayList<String>();
	public String getuserInput(String prompt)
	{
		 String inputline = null;
		 
		 System.out.print(prompt + " - ");
		 
		 try
		 {
			 BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			 inputline = is.readLine();
			 if (inputline.length() == 0)
				 return null;
		 }
		 catch(IOException e)
		 {
			 System.out.println("IOException : " + e);
		 }
		 return inputline;
	}
	
	public ArrayList<String> setGame()
	{
		String alpha = "abcdefg";
		String cell = null;
		int rowColumn = 0, row = 0, column = 0, gridSize = 7;
		ArrayList<String> locations = new ArrayList<String>();
			
		while (row < 1 || (row+2) > gridSize)
			row = (int)(Math.random() * gridSize) % gridSize;
		
		cell = String.valueOf(alpha.charAt(row));
		
		while (column < 1 || (column+2) > gridSize)
			column = (int)(Math.random() * gridSize) % gridSize;

		rowColumn = (int) (Math.random() *2) % 2;
			
		//cell = cell.concat(Integer.toString(column));
		
		if (grid.indexOf(cell.concat(Integer.toString(column))) < 0 || (grid.isEmpty()))
		{
			grid.add(cell.concat(Integer.toString(column)));
			locations.add(cell.concat(Integer.toString(column)));	
		}
		else
		{
			while (grid.indexOf(cell.concat(Integer.toString(column))) < 0)
			{
				while (row < 1 || (row+2) > gridSize)
					row = (int)(Math.random() * gridSize) % gridSize;

				cell = String.valueOf(alpha.charAt(row));
				
				while (column < 1 || (column+2) > gridSize)
					column = (int)(Math.random() * gridSize) % gridSize;
				
				rowColumn = (int) (Math.random() *2) % 2;
			}
			//cell = cell.concat(Integer.toString(column));
			grid.add(cell.concat(Integer.toString(column)));
			locations.add(cell.concat(Integer.toString(column)));	
		}
		if (rowColumn == 1)
		{
			locations.add(cell.concat(Integer.toString(++column)));
			locations.add(cell.concat(Integer.toString(++column)));
		}
		else
		{
			cell = String.valueOf(alpha.charAt(++row));
			locations.add(cell.concat(Integer.toString(column)));
			cell = String.valueOf(alpha.charAt(++row));
			locations.add(cell.concat(Integer.toString(column)));
		}
			
		return locations;
	}
}
