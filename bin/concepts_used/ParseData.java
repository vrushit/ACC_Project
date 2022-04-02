package finalProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import textprocessing.BruteForceMatch;
import textprocessing.In;

public class ParseData {
	public void convertHTMLtoTxt(File file) throws IOException
	{
		Document docu = Jsoup.parse(file,"UTF-8");
		String textInHtm = docu.text();
		FileWriter fileObj=new FileWriter("src/res/text/"+file.getName());
		fileObj.write(textInHtm);
		fileObj.close();
	}
	public void fetchFiles() throws IOException
	{
		File htmlFolder=new File("src/res/html");
		File[] fileList = htmlFolder.listFiles();
		
		for(File file: fileList)
		{
			if(file.isFile())
			{
				convertHTMLtoTxt(file);
			}
		}
	}
	/* just for testing 
	public void searchWord(String word)
	{
		File textFolder=new File("src/res/text");
		File[] fileList = textFolder.listFiles();
		BruteForceMatch bfm = new BruteForceMatch();
		for(File file:fileList)
		{
			In inpFile=new In(file.getAbsolutePath());
			String data = inpFile.readAll();
			System.out.println("Fount at:"+bfm.search1(word,data)+" in the File "+file.getName());
		}
	}
	*/
}
