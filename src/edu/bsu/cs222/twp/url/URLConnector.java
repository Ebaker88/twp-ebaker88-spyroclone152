package edu.bsu.cs222.twp.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnector {


    public InputStream establishURLConnection(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa16; me@bsu.edu)");
        return connection.getInputStream();
    }
}
