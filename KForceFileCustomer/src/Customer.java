import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Customer {

	public static void main(String[] args) {
	       File inputFile = new File("data.txt");
	       
	       BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(inputFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
	        
	        String str = " ";
	        int noOfCustomers = 0;
	        
	        HashMap <String, Integer> city = new HashMap<String, Integer>();
	        HashMap <String, Integer> country = new HashMap<String, Integer>();
	        
	        int i = 0;
	        try {
				while ((str = br.readLine()) != null) {
					if(i == 0) {
						i++;
					}
					else {
						noOfCustomers++;
						String [] splitStr = str.split(",");
						String strCity = splitStr[2];
						String strCountry = splitStr[3];
	                
						if(city.containsKey(strCity)){
							int cityCount = city.get(strCity);
							city.replace(strCity, cityCount, cityCount+1);
						}
						else{
							city.put(strCity, 1);
						}
	                
						if(country.containsKey(strCountry)){
							int countryCount = country.get(strCountry);
							city.replace(strCountry, countryCount, countryCount+1);
						}
						else{
							country.put(strCountry, 1);
						}
					}
	            }
	            
	            System.out.println("Total customers:\n" + (noOfCustomers));

	            System.out.println("Customers by city");
	            /* for (Entry<String, Integer> myCity : city.entrySet()) {
	                System.out.println(myCity.getKey() + ":" + myCity.getValue());
	               
	            }*/       
	            city.forEach((k,v) ->{
            			if(!k.equals("CITY")) {
            				System.out.println(k + ":" + v);
            			}
            		}
	            );

	            System.out.println("Customers by country");
	            /*for (Entry<String, Integer> myCountry : country.entrySet()) {
	                System.out.println(myCountry.getKey() + ":" + myCountry.getValue());
	               
	            }*/
	            country.forEach((k,v)-> System.out.println(k + ":" + v));
	        } 
			catch (IOException e) {
				e.printStackTrace();
			}

	}

}

/*
 Total customers:
7
Customers by city:
Chicago: 1
London: 2
Manchester: 1
San Francisco: 2
Sydney: 1
Customers by country:
Australia: 1
UK: 3
USA: 3
Country with the largest number of customers' contracts:
USA (25607 contracts)
Unique cities with at least one customer:
5

ID,NAME,CITY,COUNTRY,CPERSON,EMPLCNT,CONTRCNT,CONTRCOST
00000001,Breadpot,Sydney,Australia,Sam.Keng@info.com,250,48,1024.00
00000002,Hoviz,Manchester,UK,harry.ham@hoviz.com,150,7,900.00
00000003,Hoviz,London,UK,hamlet.host@hoviz.com,1500,12800,10510.50
00000004,Grenns,London,UK,grenns@grenns.com,200,12800,128.30
00000005,Magnolia,Chicago,USA,man@info.com,1024,25600,512000.00
00000006,Dozen,San Francisco,USA,dozen@dozen.com,1000,5,1000.20
00000007,Sun,San Francisco,USA,sunny@sun.com,2000,2,10000.01
 */
