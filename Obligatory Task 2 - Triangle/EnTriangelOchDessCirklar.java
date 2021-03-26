import java.lang.*;
public class EnTriangelOchDessCirklar {

	public static void main(String[] args) {
		
		double a = 9;
		double b = 9;
		double c = 9;
		double h = 6;
		double alfa = 60;
		double beta = 60;
		double gamma = 60;
		double bisectors[] = new double [3];
		bisectors = Triangel.AllBisectors(a,b,c,alfa,beta,gamma);
		for(int i = 0; i < bisectors.length; i++) 
		{
			System.out.println("Bisector" + (i+1) + " of the triangle: " + bisectors[i]);
		}
		System.out.println("Circumference of the triangle is: " + Triangel.circumference(a,b,c));
		System.out.println("Area of the triangle is: " + Triangel.area(a,h));
		System.out.println("radius of a circle inscribed in the triangle is: " + Triangel.incircleR(a,b,c));
		System.out.println("radius of a circle circumscribed about the triangle is: " + Triangel.excircleR(a,alfa));
	}

}
