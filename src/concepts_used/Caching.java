package concepts_used;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Caching {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		LRUCache<Integer> cache = new LRUCache<>(3);
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int choice = 1;
		
		while(choice != 0)
		{
			System.out.println("1: Put\n2: Get\n0: Exit");
			choice = Integer.parseInt(br.readLine());
			String key;
			int value;
			switch(choice)
			{
			case 1:
				System.out.println("Enter Key: ");
				key = br.readLine();
				System.out.println("Enter Value: ");
				value = Integer.parseInt(br.readLine());
				cache.put(key, value);
				System.out.println("Inserted\n");
				break;
				
			case 2:
				System.out.println("Enter Key: ");
				key = br.readLine();
				System.out.println("Value is: " + cache.get(key).toString());
				break;
			
			default:
				System.out.println("Exit");
				
			}
		}
		
	}

}
