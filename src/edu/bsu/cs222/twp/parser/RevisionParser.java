package edu.bsu.cs222.twp.parser;

import edu.bsu.cs222.twp.revisions.Revisions;
import edu.bsu.cs222.twp.xml.XMLBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RevisionParser {
    private boolean isRedirected = true;

    public List<Revisions> parse(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        XMLBuilder xml = new XMLBuilder();
        Document document = xml.buildXMLDoc(inputStream);
        List<Revisions> revisionsList = new ArrayList<>();
        NodeList nl = document.getElementsByTagName("rev");
        System.out.println(document.getElementsByTagName("r").item(0));
        if(document.getElementsByTagName("r").item(0) == null)
        {
            isRedirected = false;
        }
        for (int i = 0; i < nl.getLength(); i++) {
            revisionsList.add(new Revisions((Element)nl.item(i)));
        }
        return revisionsList;
    }
    public boolean seeIfRedirected()
    {
        return isRedirected;
    }
}