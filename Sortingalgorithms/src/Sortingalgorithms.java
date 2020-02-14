import java.io.*;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Sortingalgorithms {
	
	//int a[] = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
	int a[] = {29, 72, 98, 13, 87, 66, 52, 51, 36};
	
	public static void main(String[] args) {
	
		//int a[] = {6,5,3,1,8,7,2,4};
		//int a[] = {4,3,2,10,12,1,5,6};
		//int a[] = {29, 72, 98, 13, 87, 66, 52, 51, 36};
	
		int i = 0;
		
		Sortingalgorithms s = new Sortingalgorithms();
		
		System.out.println("The original array is - ");
		for (i = 0; i < s.a.length; i++) {
			System.out.print(s.a[i] + " ");
		}
		
		/* QUICK SORT */
		
		int left = 0, right = 0;
		right = s.a.length-1;
		s.QuickSort(left, right, s);
		
		System.out.println("\n\nThe sorted array is - ");
		for (i = 0; i <s.a.length; i++) {
			System.out.print(s.a[i] + " ");
		}
	}
	
	
	public void BubbleSort(Sortingalgorithms s) {
		
		int i = 0, j = 0,  n = 0, temp = 0;
		
		for(n = a.length; n >= 1; n--)
		{
			for(i = 0; i < n-1; i++)
			{
				if(	a[i] > a[i+1])
				{
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			
		}
	}
	
	
	public void InsertionSort(Sortingalgorithms s) {
		
		int i = 0, j = 0,  n = 0, temp = 0;
		
		for(n = 1; n < a.length; n++)
		{
			for(j = 0; j < n; j++)
			{
				if(a[j] > a[n])
				{
					temp = a[n];
					for(i = n; i > j; i--)
					{
						a[i] = a[i-1];
					}
					a[i] = temp;
					break;
				}
			}
		}
	}
	
	
	public void SelectionSort(Sortingalgorithms s) {
		
		int i = 0, j = 0, temp = 0, min = 0, pos = 0;
		
		for(i = 0; i < a.length; i++)
		{
			min = a[i];
			for(j = i+1; j < a.length; j++)
			{
				if(min > a[j])
				{
					min = a[j];
					pos = j;
				}
			}
			
			if(a[i] > min)
			{
				temp = a[i];
				a[i] = a[pos];
				a[pos] = temp;
			}
		}
	}
	
	public void QuickSort(int left, int right, Sortingalgorithms s) {
		
		int pivot = 0, partitionIndex = 0;
		
		if((right - left) <= 0) {
			return;
		}
	
		else {
			pivot = s.a[right];
			
			partitionIndex = partition(left, right, pivot, s);
			
			QuickSort(left, partitionIndex-1, s);
			QuickSort(partitionIndex+1, right, s);
		}
	}
	
	int partition(int left, int right, int pivot, Sortingalgorithms s) {
		
		int l = 0, r = 0, temp = 0;
		boolean flag = true;
		
		l = left;
		r = right - 1;
		
		while (flag) {
			while(l <= s.a.length && s.a[l] < pivot) {
				l++;
			}
			
			while(r >= 0 && s.a[r] > pivot) {
				r--;
			}
			
			if(l >= r) {
				flag = false;
			}
			else {
				temp = s.a[l];
				s.a[l] = s.a[r];
				s.a[r] = temp;
			}
		}
		
		temp = s.a[l];
		a[l] = s.a[right];
		s.a[right] = temp;
		
		return l;
	}

}
