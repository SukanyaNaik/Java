import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String> locationCells;
	private String name;
	
	public void setLocations(ArrayList<String> locations)
	{
		locationCells = locations;
	}
	
	public void setName(String dotComName)
	{
		name = dotComName;
	}
	
	public String checkYourself(String userInput)
	{
		String result = "Miss", ship = null;
		int location = -1;
		
		location = locationCells.indexOf(userInput);
		
		if(location >= 0)
		{
			locationCells.remove(location);
			
			if(locationCells.isEmpty())
			{
				result = "Kill";
				System.out.println(name + " is down.");
			}
			else
				result = "Hit";
		}
		
		return result;
	}

}
