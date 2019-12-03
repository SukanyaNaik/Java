public class SimpleDotComTestDrive {

	public static void main(String[] args) {
		
		SimpleDotCom o1 = new SimpleDotCom();
		int []locations = new int[3];
		
		locations[0] = 3;
		locations[1] = 4;
		locations[2] = 5;

		o1.setLocations(locations);
		
		String result = "Miss";
		
		GameHelper helper = new GameHelper();
		String userGuess = helper.getuserInput("Enter user guess");
		
		/*String []userGuess = new String[5];
		
		userGuess[0] = "2";
		userGuess[1] = "3";
		userGuess[2] = "4";
		userGuess[3] = "5";
		userGuess[4] = "1";*/
		
		//int i = 0;
		
		while (!(result.equals("Kill")))
		{
			result = o1.checkYourSelf(userGuess);
			System.out.println("The result is - " + result);
			
			if (!(result.equals("Kill")))
				userGuess = helper.getuserInput("Enter user guess");
			//i++;
		}
		
	}

}
