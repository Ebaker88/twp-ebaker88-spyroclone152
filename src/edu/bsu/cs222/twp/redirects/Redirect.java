package edu.bsu.cs222.twp.redirects;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Redirect {
    private String redirectedTo;
    private String redirectedFrom;
    public Redirect(Element ele){
     this.redirectedFrom = ele.getAttribute("From: ");
     this.redirectedTo = ele.getAttribute("To: ");
    }

    public Redirect(String From, String To){
        redirectedFrom = From;
        redirectedTo = To;
    }


    public String getRedirectedFrom()
    {
        return redirectedFrom;
    }

    public String getRedirectedTo()
    {
        return redirectedTo;
    }



}
