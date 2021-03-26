import java.util.*;

public class TempMatningOU1 {

	public static void main(String[] args) {
		
		System.out.println ("TEMPERATURER\n");
		
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		
		// mata in uppgifter om antalet veckor och antalet matningar
		System.out.print("antalet veckor: ");
		int antalVeckor = in.nextInt();
		System.out.print("antalet mätningar per vecka");
		int antalMatningarPerVecka = in.nextInt();
		
		//plats att lagra temperaturer
		double [][] t = new double [antalVeckor + 1][antalMatningarPerVecka+1];
		
		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++) {
			System.out.println("temperaturer - vecka " + vecka + ":");
			for(int matning = 1; matning <= antalMatningarPerVecka; matning++) {
				t[vecka][matning] = in.nextDouble();
			}	
		}
		System.out.println();
		
		// den minsta, den storsta och medeltemperaturen - veckovis
		double[] minT = new double[antalVeckor+1];
		double[] maxT = new double[antalVeckor+1];
		double[] sumT = new double[antalVeckor+1];
		double[] medelT = new double[antalVeckor+1];
		
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double medelTemp = 0;
		
		for (int vecka = 1; vecka <= antalVeckor; vecka++) {
			minT[vecka] = t[vecka][1]; 
			for(int matning = 1; matning <= antalMatningarPerVecka; matning++)
			{
				if(minT[vecka] > t[vecka][matning]) {
					minT[vecka] = t[vecka][matning];
				}
				if(maxT[vecka] < t[vecka][matning]) {
					maxT[vecka] = t[vecka][matning];
				}
				sumT[vecka] += t[vecka][matning];	
			}
			medelT[vecka] = (sumT[vecka])/(antalMatningarPerVecka);
		}
		
		minTemp = minT[1]; // executed only once
			
		for (int vecka = 1; vecka <= antalVeckor;vecka++) {
			if(minTemp > minT[vecka]) {
				minTemp = minT[vecka];
			}
			if(maxTemp < maxT[vecka]) {
				maxTemp = maxT[vecka];
			}
			sumTemp += sumT[vecka];
		}
		medelTemp = sumTemp/(antalVeckor * antalMatningarPerVecka);
		
			
		for (int vecka = 1; vecka <= antalVeckor; vecka++) {
			System.out.println("Minimal temperature in week " + vecka + ": " + minT[vecka]);
			System.out.println("Maximal temperature in week " + vecka + ": " + maxT[vecka]);
			System.out.println("Sum of temperatures in week " + vecka + ": " + sumT[vecka]);
			System.out.println("Average temperature in week " + vecka + ": " + medelT[vecka]);
			System.out.println("");
		}
		System.out.println("Minimal temperature of a whole period: " + minTemp);
		System.out.println("Maximal temperature of a whole period: " + maxTemp);
		System.out.println("Sum of temperatures in week: " + sumTemp);
		System.out.println("Average temperature of a whole period: " + medelTemp);
		}
	}


