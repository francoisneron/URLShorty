package main.shorty.business;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Interview purpose.
 */
public class URLShortyFile implements URLShortyService {

    private HashMap<String, String> keyToLongURL;

    Properties prop;
    OutputStream output = null;
    InputStream input = null;

    public URLShortyFile() throws FileNotFoundException {
        keyToLongURL = new HashMap<String, String>();
        prop = new Properties();
    }

    @Override
    public void save(String key, String longURL) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void getKey(String longURL) {

    }

    @Override
    public void getValue(String key) {

    }

    @Override
    public void saveAll(HashMap<String, String> keyToLongURL) throws IOException {

        System.out.println("Saving all new shorten urls...");

        output = new FileOutputStream("config.properties");

        for (Map.Entry<String, String> e : keyToLongURL.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();

            if(prop.getProperty(key,value) != null)
                prop.setProperty(key, value);
        }

        prop.store(output, null);

        output.close();
    }

    @Override
    public HashMap<String, String> loadAll() throws IOException {

        System.out.println("Loading all previous shorten urls...");

        HashMap<String, String> keyToValueMap = new HashMap<String, String>();

        input = new FileInputStream("config.properties");

        prop.load(input);

        Enumeration<?> e = prop.propertyNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);

            keyToValueMap.put(key, value);
        }

        input.close();

        return keyToValueMap;

    }
}
