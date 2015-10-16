package main.shorty.business;

import java.io.IOException;
import java.util.HashMap;

/**
 * TODO: Class for db interactions.
 */
public class URLShortyDao implements URLShortyService{
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

    }

    @Override
    public HashMap<String, String> loadAll() throws IOException {
        return null;
    }
}
