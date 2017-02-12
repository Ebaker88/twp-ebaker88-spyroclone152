package edu.bsu.cs222.twp.url;

import edu.bsu.cs222.twp.url.URLConnector;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class URLTester {

    @Test
    public void testCatURL() throws IOException {
        URLConnector url = new URLConnector();
        url.setUpURL("cat");
        System.out.println(url.printURL());
        Assert.assertTrue(url.printURL().equals("https://en.wikipedia.org/wiki/cat"));

    }

    @Test
    public void testXMLConnection() throws IOException {
        URLConnector url = new URLConnector();
        url.setUpTrueURL("cat");


    }
}
