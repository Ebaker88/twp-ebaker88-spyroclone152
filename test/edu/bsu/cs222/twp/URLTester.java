package edu.bsu.cs222.twp;

import edu.bsu.cs222.twp.src.URLFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTester {

    @Test
    public void testCatURL() throws IOException {
        URLFactory url = new URLFactory();
        url.setUpURL("cat");
        System.out.println(url.printURL());
        Assert.assertTrue(url.printURL().equals("https://en.wikipedia.org/wiki/cat"));

    }
}
