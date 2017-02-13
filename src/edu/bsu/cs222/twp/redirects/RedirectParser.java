package edu.bsu.cs222.twp.redirects;


import edu.bsu.cs222.twp.xml.XMLBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class RedirectParser {
    public boolean checkForRedirects(InputStream inputStream) throws IOException, SAXException, ParserConfigurationException {
        XMLBuilder xml = new XMLBuilder();
        Document document = xml.buildXMLDoc(inputStream);
        NodeList nl = document.getElementsByTagName("r");
        if(nl.item(0) == null)
        {
            return false;
        }
        else
            return true;
    }
}
