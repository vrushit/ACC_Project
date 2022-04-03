import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

public class PatternEvaluation {
	
	public static void main(String args[]) {
		
		File direc = new File("");
	    File[] allines = direc.listFiles();
	    
	    //Taking input of pattern from the user
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the word to be searched: ");
	    String wordspattern=sc.nextLine();
	    
	    int words=0;
	    
	    for(int i=0;i<allines.length;i++) 
		 {
	    	  if(allines[i].isFile()) {
	    		  
	    		  File myfile= new File(""+allines[i].getName());
	    		  
	    		  org.jsoup.nodes.Document doc = Jsoup.parse(myfile,"UTF-8");
	    		  String text = doc.text();
	    		 
	    		  //Compiling all patterns
	    		  Pattern wpattern = Pattern.compile(wordsPattern);
	    	      	    	      
	    	      //For words
	    	      Matcher m1= wpattern.matcher(text);
	    	      
	    	      while (m1.find()) {

	    	          words = words+1;
	    	      } 
	    	  }  
		 }
	    
	    System.out.println("Number of words pattern found = "+words);
	}
}