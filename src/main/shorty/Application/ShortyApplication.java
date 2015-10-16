package main.shorty.Application;

import main.shorty.business.URLShortyFile;
import main.shorty.domain.URLShorty;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

/*
*   TODO: Add database interactions.
*   TODO: Probably a good thing to do webservice. (Add new url return shorten url)
*   TODO: Finish tests.
*   TODO: Better exceptions handling.
 */
public class ShortyApplication {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URLShortyFile file = new URLShortyFile();

        HashMap<String,String> mostRecentKeyToValueMap = file.loadAll();

        URLShorty u = new URLShorty("http://cl.ip/", mostRecentKeyToValueMap);

        String addUrl = "http://www.bob.com/";

        System.out.println("URL:" + addUrl + "\tShortened: " + u.getShortURL(addUrl) + "\tExpanded: " + u.getLongURL(u.getShortURL(addUrl)));

        u.printAllCurrentKeyToUrlMap();

        file.saveAll(u.getCurrentKeyToUrlMap());
    }
}
