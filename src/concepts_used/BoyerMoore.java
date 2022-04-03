package concepts_used;

import java.io.File;

//import textprocessing.BoyerMoore;
import textprocessing.In;

public class BoyerMoore {
	
    private final int R;    
    private int[] right;
    private String searchString = " ";
	
	 public BoyerMoore(String pat) {
	        this.R = 256;
	        this.searchString = searchString;

	        right = new int[R];
	        for (int c = 0; c < R; c++)
	            right[c] = -1;
	        for (int j = 0; j < searchString.length(); j++)
	            right[searchString.charAt(j)] = j;
	    }

	    public int search(String txt) {
	        int M = searchString.length();
	        int N = txt.length();
	        int skip;
	        for (int i = 0; i <= N - M; i += skip) {
	            skip = 0;
	            for (int j = M-1; j >= 0; j--) {
	                if (searchString.charAt(j) != txt.charAt(i+j)) {
	                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
	                    break;
	                }
	            }
	            if (skip == 0) return i;    
	        }
	        return N;                       
	    }
	
	public static void boyerMooreConcept(String searchString)
	{
		File folder = new File("src/text_files");
		String filesName[] = new String[100000];
        BoyerMoore boyerMoore = new BoyerMoore(searchString);
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
 	   				temp = file.getName() + " at position " + (var+i);
 	   				//System.out.println("Values Found in file " + file.getName());
 	   				//StdOut.println(str1+ " position = " +(var+i));
 	   			}
 	   		}
        	filesName[j] = temp;
        	j++;
        	
        	
        }
        
        System.out.println("Top Search results found in : ");
        for (int i =0;i<10;i++)
        {
        	System.out.println(filesName[i]);
        }
	}

}
