
public class SimpleDotCom {
	private	int []locationCells = new int[3];
	private	int noOfHits = 0;
		
	public void setLocations(int []locs)
	{
		//int i = 0;
		
		System.out.println("The locations are - ");
		/*for(i = 0 ; i < 3; i++)
		{
		    locationCells[i] = locs[i];
		    System.out.print(locationCells[i] + " ");
		}*/
		
		locationCells = locs;
		for (int num : locationCells)
		{
			System.out.print(num + " ");
		}
		System.out.println("\n");
	}
	
	public String checkYourSelf(String userGuess)
	{
		String result = "Miss";
		int location = 0, i = 0;
		
		location = Integer.parseInt(userGuess);
		
		System.out.println("User Guess is - " + location);
		
		while (result.equals("Miss") && i < 3)
		{
			if (locationCells[i] == location)
			{
				noOfHits++;
				locationCells[i] = -1;
				if (noOfHits == locationCells.length)
					result = "Kill";
				else
					result = "Hit";
			}
			i++;
		}
		
		return result;
	}
}
