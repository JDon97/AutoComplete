import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/**
 * 
 * @author Jack Donoghue
 *
 */
public class BruteAutoComplete 
{
	/**
	 * Initialize ArrayLists
	 */
 List<String> list = new ArrayList<String>();
 List<String> line = new ArrayList<String>();
 
	/**
	 * Read in the data from the url
	 * @throws IOException
	 */
	public void page() throws IOException
	{
		URL words = new URL("https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt");

		BufferedReader read = new BufferedReader(new 
				InputStreamReader(words.openStream()));
		try
		{

			String inputLine;
		
			while ((inputLine = read.readLine()) !=null)
			{
				//Adds the input from the URL to the ArrayList 'list'
				list.add(inputLine);
			}
			
		}

		finally
		{
			if(read != null)
			{	
				read.close();
			}
			
		}
	}
	
	/**
	 * Read method takes input from the user and returns highest rated answers
	 */
	public void read(int k)
	{
		Scanner scanner = new Scanner(System.in);
		String input;
		 
		System.out.println("Welcome ");
		System.out.println("Search for:");
	//Search for user input
		  input = scanner.next();
		  System.out.println("Did you mean...");
		  // for loop to iterate over list
		  for (int i = 0; i < list.size(); i++) {
			  //this call wordWeight and passes the ArrayList 'list' through the method
       		      wordWeight(list.get(i));
		  }
		  //this for loop iterates over the new array 
       		   for (int x = 0; x < line.size(); x++)   
       		   {
       			   //whitespace is removed from the ArrayList and the new Strings are added to 'line'
       		          whiteSpace(line.get(x));
            		  if (line.get(x).startsWith(input))           			  
              { 
            				System.out.println(line.get(x));	
            				
		      }
	           }
	
        scanner.close();
       }
	

	
	/**
	 * weightOf is used to split the long from the String
	 *returns a long
	 * @param term
	 * @return
	 */
	public double weightOf(String term) 
	{
		//split begins and ends with a-z
		String[] wordSplit= term.split ("[a-z]");
		double stringWeight=Double.parseDouble(wordSplit[0]);
 		return stringWeight;
	}
	/**
	 * wordWeight splits the line and adds only the String to an ArrayList 'line'
	 * @param string
	 * @return
	 */
	public List<String> wordWeight(String string) 
	{
		    String[] result = string.split("[0-9]");
		    for (int x=0; x<result.length; x++)
		    {
		    	line.add(result[x]);
		    }
			return line;
	}
	/**
	 * whiteSpace removes the white space between the String and the long,
	 * this is necessary so that I can use .starstWith to sort the list 
	 * properly and return the top matches
	 * @param term
	 * @return
	 */
	public List<String> whiteSpace(String term)
	{
		 String[] result = term.split("\\s");
		    for (int x=1; x<result.length; x++)
		    {
		    line.add(result[x]);
		    }
			return line;
	}
}




