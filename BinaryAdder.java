package main.resources;

import java.util.Scanner;

//Gruppennummer: XXX

public class BinaryAdder {
	
	
	
	// Teste deine Methode mit zwei Binaerzahlen, die du in der Konsole eingibst
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Summand:  ");
		String input1 = scan.next("(0|1)*");
		System.out.print("Summand:  ");
		String input2 = scan.next("(0|1)*");
		scan.close();
		System.out.println("Ergebnis: " + add(input1, input2));
	}


	
	public static String add(String binary1, String binary2)
	{
		
		
		binary1 = cutLeadingZeros(binary1);
		binary2 = cutLeadingZeros(binary2);
		char [] c1 = binary1.length() > binary2.length() ? binary1.toCharArray() : binary2.toCharArray();
		char [] c2 = binary1.length() > binary2.length() ? binary2.toCharArray() : binary1.toCharArray(); //Wir moegen Arrays mehr
		
	
		String s3 = ""; 								
		 
		
		// Idee: Bit fuer Bit wird addiert. Dabei gilt immer: (b1 + b2) mod 2 = Ergebnis-Bit.
		// Eigentlich gilt: (Bit1 + Bit2 + Carry-Bit) mod 2 = Ergebnis-Bit.
		// Zu beachten sind zwei Punke:
		// Punkt 1:
		// 1 mod 2 == 3 mod 2. Der Unterschied liegt darin, dass im rechten Fall das Carry-Bit 1 ist. 
		// Punkt 2:
		// Die beiden Strings sind unterschiedlich lang (moeglicherweise)
		
		int carryBit = 0; 				 								    // CarryBit auf 0 setzen
		int i = 0;
		int j = 0;
		int iL = 1;
		int jL = 1; // L steht fuer laenger
		int jK = 1; // K steht fuer kuerzer
	
			while (j < c2.length) {
				jK = c2.length - 1 - j;
				jL = c1.length - 1 - j;
				s3 = ((c1[jL]-48) + (c2[jK]-48) + carryBit) % 2 + s3;
				carryBit = c1[jL] == '1' && c2[jK] == '1' || carryBit == 1 && (c1[jL] == '1' || c2[jK] == '1') ? 1 : 0;
				j++;
			}
			i = j;
			while (i < c1.length) {
				iL = c1.length - i - 1;
				s3 = ((c1[iL]-48) + carryBit) % 2 + s3;
				carryBit = carryBit == 1 && c1[iL] == '1' ? 1 : 0;
				i++;
			}
			
			
		return carryBit == 1 ? carryBit + s3 : s3 ;
		
		
	}
	
	public static String cutLeadingZeros(String toCut) 
	{
		int i = 0;
		while (i < toCut.length()) {
			if (toCut.charAt(i) == '1') {
				break;
			}
			i++;
		}
		
		return toCut.substring(i);
		
	}
	
	public static boolean stringEqual(String a, String b) 
	{
		return a.equals(b);
	}
	
	
}
