import java.lang.Math;
public class Punkt {

	int x;
	int y;
	String name = new String("");
	double avstand;
	
	// constructor for an object Punkt. A new object punkt is constructed and name, x and y coordinates are set to the object Punkt. 
	Punkt (String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	// toString  method lets us print out the point object in this form, ex. "A 3 2".
	public String toString()
	{
		String p = new String(name + " " + x + " " + y + "");
		return p;
	}
	
	// avstand method calculates the distance between 2 points. 
	public double avstand(Punkt p2)
	{ 
		double xx = x - p2.x;
		double yy = y - p2.y;
		return Math.sqrt(Math.pow(xx, 2) + Math.pow (yy, 2)); 
	}
	
	// equals returns a boolean true if x and y coordinates of a Punkt are equal to another object's Punkt.
	public boolean equals (Punkt p2) 
	{
		return (x == p2.x && y == p2.y);
	}
	
	// setX method sets coordinate x to the point (Punkt object)
	public void setX(int x) 
	{
		this.x = x;
	}
	// setX method sets coordinate x to the point (Punkt object)
	public void setY(int y) 
	{
		this.y = y;
	}
	// getNamn method returns the name of the point (Punkt object)
	public String getNamn () {
		return name;
	}
	// getX method returns coordinate x of the point (Punkt object)
	public int getX () {
		return x;
	}
	// getY method returns coordinate y of the point (Punkt object)
	public int getY () {
		return y;
	}
	
	// constructor creates a copy of a Punkt
	Punkt (Punkt p)
	{
		this.name = p.name;
		this.x = p.x;
		this.y = p.y;
		
	}
	
	
}
