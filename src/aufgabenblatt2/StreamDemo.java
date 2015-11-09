package aufgabenblatt2;

/**
 * @author Cyrille Ngassam Nkwenga
 * Theophile Teyou Soh
 * 
 * HAW HAMBURG
 * WS 2015
 * Programming Methodic 2
 * Prof : Herr Phillip Jenke
 * TI B2
 * 
 * Description : StreamDemo show us how we can create a Stream, apply some pipelined 
 * operations to it, and save the result in a manner we like so we could continue our work 
 * on the result of these operations.
 * 
 * 
 */

//import java.util.Scanner;
import java.util.stream.*;

import java.util.List;
public class StreamDemo {
	
	public static void main(String []args){
//		String[] words = new String[20];
//		Scanner input = new Scanner(System.in);
//		String word  = "";
		
//		System.out.println("Bitte geben Sie jeweils bis zu 20 Wörter ein.\nLeere Wörter sind auch erlaubt");
//		System.out.println("Geben Sie das Wort STOP ein um mit der Eingabe aufzuhören");
//		int i =0;
//		while(word != "STOP" || i < words.length){
//			word = input.nextLine();
//			words[i] = (word == " " || word == "")? null : word;
//		}
//		input.close();
		String [] words = {"Eingabe	",	" Äußeres		",	null,	" Strassen-Feger",	"	 ein Haus"	};
		Stream<String> wordStream = Stream.of(words); // A Stream instance is created here
		List<String> wordsList =  wordStream
				.filter(str-> str != null ) // remove all null reference that are in the stream
				.map(str ->str.trim()) // remove all starting and ending space charactere
				.map(str -> str.toUpperCase()) // Transform every charactere to upper case
				.map(str -> str.replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE").replace("ß", "SS")) // replace every special german character.
				.map(str -> str.length() > 8 ? str.substring(0, 8): str) // redimension every string so that the max string length now is 8.
				.collect(Collectors.toList()); // convert the results of all these changes to a list.
		
		System.out.print(wordsList);
		
	}
	

}
