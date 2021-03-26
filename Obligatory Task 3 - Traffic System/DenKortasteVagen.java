
public class DenKortasteVagen {

	// Method langd returns the distance of the shortest route possible.
	public static double langd(double[] a, double[][] b, double[] c)
	{
		double[][] distances = new double[a.length][c.length];
		// in this loop all the distances are added and stored in an array distances[][]
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < c.length; j++) 
			{
				distances[i][j] = a[i]+b[i][j]+c[j];
				System.out.println("Distance of route V" + i + " U" + j + " is: " + distances[i][j]);
			}
		}
		// executed only once, first distance inserts into shortestDistance double
		double shortestDistance = distances[1][1]; 
		
		// comparison of shortestDistance double and the next distance.
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < c.length; j++) 
			{
				if(shortestDistance > distances[i][j]) 
				{
					shortestDistance = distances[i][j];
					
				}
			}
		}
		return shortestDistance;
	}
	
	// mellanstationer returnerar en vektor med de mellanstationer som finns pa den kortaste
	// vagen. Ordningsnummer av den forsta mellanstationen finns pa index 1, och ordningsnummer
	// av den andra mellanstationen pa index 2 i vektorn.
	public static int[] mellanstationer(double[] a, double[][] b, double[] c)
	{
		int[] mellanstationer = new int[3];
		double[][] distances = new double[a.length][c.length];
		// in this loop all the distances are added and stored in the array distances[][]
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < c.length; j++) 
			{
				distances[i][j] = a[i]+b[i][j]+c[j];
			}
		}
		
		// first distance inserts into shortestDistance double (executed only once)
		double shortestDistance = distances[1][1];
		
		// In this loop the shortest route is chosen and the indexes of the stations are stored in the array mellanstationer[]
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < c.length; j++) 
			{
				if(shortestDistance>distances[i][j]) 
				{
					shortestDistance = distances[i][j];
					mellanstationer[1] = i;
					mellanstationer[2] = j;
				}
			}
		}
		return mellanstationer;
	}
	


}
