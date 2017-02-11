package edu.bsu.cs222.twp.revisions;

import org.w3c.dom.Element;

public class Revisions {
    private String userName;
    private String timeStamp;

    public Revisions(String userName,String timeStamp) {
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    public Revisions(Element revisionElement) {
        this.userName = revisionElement.getAttribute("user");
        this.timeStamp = revisionElement.getAttribute("timestamp");
    }


}

