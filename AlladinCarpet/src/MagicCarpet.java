
public class MagicCarpet {

	public static void main(String[] args) {
		
		int [] magic = {3, 2, 5, 4};
		int [] dist = {2, 3, 4, 2};
		
		//int [] magic = {2, 4, 5, 2};
		//int [] dist = {4, 3, 1, 3};
		
		//int [] magic = {2, 4, 5, 2};
		//int [] dist = {4, 3, 1, 6};
		
		int ifOptimal = MagicCarpet.optimalPoitnt(magic, dist);
		System.out.println(ifOptimal);
	}
	
	public static int optimalPoitnt(int [] magic, int []dist) {
		int ifOptimal = -1, i = 0;
		int magicPoints = magic[0];

		int size = magic.length;
		
		System.out.println("Points = " + magicPoints);
		
		for(i = 0; i < magic.length && ifOptimal == -1; i++) {
			
			magicPoints = magic[i];
			int j = (i+1) % size;
			
			if(magicPoints > dist[i]) {
				
				while(magicPoints >= 0 && j != i) {
				
					if(j == 0) {
						magicPoints = magicPoints - dist[size-1] + magic[j];
						System.out.println("Total Points = " + magicPoints + " | Dist = " 
								+ dist[size-1] + " Current points = " + magic[j] + " | Start = " + i);
					}
					else {
						magicPoints = magicPoints - dist[j-1] + magic[j];
						System.out.println("Total Points = " + magicPoints + " | Dist = " 
								+ dist[j-1] + " Current points = " + magic[j] + " | Start = " + i);
					}
					
					
					j++;
					if(j == magic.length) {
						j = (j % size);
					}
				}
			
				if(i == 0) {
					magicPoints = magicPoints - dist[size-1];
					//System.out.println("Total Points = " + magicPoints + " | Dist = " + dist[size-1] +
					//		" Current points = " + magic[size-1] + " | Start = " + i);
				}
				else {
					magicPoints = magicPoints - dist[j-1];
					//System.out.println("Total Points = " + magicPoints + " | Dist = " + dist[j-1] +
					//		" Current points = " + magic[j-1] + " | Start = " + i);
				}
				
				if(magicPoints >= 0) {
					ifOptimal = 1;
				}
			}	
			System.out.println("Points = " + magicPoints);
		}
		
		return ifOptimal;
	}

}
