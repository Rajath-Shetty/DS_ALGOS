import java.util.*;
import java.util.Random;

public class KnapSackGreedy
{
	public static void main(String args[])
	{
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Knapsack capacity");
		int capacity = sc.nextInt();
//		System.out.println("Capacity is "+capacity);
		System.out.println("Enter number of elements");
		int n=sc.nextInt();
//		System.out.println("Elements is "+n);
		ArrayStructure a[]=new ArrayStructure[n];
		KnapSackGreedy obj= new KnapSackGreedy();
		for(int i=0;i<n;i++)
		{
			a[i]=new ArrayStructure();
			System.out.println("Enter weight "+(i+1));
			a[i].weight=sc.nextInt();
			System.out.println("Enter price "+(i+1));
			a[i].price=sc.nextInt();
		}
		obj.displayArrayDetails(a,n);
		int profit=obj.KnapSack(a,n,capacity);
		System.out.println("The maximum profit for KnapSack 0/1 by Greedy Method is "+profit);
	}
	void displayArrayDetails(ArrayStructure a[],int n)
	{
		for(int i=0;i<n;i++)
			System.out.println("Weight: "+a[i].weight+"\t Price: "+a[i].price);
	}
	int KnapSack(ArrayStructure a[],int n,int capacity)
	{
		int max=0,profit=0;
		for(int i=0;i<n && capacity>0;i++)
		{
			for(int b=0;b<n;b++)
				max=(a[b].price>a[max].price)?b:max;
			if(a[max].weight<=capacity)
			{
				profit+=a[max].price;
				a[max].price=-1;
				capacity-=a[max].weight;
			}
			else
				a[max].price=-1;
		}
//		displayArrayDetails(a,n);
		return profit;
	}
}

class ArrayStructure
{
	int weight;
	int price;
}
