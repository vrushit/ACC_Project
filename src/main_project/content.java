package main_project;

import java.util.Scanner;

public class content {

	public static void main(String[] args) {
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("=====================Welcome to Our Web Search Engine========================");
		System.out.println();
		System.out.println("Please Enter your Website URl which you want to work with: ");
		System.out.println();
		System.out.println();
		System.out.println("1. Search for a Word: ");
		System.out.println("2. Most Frequently used Words: ");
		System.out.println("3. Store some Webpages for later use");
		System.out.println("4. Open up Web Page in browser");
		System.out.println("5. Exit");
		System.out.println();
		System.out.println("We hope you found what you were Searching for!!! Come Back soon");
		System.out.println("=============================================================================");
		System.out.println();
	
		
		System.out.println("Hello");
		Scanner input=new Scanner(System.in);
		int selection = input.nextInt();

		while (selection<4)
		{
		   switch(selection){
		        case 1:
		           System.out.println("Please enter amount");
		           break;

		        case 2:
		           System.out.println("Enter ID number"); 
		           break;

		        case 3:
		           System.out.println("Enter amount to be credited");
		           break;
		      }
		      System.out.println("1. Transfer\n2.Check balance\n3.Recharge");
		      selection = input.nextInt();
		 }
	}

}
