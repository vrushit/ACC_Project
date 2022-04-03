package concepts_used;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Caching {
	
	public static void lruCache() throws NumberFormatException, IOException
	{
		LRUCache<Integer> cache = new LRUCache<>(3);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice = 1;
		System.out.println("=======================Your Temporary Storage Space===================");
		System.out.println("Add Website Links to be used later or in your work ");
		while (choice != 0) {
			System.out.println("1: Add Links\n2: Get Previously Stored Links\n0: Exit");
			choice = Integer.parseInt(br.readLine());
			String key;
			String value;
			switch (choice) {
			case 1:
				System.out.println("Enter Key: ");
				key = br.readLine();
				System.out.println("Enter Value: ");
				value = br.readLine();
				cache.put(key, value);
				System.out.println("Inserted\n");
				break;

			case 2:
				System.out.println("Enter Key: ");
				key = br.readLine();
				String strValue = "None";
				if(cache.get(key)!= null)
				{
				strValue = cache.get(key).toString();
				}
				System.out.println("Value is: " + strValue);
				break;

			default:
				System.out.println("Exit");

			}
		}
		
		System.out.println("=======================Your Temporary Storage Space===================");


	}

//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		lruCache();
//	}

}
