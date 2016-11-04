import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * @author Jack Donoghue
 *
 */
public class BruteTest {
/**
 * URL test 
 * @throws Exception
 */
	@Test
	public void testURL() throws Exception {
	    String url = "https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt";

	    try {
	        URL words = new URL(url);
	        HttpURLConnection urlTest = (HttpURLConnection) words.openConnection();
	        urlTest.connect();
	        
	        assertEquals(HttpURLConnection.HTTP_OK, urlTest.getResponseCode());
	    } catch (IOException e) {
	        System.out.println("Failed to connect");
	        e.printStackTrace();
	        throw e;
	    }
	}
/**
 * Trying to test the first List for values
 */
	  @Test
	  public void streamTest()
	  {
			     {
			        BruteAutoComplete stream= new BruteAutoComplete();

			        assertEquals("    5627187200	the", stream.list.get(1));
			        assertEquals("10000",  stream.list.get(0));
			    }
			     
	    
	  }
	  /**
	   * Testing an array for values
	   */
	  @Test
	    public void testWords() {
		  List<String> expectedAnswers = new ArrayList<String>();
	        
	        expectedAnswers.add("the");
	        expectedAnswers.add("they");
	        expectedAnswers.add("their");
	        expectedAnswers.add("them");
	        expectedAnswers.add("there");
	        assertEquals(true, expectedAnswers.contains("the"));
		    assertEquals(true, expectedAnswers.contains("they"));
		    assertEquals(true, expectedAnswers.contains("their"));
		    assertEquals(false, expectedAnswers.contains("for"));
		    assertEquals(false, expectedAnswers.contains("and"));
	  
	}
	  /**
	   * Testing scanner for input
	   */
	  @Test
	  public void scannerTest()
	  {		  
	  String data = "the";
	  System.setIn(new ByteArrayInputStream(data.getBytes()));

	  Scanner scanner = new Scanner(System.in);
	  System.out.println(scanner.nextLine());
	  scanner.close();
	  }
}
