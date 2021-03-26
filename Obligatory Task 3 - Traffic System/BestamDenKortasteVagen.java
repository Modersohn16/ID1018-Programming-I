import java.io.PrintWriter;
import java.util.Scanner;

public class BestamDenKortasteVagen 
{
	public static void main(String[] args) 
	{
		int m = 3; 
		int n = 4;
		System.out.println("To type in own data choose 1. To use ready data choose 2");
		Scanner in = new Scanner(System.in);
		int DataChosen = in.nextInt();
		boolean isDataChosen = false;
		
		switch(DataChosen)
		{
			case 1:
				System.out.println("Write a number of V stations: ");
				m = in.nextInt();
				System.out.println("Write a number of U stations: ");
				n = in.nextInt();
				isDataChosen = true;
				break;
			case 2:
				break;
			default:
				break;
		}
		double a[] = new double[m+1];
		double b[][] = new double[m+1][n+1];
		double c[] = new double[n+1];
		double d[][] = new double[m+1][n+1];
		double langd; 
		int[] mellanstationer = new int[3];
		
		// this is a ready dataset for test purposes
		if(!isDataChosen) 
		{
		a[1] = 2;
		a[2] = 5;
		a[3] = 10;
		b[1][1] = 2;
		b[1][2] = 4;
		b[1][3] = 1;
		b[1][4] = 8;
		b[2][1] = 3;
		b[2][2] = 2;
		b[2][3] = 1;
		b[2][4] = 4;
		b[3][1] = 7;
		b[3][2] = 20;
		b[3][3] = 10;
		b[3][4] = 3;
		c[1] = 4;
		c[2] = 8;
		c[3] = 1;
		c[4] = 2;
		}
		
		// typing in data (distances) manually
		if(isDataChosen) 
		{
			for(int i = 1; i < a.length;i++)
			{
				System.out.println("Type in distance a " + i + ": ");
				a[i] = in.nextDouble();
				for(int j = 1; j < c.length; j++) 
				{
					System.out.println("Type in distance b " + i + j +": ");
					b[i][j] = in.nextDouble();
				}
			}
			for(int j = 1; j < c.length; j++) 
			{
				System.out.println("Type in distance c " + j + ": ");
				c[j] = in.nextDouble();
			}
		}
		// invoking methods that calculate the distance of the shortest path and the indexes of stations
		langd = DenKortasteVagen.langd(a, b, c);
		System.out.println("The shortest route has a distance: " + langd);
		mellanstationer = DenKortasteVagen.mellanstationer(a, b, c);
		System.out.println("You should take the route through station U" + mellanstationer[1] + " and V" + mellanstationer[2]);
	}
}
