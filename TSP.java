import java.util.*;

public class TSP
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		TSP tsp=new TSP();
		System.out.println("Enter number of nodes");
		int n=sc.nextInt();
		System.out.println("Enter weight of matrix");
		int wt[][]=new int[10][10];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				wt[i][j]=sc.nextInt();
		System.out.println("Enter starting node");
		int s=sc.nextInt();
		int mark[] = new int[n];
		mark[0] = 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int set[]=new int[10];
		set[0]=0;
		for(int i=1;i<n;i++)
			set[i]=1;
		System.out.println("Cost is : "+(tsp.tspCheck(wt,n,s,set)));
		System.out.println("Path is : ");
		tsp.pathCheck(wt,n,mark,stack);
	}
	
	int tspCheck(int wt[][],int n,int s,int set[])
	{
		if(zeroCheck(set))
			return wt[s][0];
		else
		{
			ArrayList<Integer> arr=new ArrayList<Integer>();
			for(int i=1;i<n;i++)
			{
				if(set[i]==1)
				{
					set[i]=0;
					arr.add(wt[s][i]+tspCheck(wt,n,i,set));
					set[i]=1;
				}
			}
			return Collections.min(arr);
		}
	}
	
	boolean zeroCheck(int set[])
	{
	//	int i=0;
		for(int i : set)
			if(i!=0)
				return false;
		return true;
	}

	void pathCheck(int wt[][],int n,int mark[],Stack<Integer> stack)
	{
		int ele,i,min,a=0;
		boolean flag=false;
		System.out.print(0+"\t");
		while (!stack.isEmpty())
		{
			ele = stack.peek();
			i = 0;
			min = 999;
			while (i < n)
			{
				if (wt[ele][i] > 1 && mark[i] == 0)
				{
					if (min > wt[ele][i])
					{
						min = wt[ele][i];
						a = i;
						flag = true;
					}
				}
				i++;
			}
			if (flag)
			{
				mark[a] = 1;
				stack.push(a);
				System.out.print(a + "\t");
				flag = false;
				continue;
			}
			stack.pop();
		}
		System.out.println();
	}
}				
