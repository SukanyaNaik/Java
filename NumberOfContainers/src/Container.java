
public class Container {

	public static void main(String[] args) {
		
		String []scenarios = {"10 2 5", "12 4 4", "8 2 2"};
		
		Container.maximumContainers(scenarios);
	}

	public static void maximumContainers(String []scenarios) {
		
		int totalContainers = 0, remender = 0, quotient = 0;
		
		for(int i = 0; i < scenarios.length; i++) {
			totalContainers = 0;
			remender = 0;
			quotient = 0;
			
			String []str = scenarios[i].split(" ");
			
			totalContainers = Integer.parseInt(str[0]) / Integer.parseInt(str[1]);
			
			if(totalContainers >= Integer.parseInt(str[2])) {
				remender = totalContainers % Integer.parseInt(str[2]);
				quotient = totalContainers / Integer.parseInt(str[2]);
				
				totalContainers = totalContainers + quotient;
				
				 while(quotient > 1) {
					 remender = quotient % Integer.parseInt(str[2]);
					 quotient = quotient / Integer.parseInt(str[2]);
					 totalContainers = totalContainers + quotient;
				 }
				 
				 if(remender > 0 && (remender + quotient) >= Integer.parseInt(str[2])) {
					 totalContainers++;
				 }
			}
			
			System.out.println("totalContainers = " + totalContainers);
		}
	}
}
