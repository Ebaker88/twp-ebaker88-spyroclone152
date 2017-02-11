package edu.bsu.cs222.twp;

import edu.bsu.cs222.twp.url.URLFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class URLTester {

    @Test
    public void testCatURL() throws IOException {
        URLFactory url = new URLFactory();
        url.setUpURL("cat");
        System.out.println(url.printURL());
        Assert.assertTrue(url.printURL().equals("https://en.wikipedia.org/wiki/cat"));

    }

    @Test
    public void testXMLConnection() throws IOException {
        URLFactory url = new URLFactory();
        url.setUpTrueURL("cat");


    }
}
