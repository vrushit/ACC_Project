package concepts_used;

import java.io.File;

import textprocessing.In;

public class BoyerMooreSearch {	
	
	public static void boyerMooreConcept(String searchString)
	{
		
		System.out.println("====================Searching your Word================================");
		System.out.println();
		File folder = new File("src/text_files");
//		String filesName[] = new String[100000];
        Boyer_Moore_Class boyerMoore = new Boyer_Moore_Class(searchString);
        boolean found = false;
 		int j =0;
        for (File file : folder.listFiles())
        {
        	In readFile = new In(file);
        	String readStr = readFile.readAll();
        	char[] c =readStr.toCharArray();
        	String temp = " ";
        	int var =0;
        	
        	for(int i=0; i<=c.length; i+=var+searchString.length())
 	   		{
 	   			var = boyerMoore.search(readStr.substring(i));
 	   			if((var+i)<readStr.length())
 	   			{
 	   				found = true;
 	   				temp ="Found in " +  file.getName() + " at position " + (var+i);
 	   				System.out.println(temp);
 	   				System.out.println();
 	   				break;
 	   			}	
        }
	}
        if(found == false)
        {
        	System.out.println("No such word found on Website");
        }
        System.out.println();
		System.out.println("====================Searching Complete================================");

}
}
