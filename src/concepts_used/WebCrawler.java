package concepts_used;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {

	private HashSet<String> URLs = new HashSet<String>();
	private int MaxDepth = 2;
	Random rVar = new Random();
	int low = 1;
	int high = 1000;
	int result = rVar.nextInt(high-low) + low;
	HashMap<Integer, String> urlLinks = new HashMap<Integer, String>();
	public void hashMap(String link)
	{
		urlLinks.put(result, link);
	}
	
	public HashMap<Integer, String> mapUrl()
	{
		return urlLinks;
	}
	
	public void crawlLinks(String link, int depth ) {

		if (!URLs.contains(link) && depth < MaxDepth) {
			try {
				if (URLs.add(link)) {
//					System.out.println(link);
					
				}
				Document document = Jsoup.connect(link).get();
				// getting html data of the links and storing them locally
				String htmlData = document.html();
				String outputPath = "src/saved_html_files/";
				File outputHTML = new File(outputPath);
				String title = document.title().replaceAll("[^a-zA-Z0-9]", "");
				if (!outputHTML.exists() && !outputHTML.isDirectory())
					outputHTML.mkdir();
				PrintWriter outfile = new PrintWriter(outputPath + title + ".html");
				outfile.println(htmlData);
				outfile.close();
				Elements linksOnWebPage = document.select("a[href]");
				depth++;
				for (Element eachEle : linksOnWebPage) {
					crawlLinks(eachEle.attr("abs:href"), depth);
				
					hashMap(eachEle.attr("abs:href"));
					
				}
			} catch (Exception e) {
//				System.err.println("Error: Message"+e.getMessage()+" For URL="+link);
			}
		}

	}

}
