package edu.bsu.cs222.twp.UI;

import edu.bsu.cs222.twp.parser.RevisionParser;
import edu.bsu.cs222.twp.revisions.Revisions;
import edu.bsu.cs222.twp.url.URLConnector;
import edu.bsu.cs222.twp.url.URLConstructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Controller {
    public TextField userURL = new TextField();
    public InputStream XMLStream;
    public Button bigRedButton;
    public ListView listView;
    public VBox vBoxWindow;


    //Super Special Awesome Mega Duper Luper Method == the big red button that does everything
    public void getWikipediaPageChanges(ActionEvent actionEvent) throws IOException, ParserConfigurationException, SAXException {
        URLConstructor newURL = new URLConstructor();
        String urlPath = newURL.constructURL(userURL.getText());
        URLConnector urlConnector = new URLConnector();
        XMLStream = urlConnector.establishURLConnection(urlPath);
        RevisionParser revisions = new RevisionParser();
        List<Revisions> revList  = revisions.parse(XMLStream);
        List<String> revStringList = new ArrayList<>();
        for (Revisions rev: revList )
        {
            revStringList.add(rev.toString());
        }

        ObservableList<String> revObsList = FXCollections.observableArrayList(revStringList);

        listView = new ListView<String>();

        listView.setItems(revObsList);

        vBoxWindow.getChildren().add(listView);


    }
}
