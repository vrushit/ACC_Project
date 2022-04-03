package main_project;

import java.io.IOException;
import java.util.Scanner;

import concepts_used.BoyerMoore;
import concepts_used.ParseData;
import concepts_used.WebCrawler;

public class Main {

	public static void main(String[] args) throws IOException {

		WebCrawler webCrawlerObj = new WebCrawler();
		ParseData parseDatatoText = new ParseData();
		BoyerMoore bmObj = new BoyerMoore("");

		Scanner input = new Scanner(System.in);

//		String urlToWork;
//		System.out.println("Please Enter the URL which you want to work on: ");
//		urlToWork = input.nextLine();
//
//		webCrawlerObj.crawlLinks(urlToWork, 0);
//		parseDatatoText.fetchFiles();
		
		String str;
		System.out.println("Enter the String: ");
		str = input.nextLine();
		
		bmObj.boyerMooreConcept(str);
		

	}

}
