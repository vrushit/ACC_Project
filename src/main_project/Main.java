package main_project;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import concepts_used.BoyerMooreSearch;
import concepts_used.Caching;
import concepts_used.Frequency;
import concepts_used.ParseData;
import concepts_used.WebCrawler;

public class Main {

	public static void main(String[] args) throws IOException {

		WebCrawler webCrawlerObj = new WebCrawler();
		ParseData parseDatatoText = new ParseData();
		HashMap<Integer, String> urlHMap = new HashMap<Integer, String>();
		BoyerMooreSearch bmObj = new BoyerMooreSearch();
		Caching cacheObj = new Caching();
		
		Scanner input = new Scanner(System.in);
		String urlToWork;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("=====================Welcome to Our Web Search Engine========================");
		System.out.println();
		System.out.println("Please Enter your Website URl which you want to work with: ");
//		urlToWork = input.nextLine();
//		System.out.println("Processing your request, Please wait for some time");
//		webCrawlerObj.crawlLinks(urlToWork, 0);
//		parseDatatoText.fetchFiles();
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
		System.out.println("5. Open up Web Page in browser");
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
		           cacheObj.lruCache();
		           break;
		        
		        case 4:
		        	System.out.println();
		        	break;
		        
		        case 5:
		        	System.out.println("Please select the index Number of one of the pages mentioned below ");
		        	HashMap<Integer, String> map = webCrawlerObj.mapUrl(); 
		        	System.out.println(Arrays.asList(map));
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
			System.out.println("4. Open up Web Page in browser");
			System.out.println();
			System.out.println("5. Exit");
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
