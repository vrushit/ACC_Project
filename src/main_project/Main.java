package main_project;

import java.io.IOException;
import java.util.Scanner;

import concepts_used.ParseData;
import concepts_used.WebCrawler;

public class Main {

	public static void main(String[] args) throws IOException {
		
		WebCrawler webCrawlerObj = new WebCrawler();
		ParseData parseDatatoText = new ParseData();
		
		Scanner input = new Scanner(System.in);
		
		String urlToWork;
		System.out.println("Please Enter the URL which you want to work on: ");
		urlToWork = input.nextLine();
		
		webCrawlerObj.crawlLinks(urlToWork, 0);
		System.out.println("Gone through the Website");
		parseDatatoText.fetchFiles();
		
	}
	

}
