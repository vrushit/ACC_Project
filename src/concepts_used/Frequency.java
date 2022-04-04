package concepts_used;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Frequency
{
	
	  public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap)
	     {
	          Set<Entry<String, Integer>> entries = wordMap.entrySet();
	          List<Entry<String, Integer>> list = new ArrayList<>(entries);
	          Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
	          {
	               @Override
	               public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
	               {
	                    return (o2.getValue()).compareTo(o1.getValue());
	               }
	          });
	          return list;
	     }
    
   public static void merge(int arr[], int l, int m, int r)
     {
         int n1 = m - l + 1;
         int n2 = r - m;
   
         int L[] = new int[n1];
         int R[] = new int[n2];
   
         for (int i = 0; i < n1; ++i)
             L[i] = arr[l + i];
         for (int j = 0; j < n2; ++j)
             R[j] = arr[m + 1 + j];
   

         int i = 0, j = 0;
   
         int k = l;
         while (i < n1 && j < n2) {
             if (L[i] <= R[j]) {
                 arr[k] = L[i];
                 i++;
             }
             else {
                 arr[k] = R[j];
                 j++;
             }
             k++;
         }
   
         while (i < n1) {
             arr[k] = L[i];
             i++;
             k++;
         }
   
         while (j < n2) {
             arr[k] = R[j];
             j++;
             k++;
         }
     }
   
    public static void sort(int arr[], int l, int r)
     {
         if (l < r) {
             int m =l+ (r-l)/2;
   
             sort(arr, l, m);
             sort(arr, m + 1, r);
   
             merge(arr, l, m, r);
         }
     } 
     public static Map<String, Integer> buildWordMap(String fileName)
     {
          Map<String, Integer> wordMap = new HashMap<>();
          try
          (FileInputStream fis = new FileInputStream(fileName);
          DataInputStream dis = new DataInputStream(fis);
          BufferedReader br = new BufferedReader(new InputStreamReader(dis)))
          {
               Pattern pattern = Pattern.compile("\\s+");
               String line = null; 
               while ((line = br.readLine()) != null)
               {
                    line = line.toLowerCase();
                    String[] words = pattern.split(line);
                    for (String word : words)
                    {
                         if (wordMap.containsKey(word))
                         {
                              wordMap.put(word, (wordMap.get(word) + 1));
                         }
                         else
                         {
                              wordMap.put(word, 1);
                         }
                    }
               }
          }
          catch (IOException ioex)
          {
               ioex.printStackTrace();
          }
          return wordMap;
      }
   
     
     public static void frequencyAnalysis()
     {
    	 File folder = new File("src/text_files");

    	 final String regex = "\\b\\w{4,10}\\b";
         final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
         HashMap<Integer, String> mainMap = new HashMap<Integer, String>();

         for (File file : folder.listFiles())
         {
             Map<String, Integer> wordMap = buildWordMap(file + "");
             List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
             HashMap<Integer, String> terms = new HashMap<Integer, String>();
             
             for (Map.Entry<String, Integer> entry : list)
             {
                 Matcher matcher = pattern.matcher(entry.getKey());
           	  while( matcher.find() ) {
           		  terms.put(entry.getValue(), entry.getKey());
                 }
             }
             int length = terms.size();
             
             if(terms.values().toArray().length > 1)
             {
                 String str = (String) terms.values().toArray()[terms.size()-1];
                 int key = (int) terms.keySet().toArray()[length-1];
                 mainMap.put(key, str);
                 
             }
            
         }
                  
         Set<Integer> keys = mainMap.keySet();
         Iterator<Integer> itr = keys.iterator();         
         int[] array = new int[keys.size()];
         for(int i =0;i<keys.size();i++)
         {
        	 array[i] = itr.next();
         }
         sort(array, 0, array.length - 1);
         
         
         System.out.println();
         System.out.println("==============================================================");
         System.out.println();
         System.out.println(" Most Frequently used words: ");
         System.out.println();
         System.out.println(" " + mainMap.get(array[array.length-1]));
         System.out.println();
         System.out.println(" " + mainMap.get(array[array.length-2]));
         System.out.println();
         System.out.println(" " + mainMap.get(array[array.length-3]));
         System.out.println();
         System.out.println(" " + mainMap.get(array[array.length-4]));
         System.out.println();
         System.out.println(" " + mainMap.get(array[array.length-5]));
         System.out.println();
         System.out.println("================================================================");
         System.out.println();
   
     }

}