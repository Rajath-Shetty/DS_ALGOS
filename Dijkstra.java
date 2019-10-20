import java.util.*;

public class Dijkstra
{
	public int path[];
	public int dijk[];

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Dijkstra dij=new Dijkstra();
		System.out.println("Enter the number of vertices");
		int n=sc.nextInt();
		int wt[][]=new int[10][10];
		System.out.println("Enter the weighted matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				wt[i][j]=sc.nextInt();
		System.out.println("Enter source vertex");
		int s=sc.nextInt();
		dij.dijkstraAlgo(wt,n,s);
		dij.display(n,s);
	}

	void dijkstraAlgo(int wt[][],int n,int s)
	{
		int visited[]=new int[10];
		dijk=new int[10];
		path=new int[10];
		int i,min,j,a=-1,k;
		for(i=0;i<n;i++)
		{
			dijk[i]=999;
			path[i]=-1;
		}
		dijk[s]=0;
		for(i=0;i<n;i++)
		{
			min=999;
			for(j=0;j<n;j++)
			{
				if(dijk[j]<min&&visited[j]==0)
				{
					min=dijk[j];
					a=j;
				}
			}
			visited[a]=1;
			for(k=0;k<n;k++)
			{
				if(dijk[a]+wt[a][k]<dijk[k]&&a!=k&&visited[k]==0)
				{
					dijk[k]=dijk[a]+wt[a][k];
					path[k]=a;
				}
			}
		}
	//	for(i=0;i<n;i++)
	//		System.out.print(path[i]+" ");
	//	System.out.println();
	}

	void display(int n,int s)
	{
		System.out.println("The shortest path to other vertices are");
		for(int i=0;i<n;i++)
		{
			if(i!=s)
			{
				System.out.print(s+" ");
				path1(i,s);
				System.out.print("="+dijk[i]+" ");
				System.out.println();
			}
		}
	}

	void path1(int i,int s)
	{
		if(path[i]!=-1)
			path1(path[i],s);
		if(i!=s)
			System.out.print("->"+i+" ");
	}
}
