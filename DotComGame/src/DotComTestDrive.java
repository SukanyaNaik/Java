import java.util.ArrayList;

public class DotComTestDrive {

	public static void main(String[] args) {
		
		ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
		GameHelper helper = new GameHelper();
		
		DotCom one = new DotCom();
		DotCom two = new DotCom();
		DotCom three = new DotCom();
		
		one.setName("Pirates.com");
		two.setName("Cruise.com");
		three.setName("Battles.com");
		
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		for (DotCom DC : dotComList)
		{
			ArrayList<String> locations = new ArrayList<String>();
			
			locations = helper.setGame();
			System.out.println();
			for (String temp : locations)
			{
				System.out.print(temp + "  ");
			}
			System.out.println();
			DC.setLocations(locations);
		} 
		
		String result = "miss";
		String userGuess = null;

		while (dotComList.size() != 0 )
		{
			result = "miss";
			userGuess = helper.getuserInput("Enter user guess");
			
			
			
			
			for (DotCom DC : dotComList)
		    {
		    	result = DC.checkYourself(userGuess);
		    				
		    	if (result.equals("Hit"))
		    		break;
		    	if (result.equals("Kill"))
		    	{
		    		dotComList.remove(DC);
		    		break;
		    	}
		    }
			System.out.println(result);
		}
		
	}

}
