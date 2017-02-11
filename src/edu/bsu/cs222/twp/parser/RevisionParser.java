package edu.bsu.cs222.twp.parser;

import edu.bsu.cs222.twp.revisions.Revisions;
import edu.bsu.cs222.twp.url.URLConnector;
import edu.bsu.cs222.twp.xml.XMLBuilder;
import org.junit.Assert;
import org.omg.PortableInterceptor.INACTIVE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class RevisionParser {

    //public RevisionParser(String articleName) throws ParserConfigurationException, IOException, SAXException {
        /*
        String title = (String)URLEncoder.encode(articleName);
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles="
                + articleName + "&rvprop=timestamp|user&rvlimit=4&redirects");
        URLConnection urlConnection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa16; me@bsu.edu)");
        */
        //URLConnector urlConnector = new URLConnector();


        /*
        List<Revisions> revisionsList = new ArrayList<>();
        NodeList nl = document.getElementsByTagName("rev");
        for (int i = 0; i < nl.getLength(); i++) {
            revisionsList.add(new Revisions((Element)nl.item(i)));
        }
        isRedirected();
        */
    //}

    public List<Revisions> parse(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        XMLBuilder xml = new XMLBuilder();
        Document document = xml.buildXMLDoc(inputStream);
        List<Revisions> revisionsList = new ArrayList<>();
        NodeList nl = document.getElementsByTagName("rev");
        for (int i = 0; i < nl.getLength(); i++) {
            revisionsList.add(new Revisions((Element)nl.item(i)));
        }
        return revisionsList;
    }

    /*
    private void doesThePageExist() {
        boolean redirected = true;
        NodeList pages = document.getElementsByTagName("pages");
        Element page = (Element) pages.item(0);
        if (page.getAttribute("idx").equals(-1)) {
            redirected = false;
            System.out.println("The page does not exist.");
        }
    }
    */

}