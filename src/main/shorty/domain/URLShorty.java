package main.shorty.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by NERF on 16/10/2015.
 */
public class URLShorty {

    /*
        Container for key/value shortURL/LongUrl
     */
    private HashMap<String, String> keyToUrlMap;

    // TODO: Add copy of the hashMap but inverted.

    /*
        Set current domain.
     */
    private String domain;

    /*
        Set of characters to be used to generate short url.
     */
    private static final char characters[] = new char[]{'0','1','2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /*
        Instantiate random to generate unique key.
     */
    private Random random;

    /*
        Max key length.
     */
    private static final int MAXIMUM_KEY_LENGTH = 5;

    /**
     * Constructor.
     */
    public URLShorty() {
        random = new Random();
    }

    /**
     * Constructor.
     * @param domainURL
     */
    public URLShorty(String domainURL, HashMap<String, String> currentPairs) throws MalformedURLException {
        this();
        this.keyToUrlMap = currentPairs;

        if(!domainURL.isEmpty()) {
            this.domain = getDomainFromUrl(domainURL);
        }
    }

    /**
     * Return the short url (aka Key) with domain in it from hashMap.
     *
     * @param longURL
     * @return  short url
     */
    public String getShortURL(String longURL) {
        String shortURL = "";

        // TODO: Add a url validation

        if(keyToUrlMap.containsValue(longURL)) {
            shortURL = domain + "/" + getKeyFromValue(longURL);
        }
        else {
            shortURL = domain + "/" + getKey(longURL);
        }

        return shortURL;
    }

    /**
     * Return the long url (aka Value) from hashMap.
     *
     * @param shortURL
     * @return  long url
     */
    public String getLongURL(String shortURL) {
        String key = shortURL.substring(domain.length() +1);
        String exception = "There is no value saved under this key.";
        if(keyToUrlMap.get(key) == null)
            return exception;
        else
            return keyToUrlMap.get(key);
    }

    /**
     * Generate a 5 digit unique key from the array of characters.
     *
     * @return  key
     */
    private String generateShortURL(){
        boolean flag = true;
        String key = "";

        while(flag) {
            for(int i = 0; i <= MAXIMUM_KEY_LENGTH; i++) {
                key += characters[random.nextInt(characters.length)];
            }

            if(!keyToUrlMap.containsKey(key)) {
                flag = false;
            }
        }

        return key;
    }

    /**
     * Retrieve the key associated with the value (longURL). This is not
     * great... what is the point of using hashMap? Might be faster to
     * have a second hashMap and invert key/value.
     *
     * @param longURL
     * @return  key
     */
    private String getKeyFromValue(String longURL) {
        for (String entry: keyToUrlMap.keySet()){
            String key =entry.toString();
            String value = keyToUrlMap.get(entry).toString();

            if(longURL.equals(value)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Return the key generated. Also, add the newly created unique key
     * paired with his value (long url).
     *
     * @param longURL
     * @return  key
     */
    private String getKey(String longURL) {
        String key = generateShortURL();
        keyToUrlMap.put(key, longURL);
        return key;
    }

    /**
     * Return only the domain from the complete url (clean).
     *
     * @param domainURL
     * @return  domain
     */
    private String getDomainFromUrl(String domainURL) throws MalformedURLException {
        URL url = new URL(domainURL);
        return url.getHost();
    }

    /**
     * Getter. (to be able to save in file, batch job like)
     */
    public HashMap<String, String> getCurrentKeyToUrlMap() {
        return keyToUrlMap;
    }

    /**
     * Print current hash map. (debug purpose)
     */
    public void printAllCurrentKeyToUrlMap() {
        for (String entry: keyToUrlMap.keySet()){

            String key =entry.toString();
            String value = keyToUrlMap.get(entry).toString();
            System.out.println("Key: " + key + "\tValue: " + value + "\tShortened: " + getShortURL(value) + "\tExpanded: " + getLongURL(getShortURL(value)) );

        }
    }

}
