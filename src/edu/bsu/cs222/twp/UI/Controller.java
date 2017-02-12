package edu.bsu.cs222.twp.UI;

import edu.bsu.cs222.twp.parser.RevisionParser;
import edu.bsu.cs222.twp.url.URLConnector;
import edu.bsu.cs222.twp.url.URLConstructor;
import edu.bsu.cs222.twp.xml.XMLBuilder;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Controller {
    public TextField userURL = new TextField();
    public InputStream XMLStream;

    //Super Special Awesome Mega Duper Luper Method == the big red button that does everything
    public void getWikipediaPageChanges(ActionEvent actionEvent) throws IOException, ParserConfigurationException, SAXException {
        URLConstructor newURL = new URLConstructor();
        newURL.constructURL(String.valueOf(userURL));

        URLConnector pageURL = new URLConnector();

        XMLStream = pageURL.establishURLConnection(newURL.toString());

        RevisionParser revisions = new RevisionParser();


        revisions.parse(XMLStream);





    }
}
