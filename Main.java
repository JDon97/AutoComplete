import java.io.IOException;
/**
 * 
 * @author Jack Donoghue
 *
 */

public class Main {
public static void main(String[] args) throws IOException

{
	try{
		QuickAutoComplete run = new QuickAutoComplete();
    BruteAutoComplete go = new BruteAutoComplete();
    go.page();
    go.read(1);
  //  run.url();
  //  run.output();
    
    
	}catch(Exception e){
		System.out.println("Not Working ");
	}
}

}
