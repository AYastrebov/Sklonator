import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class SklonatorAPI 
{
	public static Vector<String> getResults(String word)
	{
		try {
			String thisLine;
			
			URL u = new URL("http://export.yandex.ru/inflect.xml?name=" + URLEncoder.encode(word, "UTF-8"));
			
			BufferedReader theHTML = new BufferedReader(new InputStreamReader(u.openStream(), "UTF-8"));
			
			FileOutputStream fstream = new FileOutputStream("sklonator.xml");
			OutputStreamWriter out = new OutputStreamWriter(fstream, "UTF-8");
			
			while ((thisLine = theHTML.readLine()) != null)
			    out.write(thisLine);
			out.close();
			
			File file = new File("sklonator.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nl = doc.getElementsByTagName("inflections");
			Element n = (Element) nl.item(0);
			String st = n.getFirstChild().getNodeValue();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	

}
