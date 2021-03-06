package main_project;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import concepts_used.BoyerMooreSearch;
import concepts_used.Caching;
import concepts_used.Frequency;
import concepts_used.OpenBrowser;
import concepts_used.ParseData;
import concepts_used.PatternEval;
import concepts_used.WebCrawler;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {

		WebCrawler webCrawlerObj = new WebCrawler();
		ParseData parseDatatoText = new ParseData();
		HashMap<Integer, String> urlHMap = new HashMap<Integer, String>();
		BoyerMooreSearch bmObj = new BoyerMooreSearch();
		Caching cacheObj = new Caching();
		PatternEval patternObj = new PatternEval();
		OpenBrowser openBrowser = new OpenBrowser();
		
		Scanner input = new Scanner(System.in);
		String urlToWork;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("=====================Welcome to Our Web Search Engine========================");
		System.out.println();
		System.out.println("Please Enter your Website URl which you want to work with: ");
		urlToWork = input.nextLine();
		System.out.println("Processing your request, Please wait for some time");
		webCrawlerObj.crawlLinks(urlToWork, 0);
		parseDatatoText.fetchFiles();
		System.out.println("Done you are all good to go....");
		System.out.println();
		System.out.println();
		System.out.println("1. Search for a Word: ");
		System.out.println();
		System.out.println("2. Most Frequently used Words: ");
		System.out.println();
		System.out.println("3. Store some Webpages for later use");
		System.out.println();
		System.out.println("4. Search for any Word Patterns");
		System.out.println();
		System.out.println("5. Open a URl in Web browser");
		System.out.println();
		System.out.println("6. Exit");
		System.out.println();
		
		System.out.println("Please Enter your choice: ");
		int selection = input.nextInt();

		while (selection!=6)
		{
			
		   switch(selection){
		        case 1:
		           System.out.println();	 
		           String wordSearch;
		   		   System.out.println("Enter the Word you want to search: ");
		   		   wordSearch = input.next();
		   		   System.out.println();
			   		bmObj.boyerMooreConcept(wordSearch);
		           break;

		        case 2:
		           System.out.println();	
		           System.out.println("Searching for Most frequency used words.....!!!");
		           Frequency.frequencyAnalysis();
		           break;

		        case 3:
		           System.out.println("Opening Your own storage space: ");
		           System.out.println();
		           cacheObj.lruCache();
		           break;
		        
		        case 4:
		        	System.out.println();
		        	 System.out.println("Enter the word to be searched for patterns: ");
		     	    String wordspattern=input.next();
		        	PatternEval.patternEvaluate(wordspattern);
		        	break;
		        
		        case 5:
		        	System.out.println();
		        	System.out.println("Enter the URL you want to open in Browser");
		        	String urlLink = input.next();
		        	System.out.println("Enjoy Web Browsing.......");
		        	openBrowser.openInBrowser(urlLink);
		        	break;
		        	
		        
		        default:
		        	System.out.println("Oops, Please Enter valid Input ");
		        
		      }
		   
		   System.out.println();
			System.out.println("1. Search for a Word: ");
			System.out.println();
			System.out.println("2. Most Frequently used Words: ");
			System.out.println();
			System.out.println("3. Store some Webpages for later use");
			System.out.println();
			System.out.println("4. Search for Word Patterns");
			System.out.println();
			System.out.println("5. Open a URL in Web Browser");
			System.out.println();
			System.out.println("6. Exit");
			System.out.println();		
			  System.out.println("New choice: ");
		      selection = input.nextInt();
		 }
		System.out.println();
		System.out.println("We hope you found what you were Searching for!!! Come Back soon");
		System.out.println("=============================================================================");
		System.out.println();	

	}

}
