package main_project;

import java.util.Scanner;

import concepts_used.WebCrawler;

public class Main {

	public static void main(String[] args) {
		
		WebCrawler webCrawlerObj = new WebCrawler();
		
		Scanner input = new Scanner(System.in);
		
		String urlToWork;
		System.out.println("Please Enter the URL which you want to work on: ");
		urlToWork = input.nextLine();
		
		webCrawlerObj.crawlLinks(urlToWork, 0);
		
	}

}
