import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

//public class CurrencyFormatter {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
//        scanner.close();
//       
//        NumberFormat US = NumberFormat.getCurrencyInstance(Locale.US);
//        System.out.println("US: " + US.format(payment));
//       
//        Locale IndiaLocale = new Locale("en", "IN");
//        NumberFormat India = NumberFormat.getCurrencyInstance(IndiaLocale);
//        System.out.println("India: " + India.format(payment));
//        
//        NumberFormat China = NumberFormat.getCurrencyInstance(Locale.CHINA);
//        System.out.println("China: " + China.format(payment));
//        
//        NumberFormat France = NumberFormat.getCurrencyInstance(Locale.FRANCE);
//        System.out.println("France: " + France.format(payment));
        


public class CurrencyFormatter{
	
	   static Iterator func(ArrayList mylist){
	      Iterator it=mylist.iterator();
	      while(it.hasNext()){
	    	  
	         Object element = it.next();
	         
	         //if(element instanceof String)//Hints: use instanceof operator
	        	 if(element instanceof String) {
       				break;
	        	 }
	        	// mylist.remove(element);
			}
	      return it;
	      
	   }
	   @SuppressWarnings({ "unchecked" })
	   public static void main(String []args){
	      ArrayList mylist = new ArrayList();
	      Scanner sc = new Scanner(System.in);
	      int n = sc.nextInt();
	      int m = sc.nextInt();
	      for(int i = 0;i<n;i++){
	         mylist.add(sc.nextInt());
	      }
	      
	      mylist.add("###");
	      for(int i=0;i<m;i++){
	         mylist.add(sc.next());
	      }
	      
	      System.out.println("ArrayList - " );
	      Iterator it1=mylist.iterator();
	      while(it1.hasNext()){
		         Object element = it1.next();
		         if(element instanceof String) {
		        	 System.out.println((String)element);
		         }
		         else {
		        	 System.out.println((int)element);
		         }
		      }
	      Iterator it=func(mylist);
	      while(it.hasNext()){
	         Object element = it.next();
	         System.out.println((String)element);
	      }
	   }
	}
