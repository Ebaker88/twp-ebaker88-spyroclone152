package edu.bsu.cs222.twp.parser;

import org.junit.Assert;
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

public class RevisionParser {
    private Document document;

    RevisionParser(String articleName) throws ParserConfigurationException, IOException, SAXException {
        articleName = replaceSpaceWithPluses(articleName);
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles="
                + articleName + "&rvprop=timestamp|user&rvlimit=4&redirects");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse((new InputSource(url.openStream())));
        isRedirected();
    }



   /* public String parseFirstRevision() throws IOException, SAXException, ParserConfigurationException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WikapediaTestSoup.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(inputStream);

        //Find the author of xmlObama
        NodeList revisions = document.getElementsByTagName("revisions");
        Element firstRevision = (Element)revisions.item(0);
        NodeList users = firstRevision.getElementsByTagName("user");
        Element user = (Element)users.item(0);

        return "";**/

    }

    private void doesThePageExist() {
        boolean redirected = true;
        Nodelist pages = document.getElementsByTagName("pages");
        Element page = (Element) pages.item(0);
        if (page.getAttribute("idx").equals(-1)) {
            redirected = false;
            System.out.println("The page does not exist.");
        }
    }

    private String replaceSpaceWithPluses(String articleName) {
        return "";
    }

}
