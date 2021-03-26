
import java.lang.Math.*;
import java.util.*;
public class Triangel {
	
	// circumference calculates the circumference of a triangle. Three parameters 
	// - three sides of a triangle needed. 
	public static double circumference(double side1, double side2, double side3) 
	{
		return (side1+side2+side3);
	}
	
	// height calculates the height of a triangle.
	public static double height(double side, double area) 
	{
		return 2*area/side;
	}
	
	// area Calculates the area of a triangle. Side and height lengths of the triangle are the methods arguments.
	public static double area(double side, double height)
	{
		return (side*height/2);
	}
	
	// bisektris tar emot tva sidor i en triangel och vinkeln (i radianer) mellan dessa sidor.
	// Metoden returnerar langden av den motsvarande bisektrisen - den som delar den givna vinkeln
	// i tva lika delar.
	public static double angleBisector(double b, double c, double alfa) {
		// do zrobienia
		double p = 2 * b * c * Math.cos (alfa / 2);
		double bis = p / (b + c);
		return bis;
	}
	
	//This method returns an array of all three bisectors in an order: alfa bisector, beta bisector and gamma bisector.
	// Alfa is an angle between b and c sides, beta is an angle between a and b sides and gamma is an angle between a and c sides.
	public static double[] AllBisectors(double a, double b, double c, double alfa, double beta, double gamma) {
		double p = 2 * b * c * Math.cos (Math.toRadians(alfa) / 2);
		double bis1 = p / (b + c);
		p = 2 * a * b * Math.cos (Math.toRadians(beta) / 2);
		double bis2 = p / (a + b);
		p = 2 * a * c * Math.cos (Math.toRadians(gamma) / 2);
		double bis3 = p / (a + c);
		double bis[] = new double[] {bis1,bis2,bis3};		
		return bis;
	}
	
	// This method calculates the radius of a circle inscribed in a triangle. Method's parameters are the three sides of a triangle.
	public static double incircleR(double side1, double side2, double side3) 
	{
		double p = (side1+side2+side3)/2;
		double r = Math.sqrt(((p-side1)*(p-side2)*(p-side3))/p); 
		return r;
	}
	
	// This method calculates the radius of a circle circumscribed about a triangle. The "alfa" parameter should be an angle opposite
	//to the given side. 
	public static double excircleR(double sida, double alfa) 
	{
		double r = sida/(2*Math.sin(Math.toRadians(alfa))); 
		System.out.println(Math.sin(Math.toRadians(alfa)));
		return r;
	}
}
