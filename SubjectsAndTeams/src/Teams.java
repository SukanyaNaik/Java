
public class Teams {

	public static void main(String[] args) {
		//String subjects = "pcmbz";
		//String subjects = "pcmpcmbbbzz";
		//String subjects = "pcmpp";
		String subjects = "mppzbmbpzcbmpbmczcz";
		int no = Teams.differentTeams(subjects);
		System.out.println("Number of teams - " + no);
		
	}
	
	public static int differentTeams(String subjects) {
		int numberOfTeams = 0;
		
		String str = new String();
		String ifAll = new String();
		char sub = ' ';
		int i = 0;
		int count = 0, flag = 0;
		for(i = 0; i < 5; i++)
		{
			count = 0;
			flag = 0;
			
			switch (i) {
				case 0: sub = 'p';
						break;
				case 1: sub = 'c';
						break;
				case 2: sub = 'm';
						break;
				case 3: sub = 'b';
						break;
				case 4: sub = 'z';
						break;
			}
			
			for(int j = 0; j < subjects.length(); j++) {
				if(subjects.charAt(j) ==  sub) {
					str = str.concat(Character.toString(sub));
					count++;
					flag = 1;
				}
			}
			
			if(flag == 1) {
				ifAll = ifAll.concat(Character.toString(sub));
			}
			
			if(i == 0) {
				numberOfTeams = count;
			}
			if(count < numberOfTeams) {
				numberOfTeams = count;
			}
		}
		
		System.out.println(str);
		if(!ifAll.contains("pcmbz")) {
			numberOfTeams = 0;
		}
		return numberOfTeams;
	}

}
