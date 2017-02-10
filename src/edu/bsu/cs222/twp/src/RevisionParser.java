package edu.bsu.cs222.twp.src;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RevisionParser {

    public void setUpURL(String URLInput) throws IOException {
        URL url = new URL("https://en.wikipedia.org");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa16; me@bsu.edu)");
        InputStream in = connection.getInputStream();
    }
}
