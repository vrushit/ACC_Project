import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class frequencyAnalysis
{
     public static void main(String args[])
     {
    	 final String regex = "\\b\\w{4,10}\\b";
         final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
          Map<String, Integer> wordMap = buildWordMap("src/text.txt");
          List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
          HashMap<Integer, String> mainMap = new HashMap<Integer, String>();
          HashMap<Integer, String> terms = new HashMap<Integer, String>();
          System.out.println("List of repeated word from file and their count");
          
          for (Map.Entry<String, Integer> entry : list)
          {
              Matcher matcher = pattern.matcher(entry.getKey());
        	  while( matcher.find() ) {
        		  terms.put(entry.getValue(), entry.getKey());
              }
        	  
          }
          int length = terms.size();
          
          System.out.println(terms.values().toArray()[length-1] + " " + terms.keySet().toArray()[length-1]);
          
          
       
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
               String line = null; while ((line = br.readLine()) != null)
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
}