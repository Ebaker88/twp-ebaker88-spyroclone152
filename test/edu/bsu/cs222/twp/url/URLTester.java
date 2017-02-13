package edu.bsu.cs222.twp.url;

import edu.bsu.cs222.twp.url.URLConnector;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class URLTester {

    @Test
    public void testCatURL() throws IOException {
        URLConstructor catURL = new URLConstructor();
        catURL.constructURL("cat");
        Assert.assertTrue(catURL.constructURL("cat").equals("https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles=cat" +
                "&rvprop=timestamp|user&rvlimit=30&RedirectParser"));
    }
}

