package edu.bsu.cs222.twp.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConstructor {
    public String constructURL(String pageName) throws IOException {
        String title = (String) URLEncoder.encode(pageName, "UTF-8");
        String urlPath = ("https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles=" + title + "&rvprop=timestamp|user&rvlimit=30&redirects");
        return urlPath;
    }


}
