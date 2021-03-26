import java.lang.Character.*;
public class Polylinje {

	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	public Polylinje ()
	{
	this.horn = new Punkt[0];
	}
	
	// constructor creates a new Polylinje object with given points in a list horn
	public Polylinje (Punkt[] horn)
	{
	this.horn = new Punkt[horn.length];
	for (int i = 0; i < horn.length; i++)
	this.horn[i] = new Punkt (horn[i]);
	}
	
	// toString  method lets us print out the point object in this form, ex. "{[(A 3 4)(B 1 2)(C 2 3)(D 5 1)], svart, 1}"
	public String toString ()
	{
		String s = new String("{[");
		for (int i = 0; i < horn.length; i++) 
		{
			s += ("(" + horn[i] + ")");
		}
		s += ("], " + farg + ", " + bredd + "}");
		return s;
	}
	
	// getHorn method returns a list including points of a Polylinje - horn
	public Punkt[] getHorn () 
	{
		return horn;
	}
	
	// getFarg returns color of a polyline
	public String getFarg () 
	{
		return farg;
	}
	
	// getBredd returns width of a polyline
	public int getBredd ()
	{
		return bredd;
	}
	
	// setFarg defines the color of a polyline
	public void setFarg (String farg) 
	{
		this.farg = farg;
	}
	
	// setBredd defines width of a polyline
	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}
	
	// langd returns length of a polyline
	public double langd ()
	{
		double l = 0;
		for (int i = 0; i < horn.length-1; i++)
		{
			l += horn[i].avstand(horn[i+1]);
		}
		return l;
	}
	
	// laggTill sets a new (additional) point at the last index of the object Polylinje. 
	public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt (horn);
		this.horn = h;
	}
	
	// laggTillFramfor method adds a new point before a particular point.
	public void laggTillFramfor (Punkt horn, String hornNamn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		

		for (int i = 0; i < this.horn.length; i++) 
		{
			if (this.horn[i].name == hornNamn) {
				h[i] = new Punkt (horn);
				h[i].name = this.horn[i].name;
				for (int j = i; j < this.horn.length; j++) 
				{
					h[j+1] = this.horn[j];
					h[j+1].name = "" + (char)(this.horn[j].name.charAt(0)+1);
				}
				for (int k = 0; k < i; k++)
				{
					h[k] = this.horn[k];
				}
			} 
		}
		this.horn = h;
	}
	
	// taBort deletes the particular point in the object Polylinje.
	public void taBort (String hornNamn)
	{
		int pos = 0;
		Punkt[] h = new Punkt[this.horn.length - 1];
		for (int i = 0; i < this.horn.length; i++) 
		{
			if (!this.horn[i].name.equals(hornNamn))
				h[pos++] = this.horn[i];
		}
		this.horn = h;
	}
	
	// An inner class PolylinjeIterator used for accessing particular points in the object Polylinje
	public class PolylinjeIterator
	{
		private int aktuell = -1;
		public PolylinjeIterator ()
		{
			if (Polylinje.this.horn.length > 0)
				aktuell = 0;
		}
		public boolean finnsHorn ()
		{
			return aktuell != -1;
		}
		public Punkt horn () throws java.util.NoSuchElementException
		{
			if (!this.finnsHorn ())
				throw new java.util.NoSuchElementException ("slut av iterationen");
			Punkt horn = Polylinje.this.horn[aktuell];
			return horn;
		}
		public void gaFram ()
		{
			if (aktuell >= 0 &&
					aktuell < Polylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
	}
}

