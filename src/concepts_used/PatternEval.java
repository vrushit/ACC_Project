package concepts_used;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class PatternEval {

	public static void main(String[] args) throws IOException {
		System.out.println("================ Word Patterns==============================");
		System.out.println();
		
		File direc = new File("src/saved_html_files");
		
	    File[] allines = direc.listFiles();
	    
	    //Taking input of pattern from the user
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the word to be searched: ");
	    String wordspattern=sc.nextLine();
	    
	    int words=0;
	    
	    for(int i=0;i<allines.length;i++) 
		 {
	    	  if(allines[i].isFile()) {
	    		  
	    		  File myfile= new File("src/saved_html_files/" + allines[i].getName());
	    		  
	    		  org.jsoup.nodes.Document doc = Jsoup.parse(myfile,"UTF-8");
	    		  String text = doc.text();
	    		 
	    		  Pattern wpattern = Pattern.compile(wordspattern);
	    	      	    	      
	    	      Matcher m1= wpattern.matcher(text);
	    	      
	    	      while (m1.find()) {

	    	          words = words+1;
	    	      } 
	    	  }  
		 }
	    
	    System.out.println("Number of words pattern found = "+words);
	    System.out.println();
	    System.out.println("============================================================");
	}

}
