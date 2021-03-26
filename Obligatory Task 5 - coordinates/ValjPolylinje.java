import java.util.Random;

public class ValjPolylinje {
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	static String[] farger = new String[] {"gul","bla","rod"};

	public static void main (String[] args)
	{
		 Polylinje polylinje = new Polylinje();
		// skapa ett antal slumpmässiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++) 
			polylinjer[i] = slumpPolylinje ();
		// visa polylinjerna
		VisaPolylinjer(polylinjer);
		// bestäm den kortaste av de polylinjer som är gula
		// visa den valda polylinjen
		System.out.println("kortaste polylinjen" + kortastePolylinjenFarg(polylinjer,"gul"));
	}
	//slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
	// det engelska alfabetet, och slumpmässiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	// slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
	// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		// ett och samma namn kan inte förekomma flera gånger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn)
		{
			valdPunkt = slumpPunkt();
			valtChar = valdPunkt.name.charAt(0);
			if(!valdaNamn[(int)(valtChar) - 65]) 
			{ 
				polylinje.laggTill(valdPunkt);
				valdaNamn[(int)(valtChar) - 65] = true;
				antalValdaHorn++;
			}
		}
		// sätt färg
		polylinje.setFarg(farger[rand.nextInt(3)]);

		return polylinje;
	}

	public static void VisaPolylinjer(Polylinje[] polylinjer) 
	{
		for(int i = 0; i < polylinjer.length; i++)
			System.out.println(polylinjer[i]);
	}
	
	// kortastePolylinjenFarg method returns an Polylinje object that is shortest (among other with same colour)
	public static Polylinje kortastePolylinjenFarg(Polylinje[] polylinjer, String farg)
	{
		int pos = -1;
		// get first yellow position
		for (int j = 0; j < polylinjer.length; j++)
		{
			if(polylinjer[j].getFarg().equals(farg)) 
			{
				pos = j;
				break;
			}
		}
		
		if (pos == -1)
		{
			System.out.println("NO YELLOW POLYLINE");
			return null;
		}
		
		for (int i = pos+1; i < polylinjer.length; i++) 
		{
			System.out.println("dlugosc "+ i + " " + polylinjer[i].getFarg() + " polilinii " + polylinjer[i].langd());
			System.out.println(pos);
			if(polylinjer[i].getFarg().equals(farg)) 
			{
				
				if(polylinjer[pos].langd() > polylinjer[i].langd())
				{
					pos = i;
				}
			}
			
		}
		
		return polylinjer[pos];
	}

}