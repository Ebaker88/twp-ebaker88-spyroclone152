package edu.bsu.cs222.twp.url;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLFactory {

    private URL url = new URL("https://en.wikipedia.org") ;
    private Document document;

    public URLFactory() throws MalformedURLException {
    }


    public void setUpURL(String URLInput) throws IOException {
        URL NewURL = new URL("https://en.wikipedia.org/wiki/" + URLInput);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa16; me@bsu.edu)");
        InputStream in = connection.getInputStream();
        url = NewURL;

    }

    public void setUpTrueURL(String newInput) throws IOException{
        String title = (String)URLEncoder.encode(newInput, "UTF-8");
        URL wikipediaPage = new URL("https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles=" + title + "&rvprop=timestamp|user&rvlimit=4&redirects");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa16; me@bsu.edu)");
        InputStream in = connection.getInputStream();
        url = wikipediaPage;

    }

    public boolean isRedirected(URL input){
        NodeList children = document.getChildNodes();
        Element rssElement = (Element)children.item(0);
    }


    public String printURL() throws MalformedURLException {
        return url.toString();
    }
}
