import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections;
/**
 * 
 * @author Jack Donoghue
 *
 */
/**
 * Incomplete class
 * @author jack
 *
 */
public class QuickAutoComplete implements Comparable
{
	 List<String> word = new ArrayList<String>();
	 static List<String> newWord = new ArrayList<String>();
	 
 
	/**
	 * Reads in the contents of the url and adds them to a List
	 * @throws IOException
	 */
	public void url() throws IOException
	{
		URL words = new URL("https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt");

		BufferedReader in = new BufferedReader(new 
				InputStreamReader(words.openStream()));
		try
		{

			String inputLine;
		
			while ((inputLine = in.readLine()) !=null)
			{
				word.add(inputLine);
			}
			
		}

		finally
		{
			if(in != null)
			{	
				in.close();
			}
			
		}
	}
	/**
	 * Takes in user input and returns a list of matching returns
	 */
	public void output()
	{
		Scanner scanner = new Scanner(System.in);
		String input;
		 
		System.out.println("Welcome ");
		System.out.println("Search for:");
	
		  input = scanner.next();
		  System.out.println("Did you mean...");
		  for (int i = 0; i < word.size(); i++) {
				//weightOf(list.get(i));
       		      wordWeight(word.get(i));
		  }
       		   for (int x = 0; x < newWord.size(); x++){
       			   whiteSpace(newWord.get(x));
            		  if (newWord.get(x).startsWith(input))
              { 
            			  System.out.println(newWord.get(x));
		      }
            		
		  }
		System.out.println("End");
        scanner.close();
       }
	/**
	 * Could not solve how to use comparable/Insertion sort
	 * @param a
	 */
			
	public static void sort(Comparable[] a)
	{
		int N = newWord.size();
		for(int i=0; i<N; i++)
			for(int j = i; j<0; j--)
				if(less(a[j], a[j-1]))
					exch(a, j, j-1);
				else break;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) <0;
	}
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	/**
	 * WeightOf splits the line and returns a weight
	 * @param term
	 * @return
	 */
	public double weightOf(String term) {
		
		String[] wordSplit= term.split ("[a-z]");
		double stringWeight=Double.parseDouble(wordSplit[0]);
 		return stringWeight;

	}
/**
 * wordWeight splits the line and returns a String with whitespace
 * @param string
 * @return
 */
	public List<String> wordWeight(String string) 
	{
		  
		    String[] result = string.split("[0-9]");
		    for (int x=0; x<result.length; x++)
		    {
		    	newWord.add(result[x]);
		    }
			return newWord;

	}
	/**
	 * whiteSpace splits the string and the white space and return only the string
	 * @param term
	 * @return
	 */
	public List<String> whiteSpace(String term)
	{
		 String[] result = term.split("\\s");
		    for (int x=0; x<result.length; x++)
		    {
		    newWord.add(result[x]);
		    
		    }
			return newWord;

	}

	@Override
	public int compareTo(Object o) {
		
		return 0;
	}

}