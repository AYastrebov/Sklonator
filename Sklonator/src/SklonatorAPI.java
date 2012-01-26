import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class SklonatorAPI 
{


	public static Vector<String> getResults(String word)
	{
		Vector<String> words = new Vector<String>();
		
		String url;
		try 
		{
			url = "http://export.yandex.ru/inflect.xml?name=" + URLEncoder.encode(word, "UTF-8");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new URL(url).openStream());
			
			NodeList nList = doc.getElementsByTagName("inflections").item(0).getChildNodes();
			
			for(int index = 1; index < nList.getLength(); index++) 
			{
			    Node node = nList.item(index).getFirstChild();
			      
			    if (index == nList.getLength() - 1) 
			    {
			    	words.add(new String("о " + node.getNodeValue()));
				}
			    else
			    {
			    	words.add(node.getNodeValue());
			    }
			    
			}
		} 
		catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return words;
		
	}
	
	

}
