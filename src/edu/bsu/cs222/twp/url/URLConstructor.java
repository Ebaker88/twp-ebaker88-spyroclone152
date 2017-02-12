package edu.bsu.cs222.twp.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConstructor {
    public InputStream constructURL(String pageName) throws IOException {
        String title = (String) URLEncoder.encode(pageName, "UTF-8");
        URL wikipediaPage = new URL("https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles=" + title + "&rvprop=timestamp|user&rvlimit=4&redirects");
        URLConnection connection = wikipediaPage.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa16; me@bsu.edu)");
        return connection.getInputStream();
    }




}
