
public class PolylinjeTest {

	public static void main(String[] args) {
		
		// new Polylinje is created
		Polylinje pol = new Polylinje();
		
		// setFarg method test
		pol.setFarg("gul");
		
		// setBredd method test
		pol.setBredd(10);
		
		//few points are defined
		Punkt p1 = new Punkt("A", 3, 5);
		Punkt p2 = new Punkt("B", 1, 2);
		Punkt p3 = new Punkt("C", 7, 8);
		Punkt p4 = new Punkt("D", 12, 8);
		Punkt p5 = new Punkt("E", 7, 32);
		Punkt p6 = new Punkt("F", 21, 8);
		Punkt p7 = new Punkt("G", 10, 1);
		
		
		// laggTill method test
		pol.laggTill(p1);
		pol.laggTill(p2);
		pol.laggTill(p3);
		pol.laggTill(p4);
		pol.laggTill(p5);
		pol.laggTill(p6);
		
		// printing out the values
		System.out.println(pol);
		System.out.println(pol.getBredd());
		System.out.println(pol.getFarg());
		
		// laggTillFramfor method test
		pol.laggTillFramfor(p7, "B");
		
		// getHorn test
		Punkt [] horn = pol.getHorn();
		
		// printing out Polylinje after changes
		System.out.println(pol);
		System.out.println(horn[6].name);
		
		// taBort test
		pol.taBort("D");
		System.out.println(pol);
		
		System.out.println("dlugosc " + pol.langd());
		// PolylinjeIterator test
		Polylinje.PolylinjeIterator iterator = pol.new PolylinjeIterator();
		System.out.println();
		System.out.println("Testing Iterator...");
		System.out.println();
		while(iterator.finnsHorn())
		{
			System.out.println(iterator.horn());
			iterator.gaFram();
		}
	}

}
